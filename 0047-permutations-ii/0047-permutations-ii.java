class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        helper(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(
        int[] nums,
        boolean[] used,
        List<Integer> curr,
        List<List<Integer>> ans
    ) {

        // Base case
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            // Duplicate at same level
            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !used[i - 1]) {
                continue;
            }

            // Choose
            used[i] = true;
            curr.add(nums[i]);

            // Recursion
            helper(nums, used, curr, ans);

            // Backtrack
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}