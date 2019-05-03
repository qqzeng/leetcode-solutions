/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curNum = 1;
        int nextNum = 0;
        while (queue.size() > 0 && curNum > 0) {
            List<Integer> res = new ArrayList<>();
            while (curNum-- > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextNum++;
                }
            }
            curNum = nextNum;
            nextNum = 0;
            result.addFirst(res);
        }
        return result;
    }
}