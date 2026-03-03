package com.billing.pos;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {


	    ELECTRONICS("Electronics"),
	    CLOTHING("Clothing"),
	    GROCERY("Grocery"),
	    FURNITURE("Furniture"),
	    BOOKS("Books"),
	    TOYS("Toys"),
	    SPORTS("Sports"),
	    BEAUTY("Beauty & Personal Care"),
	    HEALTH("Health & Wellness"),
	    AUTOMOTIVE("Automotive"),
	    JEWELRY("Jewelry"),
	    FOOTWEAR("Footwear"),
	    STATIONERY("Stationery"),
	    PET_SUPPLIES("Pet Supplies"),
	    BABY_PRODUCTS("Baby Products"),
	    HOME_APPLIANCES("Home Appliances"),
	    GARDEN("Garden & Outdoors"),
	    MOBILE_ACCESSORIES("Mobile Accessories"),
	    COMPUTERS("Computers & Accessories"),
	    KITCHENWARE("Kitchenware & Utensils");

	    private final String displayName;

	    Category(String displayName) {
	        this.displayName = displayName;
	    }

	    @JsonValue
	    public String getDisplayName() {
	        return displayName;
	    }
	}
