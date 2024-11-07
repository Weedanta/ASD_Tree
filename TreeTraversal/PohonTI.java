import java.util.*;

public class PohonTI {

    static class TreeNode {
        String id;
        int points;
        List<TreeNode> children;

        TreeNode(String id) {
            this.id = id;
            this.points = 0;
            this.children = new ArrayList<>();
        }
    }

    static List<TreeNode> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rootId = sc.nextLine().trim();
        TreeNode root = new TreeNode(rootId);
        nodeList.add(root);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String[] parts = sc.nextLine().split(" ");
            String parentId = parts[0];
            String childId = parts[1];


            TreeNode parentNode = findOrCreateNode(parentId);

            TreeNode childNode = new TreeNode(childId);
            nodeList.add(childNode);

            parentNode.children.add(childNode);

            parentNode.points += 2;

            TreeNode current = parentNode;
            while (current != null && !current.id.equals(rootId)) {
                current = findParent(current);
                if (current != null) {
                    current.points += 1;
                }
            }
        }

        preorderTraversal(root);
    }

    private static TreeNode findOrCreateNode(String id) {
        for (TreeNode node : nodeList) {
            if (node.id.equals(id)) {
                return node;
            }
        }
        TreeNode newNode = new TreeNode(id);
        nodeList.add(newNode);
        return newNode;
    }

    private static TreeNode findParent(TreeNode child) {
        for (TreeNode node : nodeList) {
            if (node.children.contains(child)) {
                return node;
            }
        }
        return null;
    }

    private static void preorderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.println(node.id + " " + node.points);

        for (TreeNode child : node.children) {
            preorderTraversal(child);
        }
    }
}
