package org.sdet40.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consists of methods to handle SQL database / all resusable actions
 * @author DASARI
 *
 */
public class DatabaseUtility {
	Statement statement = null;
	private Connection connection;
	/**
	 * This method is used to fetch the data from the database
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDatabase(String query, String columnName) {
		ResultSet result = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String>list = new ArrayList<>();

		try {
			while(result.next())
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method is used to open the Database connection 
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL, String dbUserName, String dbPassword) {
		Driver dbdriver = null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the database connection
	 */
	public void closeDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void modifyDataInDatabase(String query) {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean veriftDataInDatabase(String query, String columnName, String expectedData) {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for(String actualData : list) {
			if(actualData.equalsIgnoreCase(expectedData)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}
