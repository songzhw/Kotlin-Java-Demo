package ca.six.demo.practices;

public class BST_Search {

    public boolean isExisting(Node root, int value) {
        if (root.data == value) {
            return true;
        } else if (root.right != null && value > root.data) {
            return isExisting(root.right, value);
        } else if (root.left != null && value < root.data) {
            return isExisting(root.left, value);
        } else {
            return false;
        }
    }
}

class Node {
    int data;
    Node left, right;
}
