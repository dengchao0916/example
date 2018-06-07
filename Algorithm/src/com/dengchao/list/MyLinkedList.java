package com.dengchao.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

//LinkedList实现（链表）
public class MyLinkedList<T> implements Iterable<T> {
    private int theSize;
    // 检测集合中的变化，自从构造以来，对链表所做改变的次数
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    // 一个节点包含的数据，以及到前一个节点的链和到下一个节点的链
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        clear();
    }

    // 创建并连接头节点和尾节点，设置大小为0
    public void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object add(T x) {
        add(size(), x);
        return x;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx), x);
    }

    public Object get(int idx) {
        return getNode(idx).data;
    }

    public Object set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        Object oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public Object remove(int idx) {
        return remove(getNode(idx));
    }

    // 插入一个p引用的节点和p.prev之间
    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private Object remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    // 如果索引表示该表前半部分的一个节点，那么以向后的方向遍历该链表
    // 否则，我们从终端开始向回走
    private Node<T> getNode(int idx) {
        Node<T> p;
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        }
        else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {

            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            // next方法在获得将要返回的节点的值后，向后推进
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
