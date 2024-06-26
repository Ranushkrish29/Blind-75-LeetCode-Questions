/* Contains Duplicate
Easy
Topics
Companies
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109 */

// solution1
class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            for( int  j =i+1 ;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
//solution2
import java.util.HashMap;
class Solution {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> myDictionary = new HashMap<>();
        int final = nums.length-1;      
        for(int i = 0;i<nums.length;i++){
            if(myDictionary.containsKey(nums[i])){
                return true;
            }else{
                myDictionary.put(nums[i], i);
            }
            if(myDictionary.containsKey(nums[final -  i])){
                return true;
            }else{
                myDictionary.put(nums[final -  i], i);
            }
        }
        return false;
    }
}