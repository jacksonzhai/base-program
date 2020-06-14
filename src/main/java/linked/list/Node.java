package linked.list;

public class Node {
    public Node next = null;
    public int data = 0;
    public Node(int data,Node next){
        this.data= data;
        this.next = next;
    }
    public  Node(int data){
        this.data= data;
        this.next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+this.data;
    }
}
