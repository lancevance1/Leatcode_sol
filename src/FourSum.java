import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lance on 10/18/2019.
 */
public class FourSum {
    /**18. 4Sum
     * Given an array nums of n integers and an integer target, are there elements a, b, c,
     * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     *
     * Note:
     *
     * The solution set must not contain duplicate quadruplets.
     *
     * Example:
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     *
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * time complexity: o(n^3)
     *
     * @param nums
     * @param target
     * @return
     */

    // written by myself
//    private static List<List<Integer>> result;
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        result = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums.length == 0){
//            return res;
//        }
//        Arrays.sort(nums);
//
//
//        // -2,-1,0,0,1,2
//        for (int i = 0; i < nums.length - 3; i++) {
//            //int left = i + 1, mid = i + 2, right = nums.length - 1;
//            int c = target - nums[i];
//            if(i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
//            threeSum(nums,c,i+1);
//
//
//        }
//
//
//        return result;
//    }
//
//
//    // divide into 3sum problem
//    private static void threeSum(int[] nums, int target, int start){
//        System.out.println("nums[start]: "+ nums[start]+ "start: "+ start);
//        for (int i = start; i < nums.length-2; i++) {
//            // i-1 should be started from start not 0
//            if(i > start && nums[i] == nums[i - 1]){
//                continue;
//            }
//            int left = i + 1, right = nums.length - 1;
//            while (left < right){
//                if (target == nums[i] + nums[left] + nums[right]){
//                    List<Integer> tmp = new ArrayList<>();
//                    //maybe problem
//                    tmp.add(nums[start-1]);
//                    tmp.add(nums[i]);
//                    tmp.add(nums[left]);
//                    tmp.add(nums[right]);
//
//                    result.add(tmp);
//                    while (left < right && nums[left] == nums[left + 1])left++;
//                    while (left < right && nums[right] == nums[right - 1])right--;
//                    left++;
//                    right--;
//                }else if(target > nums[i] + nums[left] + nums[right]){
//                    left++;
//                }else{
//                    right--;
//                }
//
//            }
//        }
//        return;
//    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
}
