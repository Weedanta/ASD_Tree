class IncompleteBinaryTree {
    public static BinaryTree createIncompleteTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(6);
        return tree;
    }
}