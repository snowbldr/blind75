package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/coin-change/
public class Problem65_LC322_CoinChange {

    static int coinChange(int[] coins, int amount) {
        return 0;
    }


    public static void main(String[] args) {
        assertThat(coinChange(Util.intArray(186,419,83,408), 6249)).isEqualTo(20);
        assertThat(coinChange(Util.intArray(1,2,5), 11)).isEqualTo(3);
        assertThat(coinChange(Util.intArray(2), 3)).isEqualTo(-1);
        assertThat(coinChange(Util.intArray(1), 0)).isEqualTo(0);

    }
}
