package org.sdet40.practise;

import org.sdet40.genericUtility.DatabaseUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromDB {
public static void main(String[] args) {
	DatabaseUtility databaseUtility = new DatabaseUtility();
	databaseUtility.openDBConnection(IConstantPath.DB_URL, "root", "root");
	databaseUtility.modifyDataInDatabase("insert into testtable1 values(1004, 'Kumar', 4234568, 'Mysore')");
	boolean status = databaseUtility.veriftDataInDatabase("Select * from testtable1", "emp_name", "Surya");
	System.out.println(status);
}
}
