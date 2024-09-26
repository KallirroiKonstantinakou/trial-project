package org.netcompany.accounts.account;


import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.netcompany.accounts.account.services.accountinfo.AccountInfoService;
import org.netcompany.accounts.account.services.accountinfo.AccountInfoServiceImpl;
import org.netcompany.accounts.account.services.ammountInfo.AmountInfoService;
import org.netcompany.accounts.account.services.ammountInfo.AmountInfoServiceImpl;
import org.netcompany.accounts.account.services.beneficiaryinfo.BeneficiaryInfoService;
import org.netcompany.accounts.account.services.beneficiaryinfo.BeneficiaryInfoServiceImpl;
import org.netcompany.accounts.account.services.transactioninfo.TransactionInfoService;
import org.netcompany.accounts.account.services.transactioninfo.TransactionInfoServiceImpl;
import jakarta.ws.rs.ext.Provider;

/*
 * AppBinder
 * 
 *Bind services for dependency injection 
 */
@Provider
public class AppBinder extends AbstractBinder {

	
	protected void configure() {
		
		bind(BeneficiaryInfoServiceImpl.class).to(BeneficiaryInfoService.class).in(RequestScoped.class);
		bind(AccountInfoServiceImpl.class).to(AccountInfoService.class).in(RequestScoped.class);
		bind(TransactionInfoServiceImpl.class).to(TransactionInfoService.class).in(RequestScoped.class);
		bind(AmountInfoServiceImpl.class).to(AmountInfoService.class).in(RequestScoped.class);
	}

}
