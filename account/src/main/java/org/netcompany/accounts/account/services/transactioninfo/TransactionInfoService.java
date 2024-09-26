package org.netcompany.accounts.account.services.transactioninfo;

import java.util.List;

import org.netcompany.accounts.account.model.TransactionInfo;

public interface TransactionInfoService {
	
	public List<TransactionInfo> retrieveTransactionInfoBasedOnBeneficiaryId(long beneficairyId);

	public List<TransactionInfo> retrieveAllTransactionInfo();
}
