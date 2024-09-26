package org.netcompany.accounts.account.services.beneficiaryinfo;

import java.util.List;

import org.netcompany.accounts.account.model.BeneficiaryInfo;

public interface BeneficiaryInfoService {
	
	public List<BeneficiaryInfo> retrieveAllBeneficiaryInfo() ;
	
	public BeneficiaryInfo retrieveBeneficiaryInfoBasedOnBeneficiaryLastName(String lastName);

}
