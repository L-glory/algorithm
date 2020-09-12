package com.glory.algorithm.commons;

/**
 * 字典树节点
 *
 * @author Glory
 * @create 2020-08-19 21:47
 **/
public class TrieNode {
    private char val;
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode(char val) {
        this.val = val;
        this.children = new TrieNode[52];
        this.isWord = false;
    }
}
