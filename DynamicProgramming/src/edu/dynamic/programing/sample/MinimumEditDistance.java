package edu.dynamic.programing.sample;

public class MinimumEditDistance {

	public static void main(String[] args) {
		String destination = "abcdef";
		String sourc = "azced";

		int[][] T = new int[sourc.length() + 1][destination.length() + 1];

		createTable(sourc, destination, T);

		printTable(sourc, destination, T);
	}

	private static void printTable(String sourc, String destination, int[][] T) {
		for (int i = 0; i <= sourc.length(); i++) {
			for (int j = 0; j <= destination.length(); j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void createTable(String sourc, String destination, int[][] T) {
		for (int i = 1; i <= sourc.length(); i++) {
			T[i][0] = i;
		}
		for (int j = 1; j <= destination.length(); j++) {
			T[0][j] = j;
		}
		for (int i = 1; i <= sourc.length(); i++) {
			for (int j = 1; j <= destination.length(); j++) {
				if (sourc.charAt(i - 1) == destination.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1];
				} else {
					T[i][j] = Integer.min((T[i - 1][j - 1]), Integer.min(T[i - 1][j], T[i][j - 1])) + 1;
				}
			}
		}
	}

}
