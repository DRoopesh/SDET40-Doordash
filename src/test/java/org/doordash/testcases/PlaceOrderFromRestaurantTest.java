//Test Scenario: Login as User -> Place the order through restaurant module -> Logout
package org.doordash.testcases;

import org.doordash.ObjectRepository.EdishNames;
import org.doordash.ObjectRepository.ErestaurantNames;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.DishNames;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PlaceOrderFromRestaurantTest extends BaseClass{
	@Test(groups = "sanity")
	public void testCaseTest()  {
		webDriverUtility.verifyPage(soft, homePage.getHomePageText(), map.get("userHomePageText"));
		String restaurant = ErestaurantNames.EATALY.getRestaurant();
		String dishName = EdishNames.EPINKSPAGHETTIGAMBERONI.getDishName();
		restaurantPage.clickRestaurantTab();
		webDriverUtility.verifyPage(soft, restaurantPage.getResturantPageText(), map.get("userrestaurantsPageText"));

		restaurantPage.clickOnRestaurantMenu(restaurant, webDriverUtility);
		webDriverUtility.verifyPage(soft, pickYourFavFoodPage.getDishSelectPageText(), map.get("userdishesmenuPageText"));
		
		pickYourFavFoodPage.addDishToCart(dishName, webDriverUtility);
		pickYourFavFoodPage.ClickCheckOut();
		webDriverUtility.verifyPage(soft, orderAndPayPage.getPayAndOrderPageText(), map.get("userOrderAndPayPageText"));
		
		orderAndPayPage.ClickCashOnDelivery(driver, webDriverUtility, Timeouts);
		orderAndPayPage.ClickOrderNowButton();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		Reporter.log("Order placed successfully", true);
		webDriverUtility.verifyPage(soft, myOrdersPage.getMyOrdersPageText(), map.get("myOrdersPageText"));
		
		webDriverUtility.verifyResult(soft, myOrdersPage.getLastOrder(), dishName);
		webDriverUtility.logoutAction(driver);
		webDriverUtility.verifyPage(soft, loginPage.getLoginPageText(),map.get("userLoginPageText"));
		webDriverUtility.verifyAssert(soft);
	}
}
