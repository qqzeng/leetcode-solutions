import java.util.ArrayList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null || target == 0) return result;
        ArrayList<Integer> curPath = new ArrayList<>();
        findPath(root, result, 0, target, curPath);
        return result;
    }
    
    private void findPath(TreeNode node, ArrayList<ArrayList<Integer>> result, int curSum, 
                     int expectedSum, ArrayList<Integer> curPath) {
        curSum += node.val;
        curPath.add(node.val);
        if (node.left == null && node.right == null) {
            if (curSum == expectedSum) {
                result.add(new ArrayList<>(curPath));
            }
        } else {
            if (node.left != null) {
                findPath(node.left, result, curSum, expectedSum, curPath);
            }
            if (node.right != null) {
                findPath(node.right, result, curSum, expectedSum, curPath);
            }
        }
        curPath.remove(curPath.size() - 1);
    }
    
    
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}