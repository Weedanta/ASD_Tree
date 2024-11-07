import java.util.*;

public class BinaryTreeTraversal {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[] values = new int[n];
        int[] parentIndices = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            parentIndices[i] = sc.nextInt();
        }

        List<Node> nodes = new ArrayList<>();
        for (int value : values) {
            nodes.add(new Node(value));
        }

        Node root = null;
        for (int i = 0; i < n; i++) {
            if (parentIndices[i] == 0) {
                root = nodes.get(i);
            } else {
                int parentIndex = parentIndices[i] - 1; 
                Node parent = nodes.get(parentIndex);
                if (parent.left == null) {
                    parent.left = nodes.get(i);
                } else {
                    parent.right = nodes.get(i);
                }
            }
        }

        List<Integer> preOrderResult = new ArrayList<>();
        preOrderTraversal(root, preOrderResult);
        printList(preOrderResult);

        List<Integer> inOrderResult = new ArrayList<>();
        inOrderTraversal(root, inOrderResult);
        printList(inOrderResult);

        List<Integer> postOrderResult = new ArrayList<>();
        postOrderTraversal(root, postOrderResult);
        printList(postOrderResult);
    }

    private static void preOrderTraversal(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.value); 
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    private static void inOrderTraversal(Node node, List<Integer> result) {
        if (node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.value); 
        inOrderTraversal(node.right, result);
    }

    private static void postOrderTraversal(Node node, List<Integer> result) {
        if (node == null) return;
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.value); 
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
