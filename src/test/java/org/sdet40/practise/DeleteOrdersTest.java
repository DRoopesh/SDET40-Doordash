package org.sdet40.practise;

import org.sdet40.genericUtility.BaseClass;
import org.testng.annotations.Test;

public class DeleteOrdersTest extends BaseClass{
	@Test
	public void deleteOrdersPlacedByCustomer() throws InterruptedException {
		String customerName = "drv";
		webDriverUtility.navigateTheApplication(driver, map.get("adminurl"));
		adminHomePage.loginAction(map.get("adminusername"), map.get("adminpassword"));
		adminHomePage.clickOnOrdersBtn();
		adminOrdersPage.deleteOrders(webDriverUtility, customerName, driver);
		

	}
}

