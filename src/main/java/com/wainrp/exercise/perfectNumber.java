package com.wainrp.exercise;

public class perfectNumber {
    public static boolean isPerfectNumber(int num) {
        if(num <= 1) return false;

        int sum = 1;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                sum += i;

            if(i != num/i) sum += num/i;

            }
        }

        return  sum == num;
    }

    public static void main(String[] args) {
        int num = 28;

        System.out.println(isPerfectNumber(num));
//        System.out.println("Các số hoàn hảo nhỏ hơn " + num + " là:");
//        for (int i = 2; i < num; i++) {
//            if (isPerfectNumber(i)) {
//                System.out.println(i);
//            }
//        }
    }


}
