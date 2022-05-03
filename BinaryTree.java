import com.sun.source.tree.BreakTree;

import java.util.ArrayList;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree(BinaryTreeNode<T> root, int size) {
        this.root = root;
        this.size = size;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public boolean contains(T element){
        return treeSearch(root,element);
    }

    //helper function to search in the tree
    private boolean treeSearch(BinaryTreeNode<T> x, T element){
        if (x == null) return false;
        if (x.getElement().equals(element)) return true;

        return treeSearch(x.getLeftChild(),element) || treeSearch(x.getRightChild(), element);
    }

    public ArrayList<T> inOrder(){
        return root == null ? null : inOrderHelper(root);
    }

    //helper function to return inOrder tree
    private ArrayList<T> inOrderHelper(BinaryTreeNode<T> x){
        ArrayList<T> toReturn = new ArrayList<T>();
        if (x != null){
            toReturn = inOrderHelper(x.getLeftChild());
            toReturn.add(x.getElement());
            toReturn.addAll(inOrderHelper(x.getRightChild()));
        }
        return toReturn;
    }

    public ArrayList<T> preOrder(){
        return root == null ? null : preOrderHelper(root);
    }

    //helper function to return preorder tree
    private ArrayList<T> preOrderHelper(BinaryTreeNode<T> x){
        ArrayList<T> toReturn = new ArrayList<T>();
        if (x != null){
            toReturn.add(x.getElement());
            toReturn.addAll(inOrderHelper(x.getLeftChild()));
            toReturn.addAll(inOrderHelper(x.getRightChild()));
        }
        return toReturn;
    }

    public ArrayList<T> postOrder(){
        return root == null ? null : postOrderHelper(root);
    }

    //helper function to return preorder tree
    private ArrayList<T> postOrderHelper(BinaryTreeNode<T> x){
        ArrayList<T> toReturn = new ArrayList<T>();
        if (x != null){
            toReturn.addAll(inOrderHelper(x.getLeftChild()));
            toReturn.addAll(inOrderHelper(x.getRightChild()));
            toReturn.add(x.getElement());
        }
        return toReturn;
    }
    public ArrayList<T> levelOrder(){
        ArrayList<T> toReturn = new ArrayList<T>();
        ArrayList<BinaryTreeNode<T>> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.remove(0);
            queue.add(node.getLeftChild());
            queue.add(node.getRightChild());
            toReturn.add(node.getElement());
        }
        return toReturn;
    }

    public int height(){
        return isEmpty() ? -1 : heightHelper(root);
    }

    private int heightHelper(BinaryTreeNode<T> root){
        if (root == null) return 0;
        else {
            int lheight = heightHelper(root.getLeftChild());
            int rheight = heightHelper(root.getRightChild());

            if (lheight > rheight) return lheight + 1;
            else return rheight + 1;
        }
    }
}
