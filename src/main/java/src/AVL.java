package src;

import java.util.ArrayList;
import java.util.List;

public class AVL<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVL() {
        root = null;
    }

    public void insert(T data) {
        if (data == null) {
            return;
        }
        root = insert(this.root, data);
    }

    private AVLNode<T> insert(AVLNode<T> current, T data) {
        if (current == null) {
            return new AVLNode<T>(data);
        } else {
            if (data.compareTo(current.getData()) < 0) {
                current.setLeft(insert(current.getLeft(), data));
            } else {
                current.setRight(insert(current.getRight(), data));
            }
        }
        updateHeight(current);
        return rebalance(current);
    }

    public boolean contains(T data) {
        return getNode(data) != null;
    }

    public AVLNode<T> getNode(T data) {
        return getNode(root, data);
    }

    private AVLNode<T> getNode(AVLNode<T> current, T data) {
        if (current == null) {
            return null;
        } else {

            if (data.compareTo(current.getData()) == 0) {
                return current;
            } else if (data.compareTo(current.getData()) < 0) {
                return getNode(current.getLeft(), data);
            } else {
                return getNode(current.getRight(), data);
            }
        }
    }

    public void remove(T data) {
        root = remove(root, data);
    }

    private AVLNode<T> remove(AVLNode<T> current, T data) {
        if (current == null) {
            return null;
        } else {
            if (data.compareTo(current.getData()) == 0) {
                if (current.getLeft() == null && current.getRight() == null) {
                    return null;
                } else if (current.getLeft() == null) {
                    return current.getRight();
                } else if (current.getRight() == null) {
                    return current.getLeft();
                } else {
                    T smallestValue = findSmallestValue(current.getRight());
                    current.setData(smallestValue);
                    current.setRight(remove(current.getRight(), smallestValue));
                }
            } else if (data.compareTo(current.getData()) < 0) {
                current.setLeft(remove(current.getLeft(), data));
            } else {
                current.setRight(remove(current.getRight(), data));
            }
            updateHeight(current);
            return rebalance(current);
        }
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        toList(root, list);
        return list;
    }

    private void toList(AVLNode<T> current, List<T> list) {
        if (current != null) {
            toList(current.getLeft(), list);
            list.add(current.getData());
            toList(current.getRight(), list);
        }
    }

    private T findSmallestValue(AVLNode<T> root) {
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    public int height(AVLNode<T> current) {
        return current == null ? -1 : current.getHeight();
    }

    private void updateHeight(AVLNode<T> current) {
        current.setHeight(Math.max(height(current.getLeft()), height(current.getRight())) + 1);
    }

    public int balanceFactor(AVLNode<T> current) {
        return (current == null) ? 0 : height(current.getRight()) - height(current.getLeft());
    }

    private AVLNode<T> rightRotation(AVLNode<T> current) {

        AVLNode<T> leftChild = current.getLeft();

        current.setLeft(leftChild.getRight());
        leftChild.setRight(current);

        updateHeight(current);
        updateHeight(leftChild);

        return leftChild;
    }

    private AVLNode<T> leftRotation(AVLNode<T> current) {
        AVLNode<T> rightChild = current.getRight();
        current.setRight(rightChild.getLeft());
        rightChild.setLeft(current);

        updateHeight(current);
        updateHeight(rightChild);

        return rightChild;
    }

    private AVLNode<T> rebalance(AVLNode<T> current) {
        int balanceFactor = balanceFactor(current);
        // Left heavy
        if (balanceFactor < -1) {
            if (balanceFactor(current.getLeft()) <= 0) {
                current = rightRotation(current);
            } else {
                current.setLeft(leftRotation(current.getLeft()));
                current = rightRotation(current);
            }
        }
        // Right Heavy
        if (balanceFactor > 1) {
            if (balanceFactor(current.getRight()) >= 0) {
                current = leftRotation(current);
            } else {
                current.setRight(rightRotation(current.getRight()));
                current = leftRotation(current);
            }
        }
        return current;
    }

    public String inOrder() {
        return inOrder(root);
    }

    public String inOrder(AVLNode<T> root) {
        if (root == null) {
            return "";
        }
        return inOrder(root.getLeft()) + root.getData() + " " + inOrder(root.getRight());
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String preOrder(AVLNode<T> root) {
        if (root == null) {
            return "";
        }
        return root.getData() + preOrder(root.getLeft()) + preOrder(root.getRight());
    }

    public String postOrder() {
        return postOrder(root);
    }

    public String postOrder(AVLNode<T> root) {
        if (root == null) {
            return "";
        }
        return postOrder(root.getLeft()) + postOrder(root.getRight()) + root.getData() + " ";
    }

    public String preOrderPrint() {
        preOrderPrint(root);
        return null;
    }

    private void preOrderPrint(AVLNode<T> current) {
        if (current != null) {
            System.out.println("(" + current.getData() + "," + balanceFactor(current) + ")");
            preOrderPrint(current.getLeft());
            preOrderPrint(current.getRight());
        }
    }


}
