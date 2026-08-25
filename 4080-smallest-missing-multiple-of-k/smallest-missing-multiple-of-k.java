class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[101];
        int mn = -1;
        for(int i:nums){
            arr[i]++;
            if(i>mn) mn = i;
        }
        int m = k;
        while(k<=1000){
            if(k<=mn && arr[k]!=0) k+=m;
            else return k;
        }
        return -1;
    }
}