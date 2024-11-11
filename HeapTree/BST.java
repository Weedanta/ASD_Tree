import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BST {

    // Method to insert a value into the BST
    public static TreeNode insertToBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insertToBST(root.left, value);
        } else {
            root.right = insertToBST(root.right, value);
        }
        return root;
    }

    // Method to build the BST from input values
    public static TreeNode buildBST(int[] values) {
        TreeNode root = null;
        for (int value : values) {
            root = insertToBST(root, value);
        }
        return root;
    }

    // Method to perform postorder traversal
    public static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] values = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            values[i] = Integer.parseInt(input[i]);
        }

        // Build BST and get the root
        TreeNode root = buildBST(values);

        // Get the left subtree of the root (small side)
        TreeNode smallSide = root.left;

        // Perform postorder traversal on the small side
        List<Integer> result = new ArrayList<>();
        postorderTraversal(smallSide, result);

        // Print the results
        System.out.println(root.value); // Print the root value
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
