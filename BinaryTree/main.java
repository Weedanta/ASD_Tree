

public class main {
    public static void main(String[] args) {
        BinaryTree skeweredTree = SkeweredBinaryTree.createSkeweredTree();
        System.out.println("Preorder Skewered Tree:");
        skeweredTree.preorderTraversal(skeweredTree.root);
        BinaryTree fullTree = FullBinaryTree.createFullTree();
        System.out.println("\nPreorder Full Tree:");
        fullTree.preorderTraversal(fullTree.root);
        BinaryTree completeTree = CompleteBinaryTree.createCompleteTree();
        System.out.println("\nPreorder Complete Tree:");
        completeTree.preorderTraversal(completeTree.root);
        BinaryTree incompleteTree = IncompleteBinaryTree.createIncompleteTree();
        System.out.println("\nPreorder Incomplete Tree:");
        incompleteTree.preorderTraversal(incompleteTree.root);
    }
}
