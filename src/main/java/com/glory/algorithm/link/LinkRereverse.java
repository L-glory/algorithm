package com.glory.algorithm.link;

import com.glory.algorithm.commons.Helper;
import com.glory.algorithm.commons.Node;

/**
 * 链表翻转
 *
 * @author Glory
 * @create 2020-08-25 22:41
 **/
public class LinkRereverse {


    public static Node reverse(Node root) {
        if (root == null || root.next == null) return root;

        Node pred = root;
        Node current = root.next;
        root.next = null;
        while (current != null) {
            Node tmp = current.next;
            current.next = pred;
            pred = current;
            current = tmp;
        }

        return pred;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        Node node = root;
        for (int i = 1; i < 10; i++) {
            node.next = new Node(i);
            node = node.next;
        }
        Helper.print(root);
        Node reverseNode = reverse(root);
        Helper.print(reverseNode);
    }
}
