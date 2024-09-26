package org.netcompany.accounts.account.model;

/**
 * AccountInfo Model
 */
public class AccountInfo {

	private long accountId;
	private long beneficiaryId;

	public AccountInfo() {
		super();

	}

	public long getAccountId() {
		return accountId;
	}

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@Override
	public String toString() {
		return "AccountInfo [accountId=" + accountId + ", beneficiaryId=" + beneficiaryId + "]";
	}

}
