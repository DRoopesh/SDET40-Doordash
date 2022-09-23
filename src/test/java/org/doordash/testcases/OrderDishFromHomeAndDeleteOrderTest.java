//Test Scenario: Login as user -> Select Dish from Homepage and Place the order -> Go to Orders -> Delete the order -> Logout

package org.doordash.testcases;

import org.sdet40.genericUtility.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderDishFromHomeAndDeleteOrderTest extends BaseClass{
	@Test(groups = "smoke")
	public void testCase4Test() {
		webDriverUtility.verifyPage(soft, homePage.getHomePageText(), map.get("userHomePageText"));
		
		homePage.clickOnHomeDish(map.get("homeDishName"), webDriverUtility);
		webDriverUtility.verifyPage(soft, pickYourFavFoodPage.getDishSelectPageText(), map.get("userdishesmenuPageText"));
		
		pickYourFavFoodPage.addDishToCart(map.get("homeDishName"), webDriverUtility);
		pickYourFavFoodPage.ClickCheckOut();
		webDriverUtility.verifyPage(soft, orderAndPayPage.getPayAndOrderPageText(), map.get("userOrderAndPayPageText"));
		
		orderAndPayPage.ClickCashOnDelivery(driver, webDriverUtility, Timeouts);
		orderAndPayPage.ClickOrderNowButton();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		Reporter.log("Order placed successfully", true);
		webDriverUtility.verifyPage(soft, myOrdersPage.getMyOrdersPageText(), map.get("myOrdersPageText"));
		
		myOrdersPage.deleteLastOrder(webDriverUtility);
		webDriverUtility.logoutAction(driver);
		webDriverUtility.verifyPage(soft, loginPage.getLoginPageText(),map.get("userLoginPageText"));
		
		webDriverUtility.verifyAssert(soft);	
	}
}