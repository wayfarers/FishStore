package org.genia.fishstore.entities;

public enum Role {
	GENERAL_MANAGER(1),
	COLD_STORE_MANAGER(2),
	ACCOUNTANT(3),
	SECURITY_OFFICER(4); // The administrator account who can create other accounts
	
	private final int value;
    private Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
