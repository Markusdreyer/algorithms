package org.pg4200.ExamAlgorithms;

import org.pg4200.les05.MyMapTreeBased;

/**
 * {@link org.pg4200.les05.MyMapBinarySearchTree}
 */

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

        if(subtreeRoot == null) {
            TreeNode node = new TreeNode();
            node.key = key;
            node.value = value;
            size++;
            return node;
        }


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

        assert compare == 0;

        size--;

        if(subtreeRoot.left == null) {
            return subtreeRoot.right;
        }


        if(subtreeRoot.right == null) {
            return subtreeRoot.left;
        }


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
