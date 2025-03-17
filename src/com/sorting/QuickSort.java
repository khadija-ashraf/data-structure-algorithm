package com.sorting;

public class QuickSort {
	
//	The algorithm:
//	1. chose an element from the input array (arbitrary or, or the first, or the last one)
//	2. partition the array in left and right portions. The left part of the partition has
//	all the elements smaller than the partition point. The right part of the partition 
//	has all the elements grater than the partition point. 
	
//	the partition point is called the pivot element. After a partition completion the pivot
//	element achieves its actual final position in the final answer.
//	that means, after every partition we get at least one element sorted and positioned in the
//	final sorted result. Therefore, the later partitions excludes the pivot element 
//	cause its already sitting in the index where is suppose to be in the final sorted array.
	 
//	We treat each left and right partition as a new input array and call quicksort on both of them 
//	recursively.

	
//	Concept behind the partition method:
//	for every pivot element we scan the entire input array of its scope. during this scan our
//	goal is to find any smaller elements than the pivot and place them to left side of the 
//	input array. any left element that is not smaller than the pivot will leave its space gracefully 
//	for a smaller (than pivot) element. Therefore, we can say, after a single scan
//  all the elements smaller than the current pivot are to the left side of the input array. Then we
//  place the pivot element right after those smaller elements. In this process 
//	we can not assert that all those smaller elements are sorted but we can say that the pivot element
//	is the grater than all those small elements. and since we scanned the entire input array, so 
//	it is intuitive that the pivot is sitting at the right position where it will be in the final 
//	sorted array, because all the elements left to the pivot are smaller than it, 
//	and obviously, all the elements right to the pivot must be grater than it.
	
//	This process run recursively in the left and right parts of the input array.
	
	public void sort(int[] arr, int lowIndex, int highIndex) {
		if(lowIndex < highIndex) {
			int pivotIndex = partition(arr, lowIndex, highIndex);
			
			sort(arr, lowIndex, pivotIndex - 1);
			sort(arr, pivotIndex + 1, highIndex);
		}
	}
	
	public int partition(int[] arr, int lowIndex, int highIndex) {
		int pivotIndex = highIndex;
		int leftIndex = lowIndex - 1;
		
		for(int i = lowIndex; i <= highIndex - 1; i++) {
			if(arr[i] < arr[pivotIndex]) {
				leftIndex++;
				swap(arr, leftIndex, i);
			}
		}
		leftIndex++;
//		in this swap we are setting the pivot to the correct 
//		index where all elements to it's left are small,
//		and, all elements to the pivot's right are grater.
		swap(arr, leftIndex, pivotIndex); 
		return leftIndex;
	}
	
	public void swap(int[] arr, int leftIndex, int i) {
		int temp = arr[i];
		arr[i] = arr[leftIndex];
		arr[leftIndex] = temp;
	}
	
	public static void main(String a[]) {
//		int[] input = {8,2,6,1,7,9,3};
		int[] input = {5,2,3,1};
		
		QuickSort ob = new QuickSort();
		
		ob.sort(input, 0, input.length-1);
		
		for(int num: input)
		{
			System.out.println(num+", ");
		}
	}
}
