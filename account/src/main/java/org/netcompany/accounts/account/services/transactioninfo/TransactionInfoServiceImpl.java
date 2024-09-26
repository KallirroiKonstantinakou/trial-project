package org.netcompany.accounts.account.services.transactioninfo;

import java.util.List;
import java.util.stream.Collectors;
import org.netcompany.accounts.account.exceptions.DataNotFoundException;
import org.netcompany.accounts.account.mappers.TransactionInfoMapper;
import org.netcompany.accounts.account.model.AccountInfo;
import org.netcompany.accounts.account.model.TransactionInfo;
import org.netcompany.accounts.account.services.accountinfo.AccountInfoService;
import org.netcompany.accounts.account.services.filereader.FileReaderUtility;
import jakarta.inject.Inject;

/**
 * TransactionInfoService
 */
public class TransactionInfoServiceImpl implements TransactionInfoService {

	private final String fileName = "transactions.csv";
	
	@Inject
	private AccountInfoService accountInfoService;

	/**
	 * Method Retrieve transaction info of a beneficiary 
	 *
	 * @return List<TransactionInfo> 
	 * @throws DataNotFoundException when there is not transaction info for this beneficiary
	 */
	public List<TransactionInfo> retrieveTransactionInfoBasedOnBeneficiaryId(long beneficairyId) {

		List<TransactionInfo> mappedListTransactionInfo = retrieveAllTransactionInfo();
		List<AccountInfo> acountInfoList = accountInfoService.retrieveAllAccountInfo();
		List<TransactionInfo> finalListTransactionInfo = mappedListTransactionInfo.stream()
				.filter(transactionInfo -> acountInfoList.stream()
						.anyMatch(acountInfo -> acountInfo.getBeneficiaryId() == beneficairyId
								&& transactionInfo.getAccoundId() == acountInfo.getAccountId()))
				.collect(Collectors.toList());

		if (finalListTransactionInfo.isEmpty())
			throw new DataNotFoundException("Data not Found for this beneficiary");

		return finalListTransactionInfo;

	}

	/**
	 * Method Retrieve all transaction info 
	 *
	 * @return List<TransactionInfo>
	 */
	public List<TransactionInfo> retrieveAllTransactionInfo() {

		List<List<String>> listAllTransactionInfo = new FileReaderUtility().readFromFile(fileName);

		return new TransactionInfoMapper().map(listAllTransactionInfo);

	}

}
