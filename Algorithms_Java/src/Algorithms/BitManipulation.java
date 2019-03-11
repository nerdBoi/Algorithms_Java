package Algorithms;

public class BitManipulation {
//	Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. 
//  Find this single element that appears only once.
	 public int singleNonDuplicate(int[] nums) {
	        int solution = 0;
	        for (int i = 0; i < nums.length; i++) {
	            solution = solution ^ nums[i];
	        }
	        return solution;
	    }
}
