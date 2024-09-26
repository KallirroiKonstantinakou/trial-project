package org.netcompany.accounts.account.services.ammountInfo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.netcompany.accounts.account.model.BeneficiaryInfo;
import org.netcompany.accounts.account.model.TransactionInfo;
import org.netcompany.accounts.account.model.TransactionType;
import org.netcompany.accounts.account.services.beneficiaryinfo.BeneficiaryInfoService;
import org.netcompany.accounts.account.services.transactioninfo.TransactionInfoService;

import jakarta.inject.Inject;

/**
 * AmountInfoService
 */
public class AmountInfoServiceImpl implements AmountInfoService {

	@Inject
	private TransactionInfoService transactionInfoService;
	@Inject
	private BeneficiaryInfoService beneficiaryInfoService ;

	/**
	 * Method Retrieve amount based on last name
	 * 
	 *@TODO some questions about this method
	 *(which is the initial amount and we want retrieve amount based on last name)
	 *
	 * @return amount 
	 */
	public double retrieveListTrancationInfoBasedOnLastName(String lastName) {

		BeneficiaryInfo beneficiaryInfo = beneficiaryInfoService
				.retrieveBeneficiaryInfoBasedOnBeneficiaryLastName(lastName);
		if (beneficiaryInfo != null) {
			List<TransactionInfo> listTrancationInfoBasedOnLastName = transactionInfoService
					.retrieveTransactionInfoBasedOnBeneficiaryId(beneficiaryInfo.getBeneficiaryId());

			Collections.sort(listTrancationInfoBasedOnLastName, Comparator.comparing(TransactionInfo::getDate));
			double ammount = listTrancationInfoBasedOnLastName.getFirst().getAmmount();
			for (TransactionInfo transactionInfo : listTrancationInfoBasedOnLastName) {
				if (transactionInfo.getType().equals(TransactionType.DEPOSIT))
					ammount = ammount + transactionInfo.getAmmount();
				else {
					if (ammount > transactionInfo.getAmmount())
						ammount = ammount - transactionInfo.getAmmount();
					else
						ammount = 0.0;
				}
			}
			return ammount;
		}
		return 0.0;

	}

	/**
	 * Method Retrieve max deposit of last month based on beneficiaryId
	 *
	 * @return max deposit that will be returned .
	 */
	public double retrieveMaxDepositOfLastMonthBasedhOnBeneficiaryId(long beneficiaryId) {

		List<TransactionInfo> listTrancationInfoBasedOnBeneficiaryId = transactionInfoService
				.retrieveTransactionInfoBasedOnBeneficiaryId(beneficiaryId);

		LocalDate lastDate = listTrancationInfoBasedOnBeneficiaryId.stream()
				.map(TransactionInfo::getDate)
				.max(LocalDate::compareTo)
				.get();
		double getTransactionsOfLastMonth = listTrancationInfoBasedOnBeneficiaryId.stream()
				.filter(transactionInfo -> transactionInfo.getDate().getMonth().equals(lastDate.getMonth())
						&& transactionInfo.getType().equals(TransactionType.DEPOSIT))
				.map(TransactionInfo::getAmmount)
				.max(Double::compareTo)
				.get();

		return getTransactionsOfLastMonth;

	}

}
