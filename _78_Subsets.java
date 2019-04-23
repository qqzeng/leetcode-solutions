class Solution {

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<Integer>());
        if (nums == null) return result;
        for (int i = 1; i <= nums.length; i++) {
            backtracking(result, 0, i, nums, new ArrayList<Integer>());
        }
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, int index, int count, int[] nums, ArrayList<Integer> curRes) {
        if (curRes.size() == count) {
            result.add(new ArrayList<>(curRes));
            return ;
        }
        
        for (int i = index; i < nums.length; i++) {
            curRes.add(nums[i]);
            backtracking(result, i+1, count, nums, curRes);            
            curRes.remove(curRes.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        List<Integer> curRes = new ArrayList<>();
        res.add(curRes);
        if (nums.length == 1) {
            List<Integer> curRes1 = new ArrayList<>();
            curRes1.add(nums[0]);
            res.add(new ArrayList<>(curRes1));
            return res;
        }

        boolean used[] = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            List<List<Integer>> r = new ArrayList<>();
            sBacktracking(r, used, nums, i, 0, new ArrayList<Integer>());
            res.addAll(r);
        }

        return res;
    }

    private void sBacktracking(List<List<Integer>> r, boolean used[], int[] nums, int len, int index,  ArrayList<Integer> curRes) {
        if (curRes.size() == len) {
            r.add(new ArrayList<>(curRes));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!used[i]) {
                curRes.add(nums[i]);
                used[i] = true;
                sBacktracking(r, used, nums, len, i+1, curRes);
                used[i] = false;
                curRes.remove(curRes.size()-1);
            }
        }
    }
	
}