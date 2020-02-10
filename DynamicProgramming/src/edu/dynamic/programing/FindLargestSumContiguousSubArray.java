package edu.dynamic.programing;

import java.util.Arrays;

public class FindLargestSumContiguousSubArray {
	/*
	 * Dynamic programming algorithm to find largest sum continuous subarray
	 */
	public int dynamicProgramForMaxSubArray(int[] arr) {
		int[] result = new int[arr.length];
		result[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			result[i] = Math.max(result[i - 1] + arr[i], arr[i]);
		}
		int maxSumArray = result[0];
		for (int j = 1; j < result.length; j++) {
			if (maxSumArray < result[j])
				maxSumArray = result[j];
		}

		System.out.println("Inputs arr : "+Arrays.toString(arr));
		System.out.println("Output arr : "+Arrays.toString(result));
		return maxSumArray;

	}

	public static void main(String args[]) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		FindLargestSumContiguousSubArray maxSum = new FindLargestSumContiguousSubArray();
		System.out.println("Largest sum continuous subarray is : " + maxSum.dynamicProgramForMaxSubArray(arr));
	}
}
