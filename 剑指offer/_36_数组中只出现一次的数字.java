//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) return ;
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }
        int index = findFirstBit1(resultExclusiveOR);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
    
    private int findFirstBit1(int num) {
        int index = 0;
        while (((num & 1) == 0) && index < 4 * 8) {
            num = num >> 1;
            index++;
        }
        return index;
    }
    
    private boolean isBit1(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}