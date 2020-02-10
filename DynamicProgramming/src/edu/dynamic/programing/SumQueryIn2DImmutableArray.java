package edu.dynamic.programing;

public class SumQueryIn2DImmutableArray {

	public static void main(String[] args) {
		int[][] input = { 
				{ 3, 0, 1, 4, 2 }, 
				{ 5, 6, 3, 2, 1 }, 
				{ 1, 2, 0, 1, 5 }, 
				{ 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } 
				};

		// int[][] input1 = { { 2, 0, -3, 4 }, { 6, 3, 2, -1 }, { 5, 4, 7, 3 }, { 2, -6,
		// 8, 1 } };
		System.out.println(sumQuery(1, 1, 2, 2, input));
	}

	private static int sumQuery(int x, int y, int x1, int y1, int[][] input) {
		int[][] T = new int[input.length][input[0].length];
		return 0;
	}

}
