package com.algorithm.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyApplication.class)
public class LinkedListTest {

    @Test
    public void testLinkedList() {
        LinkedList linkedList = new LinkedList();
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(1);

        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        boolean palindrome = linkedList.isPalindrome(node);
        System.out.println("palindrome =" + palindrome);
    }
}
