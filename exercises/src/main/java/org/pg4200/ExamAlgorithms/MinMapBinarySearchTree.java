package org.pg4200.ExamAlgorithms;

import org.pg4200.les05.MyMapTreeBased;

public class MinMapBinarySearchTree<K extends Comparable<K>, V> implements MyMapTreeBased<K,V> {
    protected class TreeNode{
        public K key;
        public V value;
        public TreeNode left;
        public TreeNode right;
    }

    protected TreeNode root;

    protected int size;

    @Override
    public void put(K key, V value) { root = put(key, value, root);}

    private TreeNode put(K key, V value, TreeNode subtreeRoot) {
        //Tree is empty, have to create a TreeNode
        if(subtreeRoot == null) {
            TreeNode node = new TreeNode();
            node.key = key;
            node.value = value;
            size++;
            return node;
        }

        //Determine if value of key is smaller or greater than root
        int compare = key.compareTo(subtreeRoot.key);

        if(compare < 0) {
            subtreeRoot.left = put(key, value, subtreeRoot.left);
            return subtreeRoot;
        }

        if(compare > 0) {
            subtreeRoot.right = put(key, value, subtreeRoot.right);
            return subtreeRoot;
        }

        assert compare == 0;
        subtreeRoot.value = value;

        return subtreeRoot;
    }

    @Override
    public int getMaxTreeDepth() {
        if(root == null) {
            return 0;
        }

        return depth(root);
    }

    protected int depth(TreeNode node) {

        int leftDepth = 0;
        int righDepth = 0;

        if(node.left != null) {
            leftDepth = depth(node.left);
        }

        if(node.right != null) {
            righDepth = depth(node.right);
        }

        return 1 + Math.max(leftDepth, righDepth);
    }

    @Override
    public void delete(K key) {
        root = delete(key, root);
    }

    protected TreeNode delete(K key, TreeNode subtreeRoot) {
        if(subtreeRoot == null) {
            return null;
        }

        int compare = key.compareTo(subtreeRoot.key);

        if(compare < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if(compare > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        //At this point we have traversed until we hit the key
        assert compare == 0;

        size--;

         /*
            What we are going to do here depends on the number of children:
            0
            1 (left or right)
            2
            The (2) is the most complex case.
            For the (1), just need to check which child is not-null, and that will become
            the new subtree returned when "this" node is deleted.
            If both children are missing (ie case 0), then the subtree is just "this" node.
            Once deleted, what is left is just a null subtree.
            So we return null.
            However, we do not need to explicitely have a check like
            "if(subtreeRoot.left == null && subtreeRoot.right == null) return null"
            as the following check would give the same result (ie returning null because
            subtreeRoot.right is null) even in the (0) case.
         */

        //Deleting depends on how many children the node has

        if(subtreeRoot.left == null) {
            return subtreeRoot.right;
        }

        if(subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        //This means both children are present

        TreeNode tmp = subtreeRoot;
        subtreeRoot = min(tmp.right);
        subtreeRoot.right = deleteMin(tmp.right);
        subtreeRoot.left = tmp.left;

        return subtreeRoot;
    }

    private TreeNode min(TreeNode subtreeRoot) {
        if (subtreeRoot.left == null) {
            return subtreeRoot;
        }
        return min(subtreeRoot.left);
    }

    private TreeNode deleteMin(TreeNode subtreeRoot) {
        if (subtreeRoot.left == null) {
            return subtreeRoot.right;
        }

        subtreeRoot.left = deleteMin(subtreeRoot.left);

        return subtreeRoot;
    }

    @Override
    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, TreeNode subtreeRoot) {
        if(subtreeRoot == null) {
            return null;
        }

        int compare = key.compareTo(subtreeRoot.key);

        if(compare == 0) {
            return subtreeRoot.value;
        } else if(compare < 0 && subtreeRoot.left != null) {
            //Look at the left of the tree
            return get(key, subtreeRoot.left);
        } else if(compare > 0 && subtreeRoot.right != null) {
            //Look at the right of the tree
            return get(key, subtreeRoot.right);
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
