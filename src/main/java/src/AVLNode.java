package src;

public class AVLNode<T extends Comparable<T>> {
    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height;

    public AVLNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public int getHeight() {
        return height;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }
}
