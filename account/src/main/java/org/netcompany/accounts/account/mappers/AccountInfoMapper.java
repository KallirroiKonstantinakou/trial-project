package org.netcompany.accounts.account.mappers;

import java.util.ArrayList;
import java.util.List;

import org.netcompany.accounts.account.model.AccountInfo;

/**
 * AccountInfoMapper
 *
 * Map to List<AccountInfo>
 */
public class AccountInfoMapper implements GeneralMapper<AccountInfo> {

	/**
	 * Method Map to List of AccountInfo
	 * 
	 * map the list of content of csv file to list of a AccountInfo
	 *
	 * @return List<AccountInfo> that will be returned the List of All AccountInfo .
	 */
	@Override
	public List<AccountInfo> map(List<List<String>> listAccountInfo) {
		List<AccountInfo> mapListAccountInfo = new ArrayList<>();
		listAccountInfo.forEach((innerList) -> {
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(Long.valueOf(innerList.getFirst()));
			accountInfo.setBeneficiaryId(Long.valueOf(innerList.getLast()));
			mapListAccountInfo.add(accountInfo);

		});

		return mapListAccountInfo;

	}

}
