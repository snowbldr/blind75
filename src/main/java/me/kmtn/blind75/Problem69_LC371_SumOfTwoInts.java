package me.kmtn.blind75;

//https://leetcode.com/problems/sum-of-two-integers/
public class Problem69_LC371_SumOfTwoInts {

    static int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
