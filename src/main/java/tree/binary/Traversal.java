package tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public static List<Integer> pre(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        doPre(root, result);
        return result;

    }
    public static List<Integer> loopPre(Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while (!stack.empty()){
            Node temp = stack.pop();

            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

            result.add(temp.val);
        }

        return result;

    }
    public static void doPre(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            doPre(root.left, list);
            doPre(root.right, list);
        }
    }
    public static List<Integer> mid(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        doMid(root, result);
        return result;

    }
    public static List<Integer> loopMid(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null) {
            return result;
        }
        Node temp = root;
        while (temp!=null){
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.empty()){
            Node cu = stack.pop();
            result.add(cu.val);
            Node right = cu.right;
            while (right!=null){
                stack.push(right);
                right =right.left;
            }

        }

        return result;
    }


    public static void doMid(Node root, List<Integer> list) {
        if (root != null) {
            doMid(root.left, list);
            list.add(root.val);
            doMid(root.right, list);
        }
    }
    public static List<Integer> post(Node root){
        List<Integer> result = new ArrayList<Integer>();
        doPost(root, result);
        return result;
    }
    public static void doPost(Node root,List<Integer> list){
        if(root!=null){
            doPost(root.left,list);
            doPost(root.right,list);
            list.add(root.val);
        }
    }
    public static List<Integer> loopPost(Node root,List<Integer> list){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while (!stack.empty()){
            Node temp = stack.pop();
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }

            result.add(temp.val);
        }
        Collections.reverse(result);
        return result;

    }
    public static List<Integer> loopPost2(Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null){
            return result;
        }
        Node temp = root;
        while (temp!=null){
            stack.push(temp);
            temp = temp.left;
        }
        while (!stack.empty()){
            Node cu = stack.pop();
            if(!stack.empty()&&cu.equals(stack.peek())){
                result.add(cu.val);
                stack.pop();
            }else {
                Node cuRight = cu.right;
                if(cuRight!=null){
                    stack.push(cu);
                    stack.push(cu);
                }else {
                    result.add(cu.val);
                }
                while (cuRight!=null){
                    stack.push(cuRight);
                    cuRight = cuRight.left;

                }
            }


        }
        return result;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(loopPost2(node1));
    }


}
