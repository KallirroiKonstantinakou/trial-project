package org.netcompany.accounts.account.model;

import java.time.LocalDate;

/**
 * TransactionInfo Model
 */
public class TransactionInfo {

	private long transactionId;
	private long accoundId;
	private double ammount;
	private TransactionType type;
	private LocalDate date;

	public TransactionInfo() {

	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public void setAccoundId(long accoundId) {
		this.accoundId = accoundId;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public long getAccoundId() {
		return accoundId;
	}

	public double getAmmount() {
		return ammount;
	}

	public TransactionType getType() {
		return type;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "TransactionInfo [transactionId=" + transactionId + ", accoundId=" + accoundId + ", ammount=" + ammount
				+ ", type=" + type + ", date=" + date + "]";
	}

}
