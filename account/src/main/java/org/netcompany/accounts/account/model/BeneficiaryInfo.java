package org.netcompany.accounts.account.model;

/**
 * BeneficiaryInfo Model
 */
public class BeneficiaryInfo {

	private long beneficiaryId;
	private String firstName;
	private String lastName;

	public BeneficiaryInfo() {
		super();

	}

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AccountInfo [beneficiaryId=" + beneficiaryId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
