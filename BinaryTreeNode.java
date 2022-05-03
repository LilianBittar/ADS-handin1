import java.util.ArrayList;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private T element;

    public BinaryTreeNode(BinaryTreeNode<T> parent, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild, T element) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.element = element;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }


    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }



    public void addLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }
}
