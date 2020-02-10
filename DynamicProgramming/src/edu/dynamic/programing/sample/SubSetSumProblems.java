package edu.dynamic.programing.sample;

public class SubSetSumProblems {

	public static void main(String[] args) {
		int set[] = { 1, 3, 9, 2 };
		int sum = 5;

		boolean[][] T = new boolean[set.length + 1][sum + 1];

		createTable(set, sum, T);

		printTable(set, sum, T);
	}

	private static void printTable(int[] set, int sum, boolean[][] T) {
		for (int i = 0; i <= set.length; i++) {
			for (int j = 0; j <= sum; j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(int[] set, int sum, boolean[][] T) {
		for (int i = 0; i <= set.length; i++) {
			T[i][0] = true;
		}
		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i - 1] > j) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = T[i - 1][j] || T[i - 1][j - set[i - 1]];
				}
			}
		}
	}

}
