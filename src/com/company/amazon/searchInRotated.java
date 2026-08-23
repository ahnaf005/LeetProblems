package com.company.amazon;

public class searchInRotated {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1; // Fixed: right boundary should be the last index

        while (left <= right) { // Use <= to handle single element arrays
            int mid = left + (right - left) / 2; // Prevents integer overflow

            // If target found, return immediately
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part of the array is properly sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                // Check if target is in the sorted left side
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right side is sorted
                // Check if target is in the sorted right side
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }
}
