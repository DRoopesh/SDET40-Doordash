package org.sdet40.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractise3Test {
	
	@Test(dataProvider="getData")
	public void step31Test(String city, int pincode) throws InterruptedException {
		System.out.println(Thread.currentThread().getId());
		System.out.println("City----->"+city);
		System.out.println("Pincode----->"+pincode);
		
		System.out.println();
	}
	@DataProvider(parallel=true)
	public Object[][] getData() {
//		Object[][] obj = new Object[6][2];
//		obj[0][0] = "ECity";
//		obj[0][1] = 560100;
//		
//		obj[1][0] = "Tumkur";
//		obj[1][1] = 560101;
//		
//		obj[2][0] = "Jakkur";
//		obj[2][1] = 560064;
//		
//		obj[3][0] = "BTM1";
//		obj[3][1] = 560068;
//		
//		obj[4][0] = "BTM2";
//		obj[4][1] = 560067;
//		
//		obj[5][0] = "Jayanagar";
//		obj[5][1] = 560080;
		Object[][] obj = {{"ECity",560100},{"Tumkur",560101},{"Jakkur",560064},{"BTM1",560068},{"BTM2",560067},{"Jayanagar",560080}};
		return obj;
	}
}
