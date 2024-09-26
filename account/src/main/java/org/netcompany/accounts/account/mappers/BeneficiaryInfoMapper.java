package org.netcompany.accounts.account.mappers;

import java.util.ArrayList;
import java.util.List;

import org.netcompany.accounts.account.model.BeneficiaryInfo;

/**
 * BeneficiaryInfoMapper
 *
 * Map to List<BeneficiaryInfo>
 */
public class BeneficiaryInfoMapper implements GeneralMapper<BeneficiaryInfo> {

	/**
	 * Method Map to List of BeneficiaryInfo
	 * 
	 * map the list of content of csv file to list of a BeneficiaryInfo
	 *
	 * @return List<BeneficiaryInfo>
	 */
	@Override
	public List<BeneficiaryInfo> map(List<List<String>> listBeneficiaryInfo) {
		List<BeneficiaryInfo> mapListBeneficiaryInfo = new ArrayList<>();
		listBeneficiaryInfo.forEach((innerList) -> {
			BeneficiaryInfo beneficiaryInfo = new BeneficiaryInfo();
			beneficiaryInfo.setBeneficiaryId(Long.valueOf(innerList.getFirst()));
			beneficiaryInfo.setFirstName(innerList.get(1));
			beneficiaryInfo.setLastName(innerList.getLast());
			mapListBeneficiaryInfo.add(beneficiaryInfo);

		});

		return mapListBeneficiaryInfo;
	}

}
