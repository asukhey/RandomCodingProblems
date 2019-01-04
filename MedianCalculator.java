/*
 * 
 * This problem was asked by Microsoft.

 *Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

 * Recall that the median of an even-numbered list is the average of the two middle numbers.

 *For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
 * 
 * 
 * */

import java.util.*;
public class MedianCalculator {

	public static List<Integer> sortedArray= new ArrayList<Integer>(); //Will sort all numbers from input
	
	public void median(List<Integer> sortedArray) {
		int median=0;
		int res=0;
		median=sortedArray.size()/2;
		if(sortedArray.size()%2==1) {
			res=sortedArray.get(median);
			System.out.println(res);
		}
		
		else {
			int a=sortedArray.get(median-1);
			int b=sortedArray.get(median);
			
			double eve_res = ((double) a + (double) b)/2; 
			
			//if value after decimal point is 0. Return integer value  
			if((eve_res*2)%2==0) {
				System.out.println((int)eve_res);
			}
			else {
				System.out.println(eve_res);
			}
		}
		
	}
	
	public void medianCalc(int[] nums) {
		int ptr=0; //Iterate through the array
		/*
		 * Base Cases
		 * */
		
		//If integer array is empty
		if(nums.length==0) {
			System.out.println("Array is empty");
		}
		
		// if Integer array has only one element
		else if(nums.length==1) {
			System.out.println(nums[0]);
		}
		
		else if(nums.length==2) {
			System.out.println((nums[0] + nums[1])/2);
		}
		
		//More than one integers
		else {
			while(ptr<nums.length) {
				sortedArray.add(nums[ptr]);
				if(sortedArray.size()>1) {
					Collections.sort(sortedArray); // Sorts array
				}
				median(sortedArray); 
				ptr+=1;
			}
		}
	}
	
	
	
	public static void main(String args[]) {
		
		int[] ip = {2, 1, 5, 7, 2, 0, 5};
		
		MedianCalculator m = new MedianCalculator();
		m.medianCalc(ip);
	}
}
