package org.netcompany.accounts.account.services.beneficiaryinfo;

import java.util.List;
import org.netcompany.accounts.account.exceptions.DataNotFoundException;
import org.netcompany.accounts.account.mappers.BeneficiaryInfoMapper;
import org.netcompany.accounts.account.model.BeneficiaryInfo;
import org.netcompany.accounts.account.services.filereader.FileReaderUtility;

/**
 * BeneficiaryInfo Service
 * 
 */
public class BeneficiaryInfoServiceImpl implements BeneficiaryInfoService {

	private final String fileName = "beneficiaries.csv";

	/**
	 * Method Retrieve All Beneficiary Info 
	 *
	 * @return List<BeneficiaryInfo> 
	 */
	public List<BeneficiaryInfo> retrieveAllBeneficiaryInfo() {

		List<List<String>> listBeneficiaryInfo = new FileReaderUtility().readFromFile(fileName);

		return new BeneficiaryInfoMapper().map(listBeneficiaryInfo);

	}

	/**
	 * Method Retrieve a Beneficiary Info based on LastName
	 *
	 * @return BeneficiaryInfo
	 * @throws DataNotFoundException when there is not beneficiary for this lastname
	 */
	public BeneficiaryInfo retrieveBeneficiaryInfoBasedOnBeneficiaryLastName(String lastName) {

		List<BeneficiaryInfo> listBeneficiaryInfo = retrieveAllBeneficiaryInfo();
		
		for (BeneficiaryInfo beneficiaryInfoInfo : listBeneficiaryInfo) {
			if (beneficiaryInfoInfo.getLastName().equals(lastName))
				return beneficiaryInfoInfo;
		};
		throw new DataNotFoundException("Data not found for this beneficiary");

	}

}
