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

    static Map<String, TreeNode> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rootId = sc.nextLine().trim();
        TreeNode root = new TreeNode(rootId);
        nodeMap.put(rootId, root);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            String[] parts = sc.nextLine().split(" ");
            String parentId = parts[0];
            String childId = parts[1];

            TreeNode parentNode = nodeMap.getOrDefault(parentId, new TreeNode(parentId));
            nodeMap.put(parentId, parentNode);


            TreeNode childNode = new TreeNode(childId);
            nodeMap.put(childId, childNode);


            parentNode.children.add(childNode);
            parentNode.points += 2;

            TreeNode current = parentNode;
            while (current != null && !current.id.equals(rootId)) {
                for (Map.Entry<String, TreeNode> entry : nodeMap.entrySet()) {
                    if (entry.getValue().children.contains(current)) {
                        entry.getValue().points += 1;
                        current = entry.getValue();
                        break;
                    }
                }
            }
        }

        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.println(node.id + " " + node.points);

        for (TreeNode child : node.children) {
            preorderTraversal(child);
        }
    }
}
