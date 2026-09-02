class Solution{
    public boolean ispossible(int[] arr){
        for(int i:arr){
            if(i==Integer.MIN_VALUE) return false;
        }
        return true;
    }
    public boolean uniformArray(int[] nums1){
        int n=nums1.length;
        int[] num2=new int[n];
        Arrays.fill(num2,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i){
                    if(nums1[i]%2==0){
                        num2[i]=nums1[j];
                    }
                }else if((nums1[i]-nums1[j])%2==0){
                    num2[i]=nums1[i]-nums1[j];
                }
            }
        }
        boolean check1=ispossible(num2);
        if(check1) return true;
        Arrays.fill(num2,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i){
                    if(nums1[i]%2!=0){
                        num2[i]=nums1[j];
                    }
                }else if((nums1[i]-nums1[j])%2!=0){
                    num2[i]=nums1[i]-nums1[j];
                }
            }
        }
        boolean check2=ispossible(num2);
        if(check2) return true;
        return false;
    }
}