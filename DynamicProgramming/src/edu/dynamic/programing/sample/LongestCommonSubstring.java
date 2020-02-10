package edu.dynamic.programing.sample;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "zbcdf";

		int[][] T = new int[str2.length() + 1][str1.length() + 1];

		createTable(str1, str2, T);

		printTable(str1, str2, T);
	}

	private static void printTable(String str1, String str2, int[][] T) {
		for (int i = 0; i <= str2.length(); i++) {
			for (int j = 0; j <= str1.length(); j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(String str1, String str2, int[][] T) {
		for (int i = 1; i <= str2.length(); i++) {
			for (int j = 1; j <= str1.length(); j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					T[i][j] = 1 + T[i - 1][j - 1];
				} 
				/*
				else {
					T[i][j] = 0;
				}
				*/
			}
		}
	}
}
