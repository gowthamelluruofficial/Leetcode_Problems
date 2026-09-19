class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(x, x2));
        int closestY = Math.max(y1, Math.min(y, y2));
        int dx = x - closestX;
        int dy = y - closestY;
        return dx * dx + dy * dy <= r * r;
    }
}