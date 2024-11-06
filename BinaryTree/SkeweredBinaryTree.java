class SkeweredBinaryTree {
    public static BinaryTree createSkeweredTree() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(3);
        tree.root.right.right.right = new Node(4);
        tree.root.right.right.right.right = new Node(5);
        return tree;
    }
}