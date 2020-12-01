public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        String input = "9 17 6 3 8 16 20 21 19";
        for (String item: input.split(" ")) {
            tree.add(Integer.parseInt(item));
        }
        tree.print();
        System.out.print("Последовательность обработки дерева при прямом обходе: ");
        straightProcessing(tree.head);
        System.out.print("\nПоследовательность обработки дерева при симметричном обходе: ");
        symmetricalProcessing(tree.head);
        System.out.print("\nПоследовательность обработки дерева при обратном обходе: ");
        reverseProcessing(tree.head);
    }
    static void straightProcessing(BinaryTree.Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            straightProcessing(node.left);
            straightProcessing(node.right);
        }
    }
    static void symmetricalProcessing(BinaryTree.Node node) {
        if (node != null) {
            symmetricalProcessing(node.left);
            System.out.print(node.value + " ");
            symmetricalProcessing(node.right);
        }
    }
    static void reverseProcessing(BinaryTree.Node node) {
        if (node != null) {
            symmetricalProcessing(node.left);
            symmetricalProcessing(node.right);
            System.out.print(node.value + " ");
        }
    }
}
