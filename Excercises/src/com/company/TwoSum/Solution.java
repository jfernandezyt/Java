package com.company.TwoSum;

public class Solution {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
    */

    public static int[] twoSum(int[] nums, int target) {
        int temp = nums.length - 1;
        int[] answer = null;

        for(int i = 0; i < nums.length; i++){
            if(nums[temp] + nums[i] == target){
                answer = new int[]{i , temp};
                break;
            }
            if((temp - 1) == i){
                temp = nums.length -1;
            }else{
                --temp;
                --i;
            }
        }

        return answer;
    }
}
