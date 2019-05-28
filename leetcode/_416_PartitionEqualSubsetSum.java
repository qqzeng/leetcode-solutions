class Solution {
    
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        boolean[][] memo = new boolean[nums.length + 1][sum/2 + 1];
        
        memo[0][0] = true;
    
        for (int i = 1; i < nums.length+1; i++) {
            memo[i][0] = true;
        }
        for (int j = 1; j < sum / 2+1; j++) {
            memo[0][j] = false;
        }
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (nums[i] > j) continue;
                memo[i][j] = memo[i-1][j] || memo[i-1][j-nums[i]];
                // if (memo[i][sum / 2]) return true;
                
                // memo[i][j] = dp[i-1][j];
                // if (j >= nums[i-1]) {
                //     memo[i][j] = (memo[i][j] || memo[i-1][j-nums[i-1]]);
                // }
            }
        }
        return memo[nums.length-1][sum/2];
        // return false;
    }
    
    
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        boolean[] memo = new boolean[sum/2 + 1];
        memo[0] = true;

        for ( int i = 1; i < nums.length; i++ ) {
            for ( int j = sum/2; j >= nums[i]; j-- ) {
                memo[j] = memo[j] || memo[ j - nums[i]];
            }
        }

        return memo[sum/2];
    }
    
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        ArrayList<Integer> result = new ArrayList<>();
        int[][] memo = new int[nums.length][sum/2 + 1];
        return tryPartition(memo, nums.length - 1, nums, sum / 2);
    }
    
    
    public boolean tryPartition(int[][] memo, int index, int[] nums, int sum) {
        
        if (sum == 0) return true;
        if (index < 0 || sum < 0) return false;
                
        if (memo[index][sum] != 0) {
            return memo[index][sum] == 1;
        }
        
        memo[index][sum] = (tryPartition(memo, index - 1, nums, sum) || tryPartition(memo, index - 1, nums, sum - nums[index])) 
            ? 1 : -1;
        
        return memo[index][sum] == 1;
    }
    
    // Time Limit Exceeded
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 == 1) return false;
        ArrayList<Integer> result = new ArrayList<>();
        return sumBT(result, sum / 2, 0, nums);
    }
    
    private boolean sumBT(ArrayList<Integer> result, int remain, int index, int[] nums) {
        if (index >= nums.length) {
            return remain == 0;
        }
        
        boolean success = false;
        for (int i = index; i < nums.length; i++) {
            if (remain - nums[i] >= 0) {
                result.add(nums[i]);
                success = success || sumBT(result, remain - nums[i], i+1, nums);
                if (success) return true;
                result.remove(result.size() - 1);
            }
        }
        return false;
    } 
}