package com.algorithm.study;

/**
 * 如何实现LRU 缓存淘汰算法
 * 如何判断一个字符串是回文串
 */
public class LinkedList {
    /**
     * 缓存是一种提高数据读取性能的技术，在硬件设计、软件开发中都有着非常广泛的应用，比如常见的CPU缓存、数据库缓存、浏览器缓存
     * <p>
     * 常见的三种缓存淘汰策略是什么？
     * 先进先出策略FIFO （First In, First Out）
     * 最少使用策略LFU （Least Frequently Used）
     * 最近最少使用策略LRU （Least Recently Used）
     * <p>
     * 链表分为哪几种？
     * 单链表、循环链表、双向链表、双向循环链表
     * <p>
     * 程序实现约瑟夫问题？
     */
    public boolean isPalindrome(Node head) {
        Node prev = null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            Node next = slow.getNext();

            slow.setNext(prev);
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (slow.getValue() != prev.getValue()) {
                return false;
            }
            slow = slow.getNext();
            prev = prev.getNext();
        }
        return true;
    }
}
