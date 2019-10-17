package com.david.leetcode;

public class GasStation {

    /*
    The core thought is that if you can travel around the circuit once,
    the sum of gas must be bigger or equals to the sum of the cost.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int j = i;
            int remain = gas[j];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % length];
                j = (j + 1) % length;

                if (i == j) {
                    return i;
                }
            }

            if (j < i) {
                return -1;
            }

            i = j;
        }

        return -1;
    }
}
