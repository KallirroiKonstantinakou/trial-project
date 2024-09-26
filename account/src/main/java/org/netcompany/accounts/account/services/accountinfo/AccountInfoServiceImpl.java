package org.netcompany.accounts.account.services.accountinfo;

import java.util.List;
import java.util.stream.Collectors;
import org.netcompany.accounts.account.exceptions.DataNotFoundException;
import org.netcompany.accounts.account.mappers.AccountInfoMapper;
import org.netcompany.accounts.account.model.AccountInfo;
import org.netcompany.accounts.account.services.filereader.FileReaderUtility;

/**
 * AccountInfo Service
 * 
 */
public class AccountInfoServiceImpl implements AccountInfoService {

	private final String fileName = "accounts.csv";

	/**
	 * Method Retrieve Account Info of a beneficiary
	 *
	 * @return List<AccountInfo>
	 * @throws DataNotFoundException when there is not account info for this
	 *                               beneficiary
	 */
	public List<AccountInfo> retrieveAllAccountInfoBasedOnBeneficiaryId(long beneficairyId) {

		List<AccountInfo> listAccountInfo = retrieveAllAccountInfo();
		List<AccountInfo> accountInfoBasedOnBeneficiaryId = listAccountInfo.stream()
				.filter(accountInfo -> beneficairyId == accountInfo.getBeneficiaryId())
				.collect(Collectors.toList());

		if (accountInfoBasedOnBeneficiaryId.isEmpty())
			throw new DataNotFoundException("Data not Found for this beneficiary");

		return accountInfoBasedOnBeneficiaryId;

	}

	/**
	 * Method Retrieve Account Info of all beneficiaries
	 *
	 * @return List<AccountInfo>
	 * 
	 */
	public List<AccountInfo> retrieveAllAccountInfo() {

		List<List<String>> listAllAccountInfo = new FileReaderUtility().readFromFile(fileName);

		return new AccountInfoMapper().map(listAllAccountInfo);

	}

}
