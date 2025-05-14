package collection.framework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        System.out.println(stack.search(Integer.valueOf(3)));

        //Using LinkedList as stack
        List<Integer> linkedListAsStack = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        linkedListAsStack.addLast(6);
        linkedListAsStack.addLast(7);

        // pop
        System.out.println(linkedListAsStack.removeLast());

        //peek
        System.out.println(linkedListAsStack.getLast());

        //
        System.out.println(linkedListAsStack.indexOf(Integer.valueOf(3)));

    }
}
