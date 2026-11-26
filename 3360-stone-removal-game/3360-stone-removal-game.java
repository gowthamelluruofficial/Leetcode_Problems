class Solution {
    public boolean canAliceWin(int n) {
        int ans = 10;
        if(n<10) return false;
        boolean d = true;
        while(true){
            if(n<0) return true;
            if(!d) ans--;
            n -= ans;
            if(n<0) return false;
            ans--;
            d = false;
            n -= ans;
        }
    }
}