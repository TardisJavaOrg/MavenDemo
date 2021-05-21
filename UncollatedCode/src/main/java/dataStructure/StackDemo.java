package dataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class StackDemo {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1); // 压入栈
        stack.offer(2); //
        Integer i = stack.pop(); // 弹出栈顶元素
        Integer j = stack.peek(); // 取栈顶元素，不弹出
        Integer k = stack.poll(); // 弹出栈顶元素
        boolean isEmpty = stack.isEmpty(); // 判断是否为空
    }
}
