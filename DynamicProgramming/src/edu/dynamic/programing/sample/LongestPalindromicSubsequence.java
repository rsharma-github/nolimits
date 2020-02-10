package edu.dynamic.programing.sample;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String str = "agbdba";

		int[][] T = new int[str.length()][str.length()];

		createTable(str, T);
		printTable(str, T);
	}

	private static void printTable(String str, int[][] T) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(String str, int[][] T) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				if (i == j) {
					T[i][j] = 1;
				}
			}
		}

		for (int i = 1; i < str.length(); i++) {
			int t = 0;
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(t) == str.charAt(j)) {
					T[t][j] = T[t + 1][j - 1] + 2;
				} else {
					T[t][j] = Integer.max(T[t + 1][j], T[t][j - 1]);
				}
				t++;
			}
		}
	}

}
