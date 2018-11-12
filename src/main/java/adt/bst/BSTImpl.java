package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

    protected BSTNode<T> root;

    public BSTImpl() {
        root = new BSTNode<T>();
    }

    /**
     * Returns the root of the tree.
     */
    public BSTNode<T> getRoot() {
        return this.root;
    }

    /**
     * Say if a BT is empty (NIL).
     */
    @Override
    public boolean isEmpty() {
        return root.isEmpty();
    }

    /**
     * The height of a BT. An empty BT has height -1 (there is no root element). In non-empty BT the height is given
     * by 1 + (the highest height of its sub-trees).
     */
    @Override
    public int height() {
        return this.height(this.root);
    }

    private int height(BSTNode<T> node) {
        int height = -1;

        if (!node.isEmpty()) {
            int left = this.height((BSTNode<T>) node.getLeft());
            int right = this.height((BSTNode<T>) node.getRight());
            height = 1 + Math.max(left, right);
        }

        return height;
    }

    /**
     * Searches an element in a BT. The search starts at the root node. If the key does not exist the methods returns
     * a NIL (empty) node.
     */
    @Override
    public BSTNode<T> search(T element) {
        return this.search(this.root, element);
    }

    private BSTNode<T> search(BSTNode<T> node, T element) {
        BSTNode nodeFound = new BSTNode.Builder<T>().build();

        if (node.isEmpty() || node.getData().equals(element)) {
            nodeFound = node;
        } else if (node.getData().compareTo(element) > 0) {
            nodeFound = this.search((BSTNode<T>) node.getLeft(), element);
        } else if (node.getData().compareTo(element) < 0) {
            nodeFound = this.search((BSTNode<T>) node.getRight(), element);
        }

        return nodeFound;
    }

    /**
     * Inserts an element in a BT.
     */
    @Override
    public void insert(T element) {
        this.insert(this.root, element);
    }

    private void insert(BSTNode<T> node, T element) {
        if (node.isEmpty()) {
            node.setData(element);
            node.setLeft(new BSTNode.Builder<T>().parent(node).build());
            node.setRight(new BSTNode.Builder<T>().parent(node).build());
        } else if (node.getData().compareTo(element) > 0) {
            this.insert((BSTNode<T>) node.getLeft(), element);
        } else if (node.getData().compareTo(element) < 0) {
            this.insert((BSTNode<T>) node.getRight(), element);
        }
    }

    /**
     * Returns the node containing the greatest element in a BST. If the tree is empty the method returns null.
     */
    @Override
    public BSTNode<T> maximum() {
        return this.maximum(this.root);
    }

    private BSTNode<T> maximum(BSTNode<T> node) {
        if (!node.getRight().isEmpty()) {
            node = this.maximum((BSTNode<T>) node.getRight());
        }

        if (node.isEmpty()) {
            node = null;
        }

        return node;
    }

    @Override
    public BSTNode<T> minimum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> sucessor(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public BSTNode<T> predecessor(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] preOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] order() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public T[] postOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * This method is already implemented using recursion. You must understand
     * how it work and use similar idea with the other methods.
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        int result = 0;
        // base case means doing nothing (return 0)
        if (!node.isEmpty()) { // indusctive case
            result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
        }

        return result;
    }

}
