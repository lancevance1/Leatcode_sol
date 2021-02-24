/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m=nums2.length, i=0, j=0, k=0;
        int arr[] = new int[n+m];

        while(i < n && j < m){

            if(nums1[i] >= nums2[j]){
                arr[k]=nums2[j];
                j++;

            }else{
                arr[k]=nums1[i];
                i++;

            }
            k++;
            if (i == n){
                while(j<m){
                    arr[k]=nums2[j];
                    j++;
                    k++;
                }
            }
            if (j == m){
                while(i<n){
                    arr[k]=nums1[i];
                    i++;
                    k++;
                }
            }

        }
        if(n == 0){
            arr = nums2;
        }
        if(m==0){
            arr = nums1;
        }
        if((n+m)%2!=0){
            return arr[(n+m)/2];
        }else {
            return (arr[(n + m) / 2] + arr[(n + m) / 2 - 1]) * 1.0 / 2;
        }

    }
}
