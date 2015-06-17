package org.genia.fishstore.entities;

public enum OrderStatus {
	AWAITING_APPROVAL(1), APPROVED_FOR_SHIPPMENT(2), READY_TO_SHIP(3), SHIPPED(4);

	private final int value;
    private OrderStatus(int value) {
        this.value = value;
    }

    
    public int getValue() {
        return value;
    }
}
