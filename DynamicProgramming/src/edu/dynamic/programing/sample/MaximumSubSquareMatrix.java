package edu.dynamic.programing.sample;

public class MaximumSubSquareMatrix {

	public static void main(String[] args) {
		int matrix[][] = { { 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 } };
		int r = matrix.length + 1;
		int c = matrix[0].length + 1;
		int T[][] = new int[r][c];

		createTable(r, c, matrix, T);

		printTable(r, c, T);
	}

	private static void printTable(int r, int c, int[][] T) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(int r, int c, int[][] matrix, int[][] T) {
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (1 == matrix[i - 1][j - 1]) {
					T[i][j] = Integer.min(T[i - 1][j - 1], Integer.min(T[i - 1][j], T[i][j - 1])) + 1;
				}
			}
		}
	}

}
