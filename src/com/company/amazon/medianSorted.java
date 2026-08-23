package com.company.amazon;

public class medianSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficiency
        // Binary search is performed on the smaller array to minimize operations
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Store the lengths of both arrays
        int x = nums1.length;
        int y = nums2.length;

        // Initialize binary search boundaries for the smaller array
        int low = 0;
        int high = x;

        while (low <= high) {
            // Calculate current partition positions for both arrays
            int partitionX = (low + high) / 2;  // Mid-point of current search space in nums1

            // This formula ensures the combined left partition always has (x+y+1)/2 elements,
            // which works for both odd and even total lengths
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Determine the elements at partition boundaries
            // When partition is at an edge, use MIN_VALUE or MAX_VALUE as appropriate

            // maxLeftX: Last element in left half of nums1
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // minRightX: First element in right half of nums1
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            // maxLeftY: Last element in left half of nums2
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            // minRightY: First element in right half of nums2
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            // Check if we've found the correct partition
            // For a valid partition: all elements in left partition <= all elements in right partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found the correct partition

                // Calculate median based on total length (odd or even)
                if ((x + y) % 2 != 0) {
                    // If total length is odd, median is the max of left partition elements
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    // If total length is even, median is average of max from left and min from right
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            }
            // If partition is not valid, adjust binary search boundaries
            else if (maxLeftX > minRightY) {
                // Left side of nums1 is too large, need to move partition left
                high = partitionX - 1;
            } else {
                // Left side of nums1 is too small, need to move partition right
                // (This means maxLeftY > minRightX)
                low = partitionX + 1;
            }
        }

        // This line should never be reached if arrays are sorted
        return 0;
    }
}
