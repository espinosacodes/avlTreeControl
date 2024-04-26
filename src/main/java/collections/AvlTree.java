package collections;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AvlTree(){
    }

    // Sobrescribimos el método de inserción para asegurarnos de que el árbol se reequilibre
    @Override
    public Node<T> insert(T value) {
        Node<T> newNode = super.insert(value); // Insertamos el nodo normalmente

        if (newNode != null) {
            setRoot(balance(getRoot())); // Reequilibramos el árbol después de la inserción
        }





        return newNode;
    }

    @Override
    public void remove(T value) {
        setRoot(deleteNode(getRoot(), value));
        setRoot(balance(getRoot())); // Reequilibrar después de la eliminación
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
            if (node.getLeft() == null || node.getRight() == null) {
                return (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }

            Node<T> successor = findMin(node.getRight());
            node.setValue(successor.getValue());

            node.setRight(deleteNode(node.getRight(), successor.getValue()));
        }

        return balance(node);
    }

    // Método para reequilibrar el árbol AVL
    // Método para reequilibrar el árbol AVL
    public Node<T> balance(Node<T> node) {
        // Calculamos el factor de equilibrio para el nodo dado
        int balanceFactor = getBalanceFactor(node);

        // Si el nodo está desequilibrado, reequilibramos
        if (balanceFactor > 1) {
            // Caso Izquierda-Izquierda (LL) o Izquierda-Derecha (LR)
            if (getBalanceFactor(node.getLeft()) >= 0) {
                // Caso LL: Rotación a la derecha
                return rightRotation(node);
            } else {
                // Caso LR: Doble rotación (izquierda y luego derecha)
                node.setLeft(leftRotation(node.getLeft()));
                return rightRotation(node);
            }
        } else if (balanceFactor < -1) {
            // Caso Derecha-Derecha (RR) o Derecha-Izquierda (RL)
            if (getBalanceFactor(node.getRight()) <= 0) {
                // Caso RR: Rotación a la izquierda
                return leftRotation(node);
            } else {
                // Caso RL: Doble rotación (derecha y luego izquierda)
                node.setRight(rightRotation(node.getRight()));
                return leftRotation(node);
            }
        }

        // Si el nodo está equilibrado, simplemente lo devolvemos
        return node;
    }

    // Realiza una rotación a la izquierda
    private Node<T> leftRotation(Node<T> node) {
        Node<T> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        return newRoot;
    }

    // Realiza una rotación a la derecha
    private Node<T> rightRotation(Node<T> node) {
        Node<T> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        return newRoot;
    }

    // Obtiene el factor de equilibrio de un nodo
    private int getBalanceFactor(Node<T> node) {
        if (node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    // Calcula la altura de un nodo
    private int height(Node<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    @Override
    public String preorden(){

        return preordenR(getRoot());
    }

    private String preordenR(Node root) {
        StringBuilder sb = new StringBuilder();
        preordenH(root, sb);
        return sb.toString();
    }

    private void preordenH(Node<T> node, StringBuilder str) {
        if (node != null) {
            str.append(node.getValue()).append(", "); // Primero visitamos la raíz
            preordenH(node.getLeft(), str); // Luego el subárbol izquierdo
            preordenH(node.getRight(), str); // Finalmente el subárbol derecho
        }
    }


    @Override
    public Node<T> preorden(T value) {
        return null;
    }


}
