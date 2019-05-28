class Solution {
	public static List<List<Integer>> threeSum4(int[] nums) {
		List<List<Integer>> result = new ArrayList();
		if (nums == null || nums.length < 3) return result;
		
		Arrays.sort(nums);
		int m = nums.length;
		if (nums[0] > 0 || nums[m-1] < 0) return result;
		
		for (int i = 0; i < m - 2; i++) {
			if (i == 0 || nums[i] != nums[i-1]) {
				int left = i + 1;
				int right = m - 1;
				int sum = - nums[i];
				while (left < right) {
					if (nums[left] + nums[right] < sum) {
						left++;
					} else if (nums[left] + nums[right] > sum) {
						rigth--;
					} else {
						result.add(Arrays.asList(nums[i], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left+1]) left++;
						while (left < right && nums[right] == nums[right-1]) right--;
						left++;
						right--;
					}
				}
			}
		}
		return result;
	}
}