package org.sdet40.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of all resusable actions
 * @author DASARI
 *
 */
public class JavaUtility {
	/**
	 * This method is used to convert a string to any datatype on strategy
	 * @param data
	 * @param strategy
	 * @return
	 */
	public Object convertStringToAnyDatatype(String data, DataType strategy) {
		Object obj = null;
		if(strategy.toString().equalsIgnoreCase("long")) {
			obj = Long.parseLong(data);
		}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj = Double.parseDouble(data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj = Integer.parseInt(data);
		}
		else if(strategy.toString().equalsIgnoreCase("short")) {
			obj = Short.parseShort(data);
		}
		return obj;
	}
	/**
	 * This method is used to generate a random number 
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	/**
	 * This method is used to convert the date and time into "dd_MM_yyyy_hh_mm_ss" format
	 * @return
	 */
	public String currentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
}