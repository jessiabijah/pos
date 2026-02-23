package com.billing.pos.error;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super("Item id not found : " + id);
    }

}
