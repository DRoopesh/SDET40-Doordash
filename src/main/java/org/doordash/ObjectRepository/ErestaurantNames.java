package org.doordash.ObjectRepository;

public enum ErestaurantNames {
	
	NORTHSTREETTAVERN("North Street Tavern"), EATALY("Eataly"), NANXIANGXIAOBAO("Nan Xiang Xiao Long Bao"),HIGHLANDSBARGRILL("Highlands Bar & Grill");
	
	private String restaurant;
	private ErestaurantNames(String restaurant) {
		this.restaurant = restaurant;
	}
	
	public String getRestaurant() {
		return restaurant;
	}
}
