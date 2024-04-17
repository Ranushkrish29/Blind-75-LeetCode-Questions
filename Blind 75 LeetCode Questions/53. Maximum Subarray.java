/*
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
 
Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. */



//solution 1 - Works but Time Limit Exceeded :)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0]; //current max
        
        for(int i =0 ; i<nums.length;i++){
            int total =0;
            for(int j =i ; j<nums.length;j++){ //check the elements in the list
                total += nums[j]; 
                max = max < total? total :max; //update max 
            }
        }
        return max;
    }
}
    i
//[-2,1,-3,4,-1,2,1,-5,4]
//solution 1 - Works but Time Limit Exceeded :)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], // inti max value
        currSum = 0; //store the current max sum
        for(int i =0 ; i<nums.length;i++){
            if (currSum < 0)
                currSum = 0;
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);    
        }
        return maxSum;
    }
}

//explaination
// [-2,1,-3,4,-1,2,1,-5,4]

    maxsum = -2 
    //loop the arr 
        //steps
        currSum = 0 // currsum < 0  : currsum = 0 ? currsum = currsum -> 0 = 0 so currsum = 0
        currSum = currsum -2 // 0 - 2 = -2
        maxSum = 0 // maxsum > currsum : maxsum = currsum ? maxsum = maxsum ->  -1 < 0 so maxsum = 0
    


 