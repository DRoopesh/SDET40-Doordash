//Login as user -> Select Dish from Homepage -> Place the Order -> Logout

package org.doordash.testcases;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testcase3Dp extends BaseClass{
	@Test(dataProvider = "getData")
	public void testCase3Test(String homeDishName, String message)  {
		webDriverUtility.verifyPage(soft, homePage.getHomePageText(), map.get("userHomePageText"));
		homePage.clickOnHomeDish(homeDishName, webDriverUtility);
		webDriverUtility.verifyPage(soft, pickYourFavFoodPage.getDishSelectPageText(), map.get("userdishesmenuPageText"));
		pickYourFavFoodPage.addDishToCart(homeDishName, webDriverUtility);
		pickYourFavFoodPage.ClickCheckOut();
		webDriverUtility.verifyPage(soft, orderAndPayPage.getPayAndOrderPageText(), map.get("userOrderAndPayPageText"));		
		orderAndPayPage.ClickCashOnDelivery(driver, webDriverUtility, Timeouts);
		orderAndPayPage.ClickOrderNowButton();

//		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		System.out.println(message);
		webDriverUtility.verifyPage(soft, myOrdersPage.getMyOrdersPageText(), map.get("myOrdersPageText"));
		webDriverUtility.verifyResult(soft, myOrdersPage.getLastOrder(), homeDishName);
		webDriverUtility.logoutAction(driver);
		webDriverUtility.verifyPage(soft, loginPage.getLoginPageText(),map.get("userLoginPageText"));
		webDriverUtility.verifyAssert(soft);
		
	}
	@DataProvider
	public Object getData() {
		Object[][] obj = {{map.get("homeDishName"), map.get("orderplacedmessage")}};
		return obj;
	}
}