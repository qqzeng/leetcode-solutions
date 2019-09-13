public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        int len = sequence.length;
        return VerifySquenceOfBSTRecursively(sequence, 0, len-1);
    }
    
    public boolean VerifySquenceOfBSTRecursively(int [] sequence, int i, int end) {
        if (i >= end) return true;
        int root = sequence[end];
        int leftIndex = -1;
        while (i < end && sequence[i] < root) {
            i++;
        }
        leftIndex = i-1;
        while (i < end && sequence[i] > root) {
           i++;
        }
        if (i != end) return false;
        return VerifySquenceOfBSTRecursively(sequence, 0, leftIndex)
            && VerifySquenceOfBSTRecursively(sequence, leftIndex+1, end-1);
    }
}