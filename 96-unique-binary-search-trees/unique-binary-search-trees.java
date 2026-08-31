import java.math.BigInteger;
class Solution {
    public int numTrees(int ni) {
        BigInteger val = BigInteger.valueOf(ni);
        BigInteger n = BigInteger.valueOf(2 * ni);
        BigInteger r = val;
        BigInteger num = BigInteger.ONE;
        BigInteger den = BigInteger.ONE;
        for (long i = 2 * ni; i > ni; i--) {
            num = num.multiply(BigInteger.valueOf(i));
        }
        for (long i = 1; i <= ni; i++) {
            den = den.multiply(BigInteger.valueOf(i));
        }
        BigInteger rPlusOne = r.add(BigInteger.ONE);
        BigInteger ans = num.divide(den).divide(rPlusOne);
        return ans.intValue();
    }
}
