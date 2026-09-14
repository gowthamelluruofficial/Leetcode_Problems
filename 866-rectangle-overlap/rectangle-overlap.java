class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int a_1 = rec1[0];
        int a_2 = rec1[1];
        int c_1 = rec1[2];
        int c_2 = rec1[3];
        int b_1 = c_1;
        int b_2 = a_2;
        int d_1 = a_1;
        int d_2 = c_2;

        int p_1 = rec2[0];
        int p_2 = rec2[1];
        int r_1 = rec2[2];
        int r_2 = rec2[3];
        int q_1 = r_1;
        int q_2 = p_2;
        int s_1 = p_1;
        int s_2 = r_2;

        if(p_1 >= c_1 || r_1 <= a_1) return false;
        if(p_2 >= c_2 || r_2 <= a_2) return false;
        
        return true;
    }
}