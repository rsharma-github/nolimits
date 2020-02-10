package edu.dynamic.programing.sample;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 4, 6, 1, 3, 8, 4, 6 };

		int maximumSumIncreasingSubsequence = findMaximumSumIncreasingSubsequence(arr);
		System.out.println("MaximumSumIncreasingSubsequence :: " + maximumSumIncreasingSubsequence);
	}

	private static int findMaximumSumIncreasingSubsequence(int[] arr) {
		int[] temp = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(temp));

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					temp[i] = Integer.max(temp[i], temp[j] + arr[i]);
				}
			}
		}
		System.out.println(Arrays.toString(temp));
		return Arrays.stream(temp).max().getAsInt();
	}

}
