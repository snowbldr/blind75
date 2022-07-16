package me.kmtn.blind75;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/top-k-frequent-elements/
public class Problem68_LC347_TopKElements {

    static int[] topKFrequent(int[] nums, int k) {
        //bucket sort
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.compute(n, (key, v) -> v == null ? 1 : v + 1);
        }
        int[][] buckets = new int[nums.length+1][];
        for(Map.Entry<Integer, Integer> entry :counts.entrySet()){
            Integer count = entry.getValue();
            Integer n = entry.getKey();
            if(buckets[count] == null){
                buckets[count] = new int[]{n};
            } else {
                buckets[count] = Arrays.copyOf(buckets[count], buckets[count].length+1);
                buckets[count][buckets[count].length-1] = n;
            }
        }

        int[] res = new int[k];
        int found = 0;
        for(int i=buckets.length-1; i>=0; i--){
            if(buckets[i] != null){
                for(int n : buckets[i]){
                    res[found++] = n;
                    if(found >= k) break;
                }
            }
            if(found >= k) break;
        }
        return res;

    }

    static int[] topKFrequentQuickSelect(int[] nums, int k) {
        //quick select
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.compute(n, (key, v) -> v == null ? 1 : v + 1);
        }

        int[] unique = new int[counts.size()];
        int i = 0;
        for (Integer n : counts.keySet()) {
            unique[i++] = n;
        }
        quickSelect(0, unique.length - 1, unique.length - k, unique, counts);
        return Arrays.copyOfRange(unique, unique.length - k, unique.length);

    }

    static void quickSelect(int left, int right, int k, int[] nums, Map<Integer, Integer> counts) {
        if (left == right) return;
        int p = partition(left, right, right, nums, counts);
        if (k < p) {
            quickSelect(left, p - 1, k, nums, counts);
        } else if (k > p) {
            quickSelect(p + 1, right, k, nums, counts);
        }
    }

    static int partition(int left, int right, int pivotIndex, int[] nums, Map<Integer, Integer> counts) {
        int pivotCount = counts.get(nums[pivotIndex]);
        int p = left;
        for(int i=left; i<=right; i++){
            if(counts.get(nums[i]) < pivotCount){
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums, p, right);
        return p;
    }

    static void swap(int[] nums, int a, int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    }

    static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.compute(n, (key, v) -> v == null ? 1 : v + 1);
        }
        Comparator<Map.Entry<Integer, Integer>> comp = Map.Entry.comparingByValue();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comp.reversed());
        pq.addAll(counts.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        assertThat(topKFrequent(Util.intArray(1, 1, 1, 2, 2, 3), 2)).isEqualTo(Util.intArray(1,2));
        assertThat(topKFrequent(Util.intArray(1), 1)).isEqualTo(Util.intArray(1));
    }
}
