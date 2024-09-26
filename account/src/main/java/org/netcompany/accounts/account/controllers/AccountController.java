package org.netcompany.accounts.account.controllers;

import java.util.List;

import org.netcompany.accounts.account.model.AccountInfo;
import org.netcompany.accounts.account.model.BeneficiaryInfo;
import org.netcompany.accounts.account.model.TransactionInfo;
import org.netcompany.accounts.account.services.accountinfo.AccountInfoService;
import org.netcompany.accounts.account.services.ammountInfo.AmountInfoService;
import org.netcompany.accounts.account.services.beneficiaryinfo.BeneficiaryInfoService;
import org.netcompany.accounts.account.services.transactioninfo.TransactionInfoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Account Controller (exposed at "accounts" path)
 */

@Path("accounts")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

	
	@Inject
	private BeneficiaryInfoService beneficiaryInfoService ;
	@Inject
	private AccountInfoService accountInfoService;
	@Inject
	private TransactionInfoService transactionInfoService;
	@Inject
	private AmountInfoService amountInfoService;

	/**
	 * Method handling HTTP GET requests.
	 * 
	 * return all beneficiary info
	 *
	 * @return List<BeneficiaryInfo> that will be returned as a json response.
	 */
	@GET
	@Path("/beneficiaryinfo")
	public List<BeneficiaryInfo> retrieveAllBeneficiaryInfo() {
		return beneficiaryInfoService.retrieveAllBeneficiaryInfo();
	}

	/**
	 * Method handling HTTP GET requests.
	 *
	 * return all account info based on beneficiary id
	 *
	 * @return List<AccountInfo> that will be returned as a json response.
	 */
	@GET
	@Path("/accountinfo/{id}")
	public List<AccountInfo> retrieveAccountInfo(@PathParam("id") long beneficairyId) {
		return accountInfoService.retrieveAllAccountInfoBasedOnBeneficiaryId(beneficairyId);
	}

	/**
	 * Method handling HTTP GET requests. .
	 *
	 * return transaction info base on beneficiary id
	 *
	 * @return List<TransactionInfo> that will be returned as a json response.
	 */
	@GET
	@Path("/transactioninfo/{id}")
	public List<TransactionInfo> retrieveTransactionInfo(@PathParam("id") long beneficairyId) {
		return transactionInfoService.retrieveTransactionInfoBasedOnBeneficiaryId(beneficairyId);
	}

	/**
	 * Method handling HTTP GET requests.
	 *
	 * return amount based on last name
	 *
	 * @return double that will be returned as a json response.
	 */
	@GET
	@Path("/amount/{name}")
	public double retrieveTransactionInfoBasedOnName(@PathParam("name") String name) {
		return amountInfoService.retrieveListTrancationInfoBasedOnLastName(name);
	}

	/**
	 * Method handling HTTP GET requests.
	 *
	 * return max deposit of last month based on beneficiary id
	 *
	 * @return double that will be returned as a json response.
	 */
	@GET
	@Path("/maxdepositlastmonth/{id}")
	public double retrieveMaxDepositOfLastMonth(@PathParam("id") long beneficairyId) {
		return amountInfoService.retrieveMaxDepositOfLastMonthBasedhOnBeneficiaryId(beneficairyId);
	}

}
