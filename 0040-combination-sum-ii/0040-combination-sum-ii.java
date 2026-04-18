import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // step 1: sort
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> temp, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // stop if number exceeds target
            if (candidates[i] > target) break;

            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, temp, result);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}