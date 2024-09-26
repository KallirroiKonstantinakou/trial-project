package org.netcompany.accounts.account.model;

/*
 * Enum for the transaction type
 * 
 * */
public enum TransactionType {

	/* withdrawal transaction */
	WITH_DRAWAL("withdrawal"),

	/* deposit transaction */
	DEPOSIT("deposit"),

	/* undefined transaction */
	UNDEFINED_TYPE("null");

	private String type;

	TransactionType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public static TransactionType fromStringToTrasactionType(String type) {
		for (TransactionType trancactionType : TransactionType.values()) {
			if (trancactionType.getType().equals(type)) {
				return trancactionType;
			}
		}
		return TransactionType.UNDEFINED_TYPE;
	}
}
