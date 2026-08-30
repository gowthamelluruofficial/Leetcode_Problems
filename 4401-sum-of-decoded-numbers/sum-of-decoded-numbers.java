class Solution {
    public long len(long num) {
        long len = 0;
        while(num > 0) {
            len++;
            num /= 10;
        }
        return len;
    }
    public long power(long x, long y) {
        long mod = 1000000007;
        long ans = 1;
        x %= mod;
        while(y > 0) {
            if(y % 2 == 1) {
                ans = (ans * x) % mod;
            }
            x = (x * x) % mod;
            y /= 2;
        }
        return ans;
    }
    public int sumDecoded(long[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            long w = nums[i] % 10;
            nums[i] = nums[i] / 10;

            long a = (long)Math.pow(10, len(nums[i]));
            long b = (long)Math.pow(10, w);
            long c = a / b;

            long x = nums[i] / c;
            long y = nums[i] % c;

            long gh = power(x, y);

            ans = (ans + gh) % 1000000007;
        }

        return (int)ans;
    }
}