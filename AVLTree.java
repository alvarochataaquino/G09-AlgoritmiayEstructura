package arbolesAVL;

public class AVLTree {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        // 1. Insertar como en un BST normal
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node; // no permite duplicados
        }

        // 2. Actualizar factor de equilibrio
        node.bf = height(node.right) - height(node.left);

        // 3. Desbalance hacia la derecha (bf > 1)
        if (node.bf > 1) {
            if (data < node.right.data) {
                // Caso derecha-izquierda: rotación doble
                System.out.println("  Desbalance en nodo " + node.data + " (bf=" + node.bf + ")");
                System.out.println("  Se aplica rotacion doble derecha-izquierda");
                node.right = rotateRight(node.right);
            } else {
                // Caso derecha-derecha: rotación simple izquierda
                System.out.println("  Desbalance en nodo " + node.data + " (bf=" + node.bf + ")");
                System.out.println("  Se aplica rotacion simple izquierda");
            }
            return rotateLeft(node);
        }

        // 4. Desbalance hacia la izquierda (bf < -1)
        if (node.bf < -1) {
            if (data > node.left.data) {
                // Caso izquierda-derecha: rotación doble
                System.out.println("  Desbalance en nodo " + node.data + " (bf=" + node.bf + ")");
                System.out.println("  Se aplica rotacion doble izquierda-derecha");
                node.left = rotateLeft(node.left);
            } else {
                // Caso izquierda-izquierda: rotación simple derecha
                System.out.println("  Desbalance en nodo " + node.data + " (bf=" + node.bf + ")");
                System.out.println("  Se aplica rotacion simple derecha");
            }
            return rotateRight(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        Node temp = newRoot.left;
        newRoot.left = node;
        node.right = temp;
        // Actualizar factores después de rotar
        node.bf = height(node.right) - height(node.left);
        newRoot.bf = height(newRoot.right) - height(newRoot.left);
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        Node temp = newRoot.right;
        newRoot.right = node;
        node.left = temp;
        // Actualizar factores después de rotar
        node.bf = height(node.right) - height(node.left);
        newRoot.bf = height(newRoot.right) - height(newRoot.left);
        return newRoot;
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String space, boolean isRoot) {
        if (node != null) {
            System.out.println(space + (isRoot ? "└── " : "├── ") + node);
            printTree(node.left,  space + " ", false);
            printTree(node.right, space + " ", false);
        }
    }
}