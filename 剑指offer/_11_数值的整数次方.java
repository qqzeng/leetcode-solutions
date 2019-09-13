public class Solution {
    
    public double Power(double base, int exponent) { 
        if(exponent==0 && base != 0)
            return 1;
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){ 
            return 0;
        }
        int n= exponent;
        if(exponent<0){
            n = -exponent;
        }
        double result=Power(base,n>>1);
        result*=result;
        if((n&0x1)==1)
            result*=base; 
        if(exponent<0)
            result=1/result;
        return result;     
  }
}