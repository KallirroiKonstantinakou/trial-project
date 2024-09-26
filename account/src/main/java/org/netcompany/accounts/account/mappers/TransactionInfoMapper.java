package org.netcompany.accounts.account.mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.netcompany.accounts.account.model.TransactionInfo;
import org.netcompany.accounts.account.model.TransactionType;

/**
 * TransactionInfoMapper
 *
 * Map to List<TransactionInfo>
 */
public class TransactionInfoMapper implements GeneralMapper<TransactionInfo> {

	/**
	 * Method Map to List of TransactionInfo
	 * 
	 * map the list of content of a csv file to list of a TransactionInfo
	 *
	 * @return List<TransactionInfo>
	 */
	@Override
	public List<TransactionInfo> map(List<List<String>> listTransactionInfo) {
		List<TransactionInfo> mapListTransactionInfo = new ArrayList<>();
		listTransactionInfo.forEach((innerList) -> {
			TransactionInfo transactionInfo = new TransactionInfo();
			transactionInfo.setTransactionId(Long.valueOf(innerList.getFirst()));
			transactionInfo.setAccoundId(Long.valueOf(innerList.get(1)));
			transactionInfo.setAmmount(Double.valueOf(innerList.get(2)));
			transactionInfo.setType(TransactionType.fromStringToTrasactionType(innerList.get(3)));
			transactionInfo.setDate(LocalDate.parse(innerList.getLast(), DateTimeFormatter.ofPattern("MM/dd/yy")));
			mapListTransactionInfo.add(transactionInfo);

		});

		return mapListTransactionInfo;
	}

}
