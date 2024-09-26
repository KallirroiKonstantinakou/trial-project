package org.netcompany.accounts.account.services.accountinfo;

import java.util.List;

import org.netcompany.accounts.account.model.AccountInfo;

public interface AccountInfoService {

	public List<AccountInfo> retrieveAllAccountInfoBasedOnBeneficiaryId(long beneficairyId);
	
	public List<AccountInfo> retrieveAllAccountInfo();
}
