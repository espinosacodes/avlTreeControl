package collections;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    public Node<T> insert(T value){
        try{
            if (this.root == null){
                this.root = new Node<>(value);
                return root;

            } else {
                return insert(this.root, value);
            }
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private Node<T> insert(Node<T> node, T value) throws UnsupportedOperationException{
        if (node == null){
            return new Node<>(value);
        }

        if (value.compareTo(node.getValue()) < 0){
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0){
            node.setRight(insert(node.getRight(), value));
        } else {
            throw new UnsupportedOperationException("The tree can not save duplicate values");
        }

        return node;
    }

    public Node<T> find(T value){
        return find(this.root, value);
    }

    private Node<T> find(Node<T> node, T value){
        if (node == null || node.getValue().compareTo(value) == 0){
            return node;
        }

        if (value.compareTo(node.getValue()) < 0){
            return find(node.getLeft(), value);
        } else if (value.compareTo(node.getValue()) > 0){
            return find(node.getRight(), value);
        } else {
            return node;
        }
    }

    public String preorden(){
        StringBuilder str = new StringBuilder();
        preorden(this.root, str);

        if (str.isEmpty()){
            return "There aren't values inside the ABB";
        } else {
            str.deleteCharAt(str.length() - 2);
            return str.toString();
        }
    }

    private void preorden(Node<T> node, StringBuilder str){

        if (node != null){
            str.append(node.getValue()).append(", ");
            preorden(node.getLeft(), str);
            preorden(node.getRight(), str);
        }
    }



    // TODO: methods for insert, search (All the types) and delete
}
