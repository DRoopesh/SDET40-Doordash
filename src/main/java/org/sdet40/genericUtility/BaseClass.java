package org.sdet40.genericUtility;

import java.util.Map;

import org.doordash.ObjectRepository.AdminHomePage;
import org.doordash.ObjectRepository.AdminOrdersPage;
import org.doordash.ObjectRepository.HomePage;
import org.doordash.ObjectRepository.LoginPage;
import org.doordash.ObjectRepository.MyOrdersPage;
import org.doordash.ObjectRepository.OrderAndPayPage;
import org.doordash.ObjectRepository.PickYourFavFoodPage;
import org.doordash.ObjectRepository.RestaurantPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	protected WebDriver driver = null;
	protected String sheetName = "CommonData";
	protected long Timeouts;
	private String timeouts;
	protected Map<String, String> map;
	private String browser;
	private String username;
	private String password;
	private String userurl;
	protected WebDriverUtility webDriverUtility;
	protected ExcelUtility excelUtility;
	protected FileUtility fileUtility;
	protected JavaUtility javaUtility;
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected RestaurantPage restaurantPage;
	protected PickYourFavFoodPage pickYourFavFoodPage;
	protected OrderAndPayPage orderAndPayPage;
	protected MyOrdersPage myOrdersPage;
	protected AdminHomePage adminHomePage;
	protected AdminOrdersPage adminOrdersPage;
	protected SoftAssert soft;
	//Test merge conflit
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtility;
	/**
	 * Initialize all the utility classes
	 * Open the excel, property file
	 * Read the common data
	 * Create the instance for browser(launch browser)
	 * maximize, implicitwait
	 * Open the application
	 * Initialize jsexecutor, actions, webDriverWait
	 * Create the instance for common object repository
	 * 
	 */
//	@Parameters(value="browser")
	@BeforeClass
	public void classSetup() {

		//Create instance of the Generic utilities
		excelUtility = new ExcelUtility();
		fileUtility = new FileUtility();
		javaUtility = new JavaUtility();
		sjavaUtility = javaUtility;
		webDriverUtility = new WebDriverUtility();
		soft = new SoftAssert();

		
		//Initialize the excel file and property file
		excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
		fileUtility.initializeTheFile(IConstantPath.PROPERTYFILE_PATH);
		
		//Fetch the data from property file
		browser = fileUtility.getDataFromPropertyFile("browser");
		userurl = fileUtility.getDataFromPropertyFile("userurl");
		username = fileUtility.getDataFromPropertyFile("username");
		password = fileUtility.getDataFromPropertyFile("password");	
		timeouts = fileUtility.getDataFromPropertyFile("Timeouts");
		Timeouts = (long)javaUtility.convertStringToAnyDatatype(timeouts, DataType.LONG);
		
		map = excelUtility.getDataFromExcelInMap(sheetName);
		
		//Launch the browser
		driver = webDriverUtility.launchTheBrowser(browser);
		sdriver = driver;
		webDriverUtility.navigateTheApplication(driver, userurl);
		
		//maximize, implicitlyWait
		webDriverUtility.maximizeTheBrowser(driver);
		webDriverUtility.implictlyWait(driver, Timeouts);
		
		//Create object for common POM repositories
		loginPage = new LoginPage(driver); 
		restaurantPage = new RestaurantPage(driver);
		homePage = new HomePage(driver);
		adminHomePage = new AdminHomePage(driver);
		adminOrdersPage = new AdminOrdersPage(driver);
		pickYourFavFoodPage = new PickYourFavFoodPage(driver);
		orderAndPayPage = new OrderAndPayPage(driver);
		myOrdersPage = new MyOrdersPage(driver);
	}
		//Login to the application
		/**
		 * 
		 */
		@BeforeMethod
		public void methodSetUp1() {
			loginPage.loginAction(username, password);
		}
		
		//Logout of the application
		@AfterMethod
		public void methodSetUp2() {
			webDriverUtility.logoutAction(driver);
		}
		
		@AfterClass
		public void classTearDown() {
			webDriverUtility.closeTheBrowser(driver);
			excelUtility.closeTheWorkbook();
		}
	}
