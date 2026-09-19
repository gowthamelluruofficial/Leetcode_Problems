class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        int closestX;
        int closestY;
        if (x >= x1 && x <= x2)
            closestX = x;
        else
            closestX = Math.abs(x - x1) < Math.abs(x - x2) ? x1 : x2;
        if (y >= y1 && y <= y2)
            closestY = y;
        else
            closestY = Math.abs(y - y1) < Math.abs(y - y2) ? y1 : y2;
        int dx = x - closestX;
        int dy = y - closestY;
        return dx * dx + dy * dy <= r * r;
    }
}