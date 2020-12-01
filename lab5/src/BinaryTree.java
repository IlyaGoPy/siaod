public class BinaryTree {
    Node head = null;

    public void add(int value) {
        if (head == null) {
            head = new Node(value, null, null);
        } else {
            Node currentNode = head;
            boolean found = false;
            while (!found) {
                if (currentNode.value > value) {
                    if (currentNode.left == null) {
                        found = true;
                        currentNode.left = new Node(value, null, null);
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        found = true;
                        currentNode.right = new Node(value, null, null);
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void delete(int value) {
        Node delNode = find(value);
        Node parent = findParent(delNode.value);
        if (delNode.left == null && delNode.right != null) {
            if (parent.left == delNode) {
                parent.left = delNode.right;
            } else {
                parent.right = delNode.right;
            }
        } else if (delNode.left != null && delNode.right == null) {
            if (parent.left == delNode) {
                parent.left = delNode.left;
            } else {
                parent.right = delNode.left;
            }
        } else if (delNode.left == null && delNode.right == null) {
            if (parent.left == delNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            Node temp = delNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            if (temp.right == null) {
                temp.right = delNode.right;
            }

            temp.left = delNode.left;
            findParent(temp.value).left = null;
            if (parent.left == delNode) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
        }
    }

    public Node find(int value) {
        return findInSubtree(head, value);
    }

    private Node findInSubtree(Node node, int value) {
        if (node != null && node.value != value) {
            if (value < node.value)
                return findInSubtree(node.left, value);
            else
                return findInSubtree(node.right, value);
        } else {
            return node;
        }
    }

    public Node findParent(int value) {
        return findParentInSubtree(head, value);
    }

    private Node findParentInSubtree(Node node, int value) {
        while (true) {
            if (node.value > value) {
                if (node.left.value == value) {
                    return node;
                }
                node = node.left;
            } else {
                if (node.right.value == value) {
                    return node;
                }
                node = node.right;
            }
        }
    }

    public void print() {
        print2(head, 0);
    }

    private void print2(Node node, int r) {
        if (node != null) {
            print2(node.right,r + 1);
            for (int i = 1; i <= r; i++)
                System.out.print("   ");
            System.out.println(node.value);
            print2(node.left,r + 1);
        }
    }

    static class Node {
        Node left;
        Node right;
        int value;

        Node(int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Left child: " + ((this.left == null) ? "null" : this.left.value) +
                    ", Right child: " + ((this.right == null) ? "null" : this.right.value);
        }
    }
}
