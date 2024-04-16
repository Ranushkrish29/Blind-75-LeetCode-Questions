/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

*/

// solution one (so much )
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //result nums store
        int[] resultnums = new int[nums.length];
        //loop one
        for(int i =0; i < nums.length; i++){
            int val = 1;
            // inner loop 
            for(int j = 0 ; j < nums.length; j++){
                if(i!=j){
                    //if mul by 0 set value to 0 and break the loop 
                    if(nums[j]==0){
                        val = 0;
                        break;
                    }else{
                        val*=nums[j];//mul the value
                    }
                }
            }
            //assign
            resultnums[i] = val;
        }
        //return 
        return resultnums;
    }
}



class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        //result nums store
        int[] resultnums = new int[nums.length];
        //dict
        Map<Integer, Integer[]> positionValuePreAndSuff = new HashMap<>();
        //length
        int finallength = nums.length-1;
        //pointers 
        int p1 =0 ,
        p2 = finallength ,
        lvalue = 1 , 
        rvalue = 1 ;
        //loop
        for (int i = 0; i <= finallength; i++) {
            // left side
            if (positionValuePreAndSuff.containsKey(p1)) { // if dict contains update the left value
                    positionValuePreAndSuff.put(p1, new Integer[]{lvalue, positionValuePreAndSuff.get(p1)[1]});
            } else { // else create the new key and value pair
                    positionValuePreAndSuff.put(p1, new Integer[]{lvalue, null});
            }

            // right side
            if (positionValuePreAndSuff.containsKey(p2)) { // if dict contains update the right value
                positionValuePreAndSuff.put(p2, new Integer[]{positionValuePreAndSuff.get(p2)[0], rvalue});
            } else { // else create the new key and value pair
                positionValuePreAndSuff.put(p2, new Integer[]{null, rvalue});
            }
            lvalue *= nums[p1];
            rvalue *= nums[p2];
            p1++;
            p2--;
        }

        for (int i = 0; i <= finallength; i++) {
            Integer[] values = positionValuePreAndSuff.get(i);
            //set the values
            resultnums[i] = (values[0] == null ? 1 : values[0]) * (values[1] == null ? 1 : values[1]);
        }
        return resultnums;
    }
}


//explaination solution1
//pointer
p1= 0 
p2 = 3 
lvalue = 1 ; // p1 is index
rvalue = 1 ;  // p2 is index
positionValuePreAndSuff{ i : [left, right] } // dict to store the prefix and suffix of the mul value in the perticular index

// set the  lvalue to the dict[p1][0] and set the rvalue to the dict[p2][1] 
//loop nums  
    ->1
    //p1=0 ,p2=3, lvalue = 1 ,rvalue = 4
    p1            p2
    // 1 , 2 , 3 ,  4
    0 = [1, ] lvalue = 1    rvalue = null  // p1=0 set the lvalue =  lvalue * nums[p1]  = 1 *1 =1
    1 = [ , ] lvalue = null rvalue = null
    2 = [ , ] lvalue = null rvalue = null
    3 = [ ,1] lvalue = null rvalue = 1     // p1=3  set the rvalue =  rvalue * nums[p2] = 1 * 4 = 4

    ->2 
    //p1= 1 ,p2= 2, lvalue = 1 , rvalue = 4
            p1  p2
    // 1 ,  2  , 3 ,  4
    0 = [1, ] lvalue = 1    rvalue = null 
    1 = [1, ] lvalue = 1    rvalue = null //p1 = 1   set the lvalue =  lvalue * nums[p1]  1 * 2 = 2
    2 = [ ,4] lvalue = null rvalue = 4    //p2 = 2   set the rvalue =  rvalue * nums[p2]  4 * 3 = 12
    3 = [ ,1] lvalue = null rvalue = 1    

    ->3 
    //p1= 2 ,p2= 1, lvalue = 2 , rvalue = 12
            p2  p1
    // 1 ,  2  , 3 ,  4
    0 = [1, ]   lvalue = 1    rvalue = null 
    1 = [1, 12] lvalue = 1    rvalue = 12   //p2 = 1   set the rvalue =  rvalue * nums[p2] = 12 * 2 =24
    2 = [2,4]   lvalue = 2    rvalue = 4    //p1 = 2   set the lvalue =  lvalue * nums[p1] = 2 * 3  =6 
    3 = [ ,1]   lvalue = null rvalue = 1    


    ->4 
    //p1= 3 ,p2= 0, lvalue = 12 , rvalue = 24
      p2            p1
    // 1 , 2 , 3 ,  4
    0 = [1, 24]   lvalue = 1   rvalue = 24    //p2 = 0   set the rvalue =  rvalue * nums[p2] = 12 * 2 =24  
    1 = [1, 12]   lvalue = 1   rvalue = 12   
    2 = [ 2, 4]   lvalue = 2   rvalue = 4     
    3 = [ 6 ,1]   lvalue = 6   rvalue = 1    //p1 = 3   set the lvalue =  lvalue * nums[p1] = 2 * 6  =12


//loop through the positionValuePreAndSuff and multiply the left and right of the index

    0 = [1, 24]   lvalue = 1 *  rvalue = 24 = 24    
    1 = [1, 12]   lvalue = 1 *  rvalue = 12 = 12 
    2 = [ 2, 4]   lvalue = 2 *  rvalue = 4  = 8
    3 = [ 6 ,1]   lvalue = 6 *  rvalue = 1  = 6

//result  = [ 24, 12, 8, 6]



//solution 2 (with out the hashmap )  same method but simplefied updated version //
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        //result nums store
        int[] resultnums = new int[nums.length];
        //length
        int finallength = nums.length-1;
        //pointers 
        int p1 =0 ,
        p2 = finallength ,
        lvalue = 1 , 
        rvalue = 1 ;
        //loop
        for (int i = 0; i <= finallength; i++) {
            resultnums[p2] =rvalue;
            rvalue *= nums[p2];
            p2--;
        }
        for (int i = 0; i <= finallength; i++) {
            resultnums[i] = lvalue * resultnums[i];
            lvalue= lvalue*nums[i];
        }
        return resultnums;
    }
}


//solution 2 prefix and suffix
class Solution3 {
   public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        int n = nums.length;
        int[] ans = new int[n];
        int product = 1;

        // prefix
        for (int i = 0; i < n; i++) {
            ans[i] = product;
            product *= nums[i];
        }

        product = 1;

        // suffix
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = product * ans[i];
            product *= nums[i]; 
        }

        return ans;
    }
}

