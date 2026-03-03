package com.billing.pos.error;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(int id) {
        super("Item id not found : " + id);
    }

}
