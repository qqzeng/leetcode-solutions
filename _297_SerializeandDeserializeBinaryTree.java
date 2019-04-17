/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        ArrayList<String> nodes = new ArrayList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(ArrayList<String> nodes) {
        String val = nodes.remove(0);
        if (val.equals("#")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         if (root == null) return "";
//         StringBuilder sb = new StringBuilder();
//         ser(root, sb);
//         return sb.toString();
//     }
    
//     private void ser(TreeNode root, StringBuilder sb) {
//         if (root == null) {
//             sb.append("#,");
//             return;
//         }
//         sb.append(root.val + ",");
//         ser(root.left, sb);
//         ser(root.right, sb);
//     }

//     // Decodes your encoded data to tree.
//     int index = -1;
//     public TreeNode deserialize(String data) {
//         if (data == null || data.equals("")) return null;
//         index++;
//         String[] strArr = data.split(",");
//         if (index == strArr.length) return null;
//         if (!(strArr[index].equals("#"))) {
//             TreeNode tn = new TreeNode(Integer.valueOf(strArr[index]));
//             tn.left = deserialize(data);
//             tn.right = deserialize(data);
//             return tn;
//         }
//         return null;
//     }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));