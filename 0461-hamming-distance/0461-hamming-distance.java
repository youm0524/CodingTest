class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        System.out.println(xor);
        return Integer.bitCount(xor);
        
    }
}