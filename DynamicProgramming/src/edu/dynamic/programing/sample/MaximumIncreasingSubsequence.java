package edu.dynamic.programing.sample;

import java.util.Arrays;

public class MaximumIncreasingSubsequence {
	public static void main(String[] args) {
		int arr[] = { 4, 6, 1, 3, 8, 4, 6 };

		int maximumIncreasingSubsequence = findMaximumIncreasingSubsequence(arr);
		System.out.println("MaximumIncreasingSubsequence :: " + maximumIncreasingSubsequence);
	}

	private static int findMaximumIncreasingSubsequence(int[] arr) {
		int temp[] = new int[arr.length];
		Arrays.fill(temp, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					temp[i] = Integer.max(temp[i], temp[j] + 1);
				}
			}
		}
		System.out.println(Arrays.toString(temp));
		return Arrays.stream(temp).max().getAsInt();
	}
}
