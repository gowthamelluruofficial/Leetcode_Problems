class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length();
        if(k==0 || n==0) return "";
        int count = 0;
        int l = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='1') count++;
            sb.append(ch);
            while(count>=k){
                char c = s.charAt(l);
                if(ans.size() > 0){
                    int x = ans.get(0).length();
                    if(x > sb.length() || (x == sb.length() && sb.toString().compareTo(ans.get(0)) < 0)){
                        ans.set(0, sb.toString());
                    }
                }else{
                    ans.add(sb.toString());
                }
                sb.deleteCharAt(0);
                if(c=='1')  count--;
                l++;
            }
        }
        int g = ans.size();
        System.out.println(g);
        return ans.size()>0?ans.get(0):"";
    }
}