package org.sdet40.practise;

public class TwoDimensionalArray {
	public static void main(String[] args) {
		String[] arr = {"a","b","c"}; //Single dimensional array Stores data in single row
		for(String data:arr) {
			System.out.println(data);
		}
		String[][] arr1 = new String[2][3]; //Two dimensional array Stores data in rows and columns
		arr1[0][0] = "a1";
		arr1[0][1] = "a2";
		arr1[0][2] = "a3";
		arr1[1][0] = "b1";
		arr1[1][1] = "b2";
		arr1[1][2] = "b3";
		for(int i=0; i<2; i++)
		{
			for(int j=0; j<3; j++)
				System.out.println(arr1[i][j]);
		}
	}
}