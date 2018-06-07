package com.dengchao.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

//ArrayList实现（顺序表）
public class MyArrayListInnerClass<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    Object[] theItem;

    public MyArrayListInnerClass() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public Object get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItem[idx];

    }

    public Object set(int idx, Object newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object old = theItem[idx];
        theItem[idx] = newVal;
        return old;

    }

    // 容量空充
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        Object[] old = theItem;
        theItem = new Object[newCapacity];
        // 旧内容拷贝到新数组中
        for (int i = 0; i < size(); i++) {
            theItem[i] = old[i];

        }
    }

    // 添加到末端
    public boolean add(Object x) {
        add(size(), x);
        return true;

    }

    // 将指定元素插入到列表中的指定位置。
    // 将当前位置（如果有的话）和后续元素向右移动（将一个元素添加到它们的索引）。
    public void add(int idx, Object x) {
        if (theItem.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItem[i] = theItem[i - 1];
        }
        theItem[idx] = x;
        theSize++;
    }

    // 删除列表中指定位置的元素。将任何后续元素向左移动（从索引中减去一个元素）。
    public Object remove(int idx) {
        Object removeItem = theItem[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItem[i] = theItem[i + 1];
        }
        theSize--;
        return removeItem;

    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) theItem[current++];
        }

        @Override
        public void remove() {
            MyArrayListInnerClass.this.remove(--current);
        }
    }
}
