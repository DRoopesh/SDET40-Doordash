package org.sdet40.practise;

import java.util.List;

import org.sdet40.genericUtility.DatabaseUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromDataBase {
public static void main(String[] args) {
	DatabaseUtility databaseUtility = new DatabaseUtility();
	databaseUtility.openDBConnection(IConstantPath.DB_URL, "root", "root");
	List<String> data = databaseUtility.getDataFromDatabase("Select * from sdet40", "emp_name");
	List<String> data1 = databaseUtility.getDataFromDatabase("Select * from sdet40", "emp_name");
	List<String> data2 = databaseUtility.getDataFromDatabase("Select * from sdet40", "emp_name");
	
	System.out.println(data);
	System.out.println(data1);
	System.out.println(data2);
	databaseUtility.closeDB();
}
}
