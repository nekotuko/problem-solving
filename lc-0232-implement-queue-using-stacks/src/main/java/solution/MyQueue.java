package solution;

import java.util.Stack;

public class MyQueue {

    // Using 'mStack1' for push, 'mStack2' for pop.
    // Only transfer elements from 1 to 2 when 2 is empty.
    // No need to transfer back to 1 after each pop.
    // As long as we transfer from 1 to 2 only when 2 is empty we will have a
    // working queue.

    private Stack<Integer> mStack1; // Use this to store pushes
    private Stack<Integer> mStack2; // Use this to store pops
    private int front; // Saves time on peek

    public MyQueue() {
        mStack1 = new Stack<>();
        mStack2 = new Stack<>();
    }

    public void push(int x) {
        if (mStack1.isEmpty())
            front = x;
        mStack1.push(x);
    }

    public int pop() {
        if (mStack2.isEmpty()) {
            while (!mStack1.isEmpty()) {
                mStack2.push(mStack1.pop());
            }
        }
        return mStack2.pop();
    }

    public int peek() {
        if (!mStack2.isEmpty()) {
            return mStack2.peek();
        }
        return front;
    }

    public boolean empty() {
        return mStack1.isEmpty() && mStack2.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("lc-0232-implement-queue-using-stacks");
    }
}
