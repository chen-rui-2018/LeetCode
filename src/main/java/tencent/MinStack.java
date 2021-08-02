package tencent;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author： chenr
 * @date： Created on 2021/2/19 16:12
 * @version： v1.0
 * @modified By:
 */
public class MinStack {
    public static void main(String[] args) {

    }
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();

    }

    public int top() {
      return   xStack.peek();
    }

    public int getMin() {
        return   minStack.peek();
    }
}
