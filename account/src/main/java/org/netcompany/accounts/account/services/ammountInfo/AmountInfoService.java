package org.netcompany.accounts.account.services.ammountInfo;

public interface AmountInfoService {

	public double retrieveListTrancationInfoBasedOnLastName(String lastName);

	public double retrieveMaxDepositOfLastMonthBasedhOnBeneficiaryId(long beneficiaryId);

}
