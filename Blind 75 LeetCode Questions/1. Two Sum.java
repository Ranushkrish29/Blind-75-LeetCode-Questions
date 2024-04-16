/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */


class Solution0{
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){ //0
            for(int j=i+1;j<nums.length;j++){//1
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {0,0};
    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        //map to store the viewwd values 
        Map<Integer, Integer> myDictionary = new HashMap<>();

        for(int i =0; i< nums.length ;i++){
            int check = target-nums[i];
            if(myDictionary.containsKey(check)){
                result[0]= myDictionary.get(check);
                result[1]=i;
                break;
            }
            // Adding key-value (value - index) pairs to the dictionary
            myDictionary.put(nums[i], i);
        }
        return result;
    }
}



class Solution2{
    public int[] twoSum(int[] nums, int target) {
    int finish=nums.length-1;
        for(int i=0;i<nums.length-1;i++){ //0
            for(int j=i+1;j<nums.length;j++){//1
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
                else if(nums[finish-i]+nums[finish-j]==target){
                    return new int[] {finish-i,finish-j};
                }
            }
        }
        return new int[] {0,0};
    }
}