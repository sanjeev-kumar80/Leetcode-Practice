class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        helper(0, ll, ans, arr, target);

        return ans;
    }

    public void helper(int idx, List<Integer> ll,
                       List<List<Integer>> ans,
                       int[] arr, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            // same level duplicate skip
            if (i > idx && arr[i - 1] == arr[i]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            // TAKE
            ll.add(arr[i]);

            // i + 1 => element reuse nahi hoga
            helper(i + 1, ll, ans, arr, target - arr[i]);

            // UNDO
            ll.remove(ll.size() - 1);
        }
    }
}