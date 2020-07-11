package linked.list;

import java.security.PublicKey;
import java.util.Stack;

public class Operators {
    //head has data, and node is single node
    public static Node insertBeforeHead(Node head, Node node) {
        if (null == node || null != node.next) {
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    public static void printList(Node head) {
        if (null == head) {
            System.out.println("null");
        } else {
            Node p = head;
            while (p != null) {
                System.out.print(p.data + "=>");
                p = p.next;
            }
            System.out.println("null");

        }
    }

    //删除第一匹配上的node
    public static Node deleteNode(Node head, Node node) {
        if (null == node || null == head) {
            return head;
        }
        Node pre = head;
        Node cu = head.next;

        if (pre.data == node.data) {
            return cu;
        }
        while (cu != null) {
            if (cu.data == node.data) {
                pre.next = cu.next;
                cu.next = null;
                break;
            }
            cu = cu.next;
            pre = pre.next;
        }
        return head;
    }

    public static Node reverse(Node head) {
        if (null == head || null == head.next) {
            return head;
        }
        Node cu = head.next;
        Node root = head;
        Node pre = head;
        while (cu != null) {
            pre.next = cu.next;
            cu.next = root;
            root = cu;
            cu = pre.next;
        }
        return root;
    }
    //index begin 0 ; 0 is head ....

    public static Node deleteIndexNode(Node head, int index) {
        if (index < 0 || null == head) {
            return head;
        }
        Node pre = head;
        Node cu = head.next;
        if (index == 0) {
            return cu;
        }
        index--;
        while (cu != null) {
            if (index == 0) {
                pre.next = cu.next;
                cu.next = null;
                break;
            }
            cu = cu.next;
            pre = pre.next;
            index--;
        }
        if(index>=0){
            //do something
        }
        return head;
    }

    public static boolean  cycleList(Node head){
        if(null==head || null == head.next) {
            return false;
        }
        if(head.next == head){
            return true;
        }
        Node slow = head;
        Node fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while(null != fast&& null!=fast.next){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public static Node cycleListEnterNode(Node head){
        if(!cycleList(head)){
            return null;
        }

        if(head.next == head){
            return new Node(head.data);
        }

        Node slow = head;
        Node fast = head;
        Node slow2 = head;
        slow = slow.next;
        fast = fast.next.next;
        while(null!= fast && null!=fast.next){
            if(slow == fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow!=slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        return new Node(slow.data);
    }
    public static Node mergeTwoSortList(Node head1,Node head2){
        if(null == head1){
            return head2;
        }
        if(null == head2){
            return head1;
        }
        Node root = null;
        Node tail = null;
        while(head1!=null&&head2!=null){
            if(head1.data<head2.data){
                if(root==null&& tail ==null){
                    root = head1;
                    tail = head1;
                }else{
                    tail.next = head1;
                    tail = head1;
                }
                head1 = head1.next;
            }else{
                if(root==null&& tail ==null){
                    root = head2;
                    tail = head2;
                }else{
                    tail.next = head2;
                    tail = head2;
                }
                head2 = head2.next;
            }

        }
        while(head1!=null){
            tail.next = head1;
            tail = head1;
            head1 = head1.next;
        }
        while(head2!= null){
            tail.next = head2;
            tail = head2;
            head2= head2.next;
        }

        return root;
    }

    public static Node deleteNNode(Node head,int index){
        if(index<1){
            return head;
        }
        if(null == head){
            return head;
        }
        int nodeCount = 0;
        Node cu = head;
        while(cu!=null){
            cu = cu.next;
            nodeCount++;
        }
        if(index>nodeCount){
            return head;
        }
        int num = nodeCount-index +1;
        if(num == 1){
            return head.next;
        }
        Node pre = head;
        Node current = head.next;
        while(num>2){
            current = current.next;
            pre = pre.next;
            num--;
        }
        //do delete
        pre.next = current.next;
        current.next = null;
        return head;




    }
   public static Node findMiddleNode(Node head){
        //odd return the middle
       //even return the middle right node  e.g.: 1->2->3->4 return 3
       if(null == head|| null == head.next){
           return head;
       }
       Node slow = head;
       Node fast = head;
       while(null!= fast && null != fast.next){
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;

   }
   public static void printListFromTail(Node head){
        if(head!=null) {
            printListFromTail(head.next);
            System.out.print("=>"+head.data);
        }
   }
    public static void printListFromTailWithStack(Node head){
        if(head ==null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.empty()){
            System.out.print(stack.pop().data+"=>");
        }
    }




}
