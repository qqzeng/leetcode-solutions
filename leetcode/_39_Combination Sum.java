class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        int sum = 0;
        backtracking(res, candidates, sum, target, 0, new ArrayList<Integer>());
        return res;
    }
    
    private void backtracking(ArrayList<List<Integer>> res, int[] candidates, 
                              int sum, int target, int index, ArrayList<Integer> curRes) {
        if (sum == target) {
            // Collections.sort(curRes);
            // if (!res.contains(curRes)) {
                res.add(new ArrayList<>(curRes));
            // }
            return ;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (sum+candidates[i] <= target) {
                sum += candidates[i];
                curRes.add(candidates[i]);
				// 数组中的值可以重复复用，因此，下一个仍旧从 index 开始
                backtracking(res, candidates, sum, target, i, curRes);
                sum -= candidates[i];
                curRes.remove((Integer)candidates[i]);
            }
        }
    }
}