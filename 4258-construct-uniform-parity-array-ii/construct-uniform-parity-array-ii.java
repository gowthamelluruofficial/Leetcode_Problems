class Solution {
    public boolean uniformArray(int[] nums) {
        int mn = nums[0];

        for (int x : nums) {
            mn = Math.min(mn, x);
        }

        for (int x : nums) {
            if (mn % 2 == 0 && x % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}