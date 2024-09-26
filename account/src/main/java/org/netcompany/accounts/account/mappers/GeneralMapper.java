package org.netcompany.accounts.account.mappers;

import java.util.List;

/**
 * General Mapper
 * 
 */
public interface GeneralMapper<T> {

	public List<T> map(List<List<String>> list);

}
