package com.billing.pos.error;

import java.util.Set;

public class ItemUnSupportedFieldPatchException extends RuntimeException {

    public ItemUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
