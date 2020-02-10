package edu.dynamic.programing.sample;

public class CoinChangingMinimumNumberOfCoins {

	public static void main(String[] args) {
		int coins[] = { 1, 5, 6, 8 };
		int total = 11;

		int[][] T = new int[coins.length + 1][total + 1];
		createTable(coins, total, T);

		printTable(coins, total, T);
	}

	private static void printTable(int[] coins, int total, int[][] T) {
		for (int i = 0; i <= coins.length; i++) {
			for (int j = 0; j <= total; j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(int[] coins, int total, int[][] T) {
		for (int j = 1; j <= total; j++) {
			T[0][j] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (coins[i - 1] > j) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = Integer.min(T[i - 1][j], 1 + T[i][j - coins[i - 1]]);
				}
			}
		}
	}

}
