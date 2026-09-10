    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */
    import java.util.*;

class Pair {
    TreeNode root;
    int index; // Track array index explicitly
    Pair(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}

class Twin {
    int p;     // Subtree Sum
    int child; // Subtree Node Count
    int val;   // Original Node Value

    Twin(int p, int child, int val) {
        this.p = p;
        this.child = child;
        this.val = val;
    }
}

class Solution {
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        // Map node pointer to its position index in level-order list
        List<TreeNode> nodes = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));
        nodes.add(root);

        // Map to store left/right child indices for each parent index
        Map<Integer, Integer> leftChild = new HashMap<>();
        Map<Integer, Integer> rightChild = new HashMap<>();

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.root;
            int idx = curr.index;

            if (node.left != null) {
                nodes.add(node.left);
                int childIdx = nodes.size() - 1;
                leftChild.put(idx, childIdx);
                queue.add(new Pair(node.left, childIdx));
            }

            if (node.right != null) {
                nodes.add(node.right);
                int childIdx = nodes.size() - 1;
                rightChild.put(idx, childIdx);
                queue.add(new Pair(node.right, childIdx));
            }
        }

        int n = nodes.size();
        Twin[] nodeData = new Twin[n];
        List<Twin> twinList = new ArrayList<>();

        // Bottom-Up processing from bottom of BFS list
        for (int i = n - 1; i >= 0; i--) {
            TreeNode node = nodes.get(i);
            int sum = node.val;
            int count = 1;

            // Add left child data if exists
            if (leftChild.containsKey(i)) {
                int lIdx = leftChild.get(i);
                sum += nodeData[lIdx].p;
                count += nodeData[lIdx].child;
            }

            // Add right child data if exists
            if (rightChild.containsKey(i)) {
                int rIdx = rightChild.get(i);
                sum += nodeData[rIdx].p;
                count += nodeData[rIdx].child;
            }

            nodeData[i] = new Twin(sum, count, node.val);
            twinList.add(nodeData[i]);
        }

        // Count matching nodes
        int matchingNodes = 0;
        for (Twin t : twinList) {
            if (t.val == (t.p / t.child)) {
                matchingNodes++;
            }
        }

        return matchingNodes;
    }
}