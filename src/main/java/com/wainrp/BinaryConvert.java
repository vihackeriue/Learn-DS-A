package com.wainrp;

public class BinaryConvert {
    public static int binaryToDecimal(int  binaryNumber){
        int decimal = 0, i = 0;
        while(binaryNumber != 0){


            decimal += (binaryNumber%10) * Math.pow(2,i);
            binaryNumber /= 10;
            i++;
        }
        return decimal;
    }
    public static int decimalToBinary(int  decimalNumber){
        int kq = 0;
        int p = 0;
        while (decimalNumber > 0) {
//            kq += n%2 + kq;
            kq += (decimalNumber%2)*(int)Math.pow(10, p) ;
            decimalNumber = decimalNumber/2;
            p++;

        }
        return kq;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(decimalToBinary(n));
        System.out.println(binaryToDecimal(1100100));
    }


}
