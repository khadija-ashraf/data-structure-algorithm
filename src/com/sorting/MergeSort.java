package com.sorting;

public class MergeSort {
	
//	Algorithm:
//	Recursively:
//	============
//	- Step 1: find the mid index of the array, 
//	- Step 2: go for sorting left half
//	- Step 3: go for sorting right half
//	- Step 4: merge the left and right half, sorting is done during merging 
	
//	If we analyze the order of the steps in this recursive algorithm then,
//	we see that, we keep slicing the array until no more slicing can be done, follow steps 1, 2, 3.
//	no sorting is done in this slicing period. Only when the sliced array 
//  reaches to zero or 1 elements then we return from slicing and starting merging in the step 4.
//	Since the the Step 2 executes before the Step 3 therefore the left part of the array will be
//	sliced until it reaches to 1-element arrays, then the sort-and-merge will execute on the left 
//	side of the recursive tree,
//	upon return from the left subtree the right subtree sort-and-merge will be executed.
	
	public void sort(int[] arr, int left, int right) {
		if(left < right) {
			int midIndex = left + (right - left) / 2;
			
			sort(arr, left, midIndex);
			sort(arr, midIndex+1, right);
			
			merge(arr, left, midIndex, right);
		}
	}
	
	public void merge(int[] arr, int left, int midIndex, int right) {
		int leftArraySize = midIndex - left + 1;
		int rightArraySize = right - midIndex;
		
		int[] leftTempArr = new int[leftArraySize];
		int[] rightTempArr = new int[rightArraySize];
		
		for(int i = 0; i < leftArraySize; i++) {
			leftTempArr[i] = arr[left + i];
		}
		
		for(int i = 0; i < rightArraySize; i++) {
			rightTempArr[i] = arr[midIndex + 1 + i];
		}
		
		// merge
		
		int i = 0; 
		int j = 0; 
		int k = left;
		
		while(i < leftArraySize && j < rightArraySize) {
			if(leftTempArr[i] <= rightTempArr[j]) {
				arr[k] = leftTempArr[i];
				i++;
			} else {
				arr[k] = rightTempArr[j];
				j++;
			}
			k++;
		}
		
		while(i < leftArraySize) {
			arr[k] = leftTempArr[i];
			i++;
			k++;
		}
		
		while(j < rightArraySize) {
			arr[k] = rightTempArr[j];
			j++;
			k++;
		}
				
	}
	
	public void print(int[] arr) {
		for(int n: arr) {
			System.out.print(n + ", ");
		}
	}

	public static void main(String a[]) {
		MergeSort ob = new MergeSort();
		
		int[] arr = {4,7,1,8,3,8,9};
		
		ob.sort(arr, 0, arr.length - 1);
		
		ob.print(arr);
	}
}
