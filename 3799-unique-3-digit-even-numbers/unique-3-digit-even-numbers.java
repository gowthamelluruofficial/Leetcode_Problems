class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:digits){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int ans = 0;
        for(int j=100; j<=998; j+=2){
            int i = j;
            int a = i%10;
            i/=10;
            int b = i%10;
            i/=10;
            int c = i%10;
            if(hm.containsKey(a)){
                int val = hm.get(a);
                if(val==1) hm.remove(a);
                else hm.put(a,val-1);
                if(hm.containsKey(b)){
                    val = hm.get(b);
                    if(val==1) hm.remove(b);
                    else hm.put(b,val-1);
                    if(hm.containsKey(c)){
                        val = hm.get(c);
                        if(val==1) hm.remove(c);
                        else hm.put(c,val-1);
                        ans++;
                    }
                }
            }else continue;
            hm = new HashMap<>();
            for(int in:digits){
                hm.put(in,hm.getOrDefault(in,0)+1);
            }
        }
        return ans;
    }
}