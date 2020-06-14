package linked.list;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node head = node1;
        head = Operators.insertBeforeHead(head, node2);
        head = Operators.insertBeforeHead(head, node3);
        head = Operators.insertBeforeHead(head, node4);
        head = Operators.insertBeforeHead(head, node5);
        //head = Operators.insertBeforeHead(head, node6);
        //head = Operators.deleteNNode(head,5);
        Operators.printList(head);
        Operators.printList(Operators.findMiddleNode(head));
        System.exit(0);
        Operators.printList(head);
        head = Operators.reverse(head);
        Operators.printList(head);
        Node head2 = node2;
        head2 = Operators.insertBeforeHead(head2,node4);
        head2 = Operators.insertBeforeHead(head2,node6);
        head2 = Operators.reverse(head2);
        Operators.printList(head2);
        //node6.next = node6  ;
        System.out.println(Operators.cycleList(head));
        Operators.printList(Operators.cycleListEnterNode(head));
        Operators.printList(Operators.mergeTwoSortList(head,head2));

        //Operators.printList(head);
        // head = Operators.deleteIndexNode(head,1);
        //head = Operators.deleteIndexNode(head,0);
       // head = Operators.deleteIndexNode(head,-1);
       // head = Operators.deleteIndexNode(head,100);
        //Operators.printList(head);
//        head = Operators.deleteNode(head,node6);
//        head = Operators.deleteNode(head,node1);
//        head = Operators.deleteNode(head,node5);
//        head = Operators.deleteNode(head,node3);
//        head = Operators.deleteNode(head,node2);
//        head = Operators.deleteNode(head,node4);
//        head = Operators.deleteNode(head,node4);
       // Operators.printList(head);
    }
}
