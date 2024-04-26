package collections;

public abstract class BinarySearchTree<T extends Comparable<T>> {

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

    public void remove(T value) {
        root = deleteNode(root, value);
    }

    private Node<T> deleteNode(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(deleteNode(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(deleteNode(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            Node<T> successor = findMin(node.getRight());
            node.setValue(successor.getValue());

            node.setRight(deleteNode(node.getRight(), successor.getValue()));
        }

        return node;
    }

    public Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

     public String preorden(){
         System.out.println(getRoot());
        return preordenR(getRoot());
    }

    private String preordenR(Node root) {
        StringBuilder sb = new StringBuilder();
        preordenH(root, sb);
        return sb.toString();
    }

    private void preordenH(Node<T> node, StringBuilder str){

        if (node != null){
           preordenH(node.getLeft(), str);
              str.append(node.getValue()).append(", ");
            preordenH(node.getRight(), str);

        }
    }

    public void setRoot(Node<T> node){
        this.root = node;
    }

    public Node<T> getRoot(){
        return this.root;
    }


    public T predecessor(T key) {
        // Inicializamos el nodo actual como la raíz del árbol.
        Node current = getRoot();
        // Inicializamos el nodo que almacenará el predecesor como null.
        Node predecessor = null;

        // Buscamos el nodo con la clave dada en el árbol.
        while (current != null && !current.equals(key)) {
            // Si la clave es menor que la del nodo actual, avanzamos hacia la izquierda.
            if (key.compareTo((T) current.getValue())  < 0) {
                current = current.getLeft();
            }
            // Si la clave es mayor que la del nodo actual, actualizamos el predecesor y avanzamos hacia la derecha.
            else {
                predecessor = current;
                current = current.getRight();
            }
        }

        // Si no encontramos el nodo con la clave dada, devolvemos null.
        if (current == null) {
            return null;
        }

        // Si el nodo tiene un subárbol izquierdo, el predecesor será el máximo de ese subárbol.
        if (current.getLeft() != null) {
            return maxR(current.getLeft());
        }

        // Si el nodo no tiene un subárbol izquierdo, el predecesor será el primer ancestro que es hijo derecho de su padre.
        return (predecessor != null) ? (T) predecessor.getValue() :  null;
    }


    public T maximum() {
        return maxR(root);
    }

    private T maxR(Node root) {
        // Si el nodo actual es nulo, no hay máximo, así que devolvemos null.
        if (root == null)
            return null;

        // Si el nodo actual no tiene un hijo derecho, entonces este nodo es el máximo.
        if (root.getRight() == null)
            return (T) root.getValue();

        // Si el nodo actual tiene un hijo derecho, buscamos el máximo en el subárbol derecho.
        return maxR(root.getRight());
    }

    public abstract Node<T> preorden(T value);


    // TODO: methods for insert, search (All the types) and delete
}