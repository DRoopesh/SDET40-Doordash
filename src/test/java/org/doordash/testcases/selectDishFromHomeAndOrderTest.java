//Test Scenario: -> Select Dish from Homepage -> Place the Order -> Logout

package org.doordash.testcases;

import org.sdet40.genericUtility.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class selectDishFromHomeAndOrderTest extends BaseClass{
	@Test(groups = "reg")
	public void testCase3Test()  {
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
		webDriverUtility.verifyResult(soft, myOrdersPage.getLastOrder(), map.get("homeDishName"));
		webDriverUtility.logoutAction(driver);
		webDriverUtility.verifyPage(soft, loginPage.getLoginPageText(),map.get("userLoginPageText"));
		webDriverUtility.verifyAssert(soft);
	}
}