package edu.dynamic.programing;

import java.util.Deque;
import java.util.LinkedList;

public class StockBuySellKTransactions {

	public static void main(String[] args) {
		int prices[] = { 2, 5, 7, 1, 4, 3, 1, 3 };

		System.out.println("Max profit fast solution " + maxProfit(prices, 3));
	}

	/**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */
	public static int maxProfit(int prices[], int K) {
		if (K == 0 || prices.length == 0) {
			return 0;
		}
		int T[][] = new int[K + 1][prices.length];

		for (int i = 1; i < T.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < T[0].length; j++) {
				T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
			}
		}
		printActualSolution(T, prices);
		return T[K][prices.length - 1];
	}

	public static void printActualSolution(int T[][], int prices[]) {
		int i = T.length - 1;
		int j = T[0].length - 1;

		Deque<Integer> stack = new LinkedList<>();
		while (true) {
			if (i == 0 || j == 0) {
				break;
			}
			if (T[i][j] == T[i][j - 1]) {
				j = j - 1;
			} else {
				stack.addFirst(j);
				int maxDiff = T[i][j] - prices[j];
				for (int k = j - 1; k >= 0; k--) {
					if (T[i - 1][k] - prices[k] == maxDiff) {
						i = i - 1;
						j = k;
						stack.addFirst(j);
						break;
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.println("Buy at price " + prices[stack.pollFirst()]);
			System.out.println("Sell at price " + prices[stack.pollFirst()]);
		}

	}

}
