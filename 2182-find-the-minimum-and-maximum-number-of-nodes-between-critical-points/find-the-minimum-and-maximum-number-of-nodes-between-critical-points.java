/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode g = head;
        g = g.next;
        if(g.next==null) return new int[]{-1,-1};
        ArrayList<Integer> ans = new ArrayList<>();
        int val = head.val;
        ListNode temp = head.next;
        ListNode dummy = null;
        int i = 1;
        while(temp.next!=null){
            i++;
            dummy = temp.next;
            if(temp.val<val && temp.val<dummy.val){
                ans.add(i);
            }else if(temp.val>val && temp.val>dummy.val){
                ans.add(i);
            }
            val = temp.val;
            temp = temp.next;
        }
        if(ans.size()==0){
            return new int[]{-1,-1};
        }
        int[] arr = new int[2];
        arr[0] = Integer.MAX_VALUE;
        int n = ans.size();
        for(int j=0; j<n-1; j++){
            if(ans.get(j+1)-ans.get(j)<arr[0]){
                arr[0] = ans.get(j+1)-ans.get(j);
            }
        }
        arr[1] = ans.get(n-1)-ans.get(0);
        if(arr[0]==Integer.MAX_VALUE){
            Arrays.fill(arr,-1);
        }
        return arr;
    }
}