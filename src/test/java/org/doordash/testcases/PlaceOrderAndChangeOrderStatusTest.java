//Test Scenario: Test Scenario : Login as user->Place order->Logout ->Login as admin->Go to order->Change order status->Confirm order status->Logout

package org.doordash.testcases;

import org.sdet40.genericUtility.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PlaceOrderAndChangeOrderStatusTest extends BaseClass{
	@Test(groups = "sanity")
	public void textcase2Test() throws InterruptedException {
		webDriverUtility.verifyPage(soft, homePage.getHomePageText(), map.get("userHomePageText"));
		restaurantPage.clickRestaurantTab();
		webDriverUtility.verifyPage(soft, restaurantPage.getResturantPageText(), map.get("userrestaurantsPageText"));
		restaurantPage.clickOnRestaurantMenu(map.get("restaurant"), webDriverUtility);
		webDriverUtility.verifyPage(soft, pickYourFavFoodPage.getDishSelectPageText(), map.get("userdishesmenuPageText"));
		pickYourFavFoodPage.addDishToCart(map.get("dishName"), webDriverUtility);
		pickYourFavFoodPage.ClickCheckOut();
		webDriverUtility.verifyPage(soft, orderAndPayPage.getPayAndOrderPageText(), map.get("userOrderAndPayPageText"));
		webDriverUtility.implictlyWait(driver, Timeouts);
		orderAndPayPage.ClickCashOnDelivery(driver, webDriverUtility, Timeouts);
		orderAndPayPage.ClickOrderNowButton();
		webDriverUtility.acceptAlert(driver);
		webDriverUtility.acceptAlert(driver);
		Reporter.log("Order placed successfully", true);
		webDriverUtility.verifyPage(soft, myOrdersPage.getMyOrdersPageText(), map.get("myOrdersPageText"));
		webDriverUtility.logoutAction(driver);
		webDriverUtility.verifyPage(soft, loginPage.getLoginPageText(),map.get("userLoginPageText"));
		webDriverUtility.navigateTheApplication(driver, map.get("adminurl"));
		webDriverUtility.verifyPage(soft, adminHomePage.getAdminLoginPageText(), map.get("adminLoginPageText"));
		webDriverUtility.implictlyWait(driver, Timeouts);
		webDriverUtility.Login(driver, map.get("adminusername"), map.get("adminpassword"));
		webDriverUtility.verifyPage(soft, adminHomePage.getAdminDashPageText(), map.get("adminDashPageText"));
		adminHomePage.clickOnOrdersBtn();
		webDriverUtility.verifyPage(soft, adminOrdersPage.getAdminOrdersPageText(), map.get("adminOrdersPageText"));		
		adminOrdersPage.clickOnEditLastOrderStatus();
		webDriverUtility.verifyPage(soft, adminOrdersPage.getAdminEditOrdersPageText(), map.get("adminEditOrderPageText"));			
		adminOrdersPage.clickOnUpdateOrderBtn();
		webDriverUtility.windowHandling(driver);
		webDriverUtility.switchTochildwindow(driver);
		loginPage.loginAction(map.get("username"), map.get("password"));
		webDriverUtility.switchToparentwindow(driver);
		adminOrdersPage.clickOnUpdateOrderBtn();
		webDriverUtility.windowHandling(driver);
		webDriverUtility.switchTochildwindow(driver);
		adminOrdersPage.selectStatusFromDropDown(webDriverUtility,map.get("setOrderStatus"));
		adminOrdersPage.enterOrderStatusMessage(map.get("orderStatusMessage"));
		adminOrdersPage.submitOrderStatus();
		webDriverUtility.acceptAlert(driver);
		adminOrdersPage.closeOrderStsWindow();
		webDriverUtility.switchToparentwindow(driver);
		webDriverUtility.verifyPage(soft, adminOrdersPage.getAdminEditOrdersPageText(), map.get("adminEditOrderPageText"));	
		adminHomePage.clickOnOrdersBtn();
		webDriverUtility.verifyPage(soft, adminOrdersPage.getAdminOrdersPageText(), map.get("adminOrdersPageText"));
		webDriverUtility.implictlyWait(driver, Timeouts);
		webDriverUtility.verifyResult(soft, adminOrdersPage.getLatestOrderStatus(), map.get("expOrderStatus"));
		Reporter.log("Order status changed to: "+adminOrdersPage.getLatestOrderStatus(), true);
		adminHomePage.adminLogOutAction();
		webDriverUtility.verifyPage(soft, adminHomePage.getAdminLoginPageText(), map.get("adminLoginPageText"));
		webDriverUtility.verifyAssert(soft);
		
	}
}
