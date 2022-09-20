package org.doordash.ObjectRepository;

public enum EdishNames {
	NYORKSHIRELAMBPATTIES("Yorkshire Lamb Patties"), NLOBSTERTHERMIDOR("Lobster Thermidor"), NSTUFFEDJACKETPOTATOES("Stuffed Jacket Potatoes"),	
	EPINKSPAGHETTIGAMBERONI("Pink Spaghetti Gamberoni"), ECHEESYMASHEDPOTATO("Cheesy Mashed Potato"), ECRISPYCHICKENSTRIPS("Crispy Chicken Strips"), ELEMONGRILLEDCHICKENANDPASTA("Lemon Grilled Chicken And Pasta"),
	NXVEGETABLEFRIEDRICE("Vegetable Fried Rice"), NXPRAWNCRACKERS("Prawn Crackers"), NXSPRINGROLLS("Spring Rolls"), NXMANCHURIANCHICKEN("Manchurian Chicken"),
	HLCHICKENMADEIRA("Chicken Madeira"), HLBUFFALOWINGS("Buffalo Wings"), HLMACNCHEESEBITES("Mac N Cheese Bites"), HLSIGNATUREPOTATOTWISTERS("Signature Potato Twisters"), HLMEATBALLSPENNEPASTA("Meatballs Penne Pasta");

	private String dishName;
	private EdishNames(String dishName) {
		this.dishName = dishName;
	}
	
	public String getDishName() {
		return dishName;
	}
}
