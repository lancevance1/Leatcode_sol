/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
       int[] arr = {-1, -1};
       int a=binFirst(nums,target);
       int b=binLast(nums,target);
       if(a>b)return arr;
       arr[0]=a;
       arr[1]=b;
       return  arr;
    }

    public int binFirst(int[] nums, int target){
        int l=0, r=nums.length-1, m;
        while(l<=r){
            m=l+(r-l)/2;
            if(nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l;
    }

    public int binLast(int[] nums, int target){
        int l=0, r=nums.length-1, m;
        while(l<=r){
            m=l+(r-l)/2;
            if(nums[m]<=target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l-1;
    }
}
