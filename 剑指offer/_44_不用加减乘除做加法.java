public class Solution {
    public int Add(int num1,int num2) {
        int carrayBit =  num1 & num2;
        int sum = num1 ^ num2;
        while (0 != carrayBit) {
           num1 = sum;
           num2 = (carrayBit << 1);
           carrayBit =  num1 & num2;
           sum = num1 ^ num2;
        }
        return sum;
    }
}
