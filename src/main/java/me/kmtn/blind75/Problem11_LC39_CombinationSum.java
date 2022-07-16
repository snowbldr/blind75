package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/combination-sum/
public class Problem11_LC39_CombinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        findCombinations(0, new ArrayList<>(), candidates, target, results);
        return results;
    }

    static void findCombinations(int index, List<Integer> currentCombo, int[] nums, int target, List<List<Integer>> results) {
        if(index >= nums.length) return;
        int currentSum = currentCombo.stream().mapToInt(i -> i).sum();
        if(currentSum == target){
            results.add(new ArrayList<>(currentCombo));
            return;
        }
        if(currentSum > target){
            return;
        }
        currentCombo.add(nums[index]);
        findCombinations(index, currentCombo, nums, target, results);
        currentCombo.remove(currentCombo.size() - 1);
        findCombinations(index+1, currentCombo, nums, target, results);
    }

    public static void main(String[] args) {
        assertThat(combinationSum(new int[]{2, 3, 6, 7}, 7)).isEqualTo(List.of(List.of(2, 2, 3), List.of(7)));
    }
}
