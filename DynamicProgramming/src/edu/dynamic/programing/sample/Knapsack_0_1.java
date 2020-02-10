package edu.dynamic.programing.sample;

public class Knapsack_0_1 {

	public static void main(String[] args) {
		/*
		 * int val[] = { 60, 100, 120 }; int wt[] = { 10, 20, 30 }; int W = 50;
		 */

		///
		int W = 5;
		int[] val = { 3, 4, 5, 6 };
		int[] wt = { 2, 3, 4, 5 };

		int[][] T = new int[wt.length + 1][W + 1];
		createKnapsackTable(val, wt, W, T);
		printTable(wt, W, T);

	}

	private static void printTable(int[] wt, int W, int[][] T) {
		for (int i = 0; i < wt.length + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
	System.out.println("output is :- " + T[wt.length][W]);
	}

	private static void createKnapsackTable(int[] val, int[] wt, int W, int[][] T) {
		for (int i = 1; i < wt.length + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (j < wt[i - 1]) {
					T[i][j] = T[i - 1][j];
				} else {
					T[i][j] = Integer.max((T[i - 1][j]), (T[i - 1][j - wt[i - 1]]) + (val[i - 1]));
				}
			}
		}
	}

}
