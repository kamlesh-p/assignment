package com.kam.common;

public enum CardType {

	VISA("Visa"), AMERICAN_EXPRESS("American Express"), DINERS_CLUB("Diner's Club");

	private String value;

	private CardType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
