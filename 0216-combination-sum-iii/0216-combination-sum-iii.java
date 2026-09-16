class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        int[] arr = {1,2,3,4,5,6,7,8,9};

        helper(0, k, n, ll, ans, arr);

        return ans;
    }

    private void helper(int idx, int size, int target,
                        List<Integer> ll,
                        List<List<Integer>> ans,
                        int[] arr) {

        // exactly k elements choose ho gaye
        if (ll.size() == size) {

            if (target == 0) {
                ans.add(new ArrayList<>(ll));
            }

            return;
        }

        if (idx == arr.length) {
            return;
        }

        // TAKE
        ll.add(arr[idx]);

        helper(idx + 1, size, target - arr[idx],
               ll, ans, arr);

        // UNDO
        ll.remove(ll.size() - 1);

        // NOT TAKE
        helper(idx + 1, size, target,
               ll, ans, arr);
    }
}