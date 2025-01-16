public class ProjLinkedList<T> {
    private ProjNode<T> head; // head of linked list
    
    // Constructs empty linked list
    public ProjLinkedList() {
        head = null;
    }
    
    // Adds new element to beginning of linked list
    public void add(T data) {
        ProjNode<T> newNode = new ProjNode<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    // Gets element at specific index
    public T getAt(int index) {
        ProjNode<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return (current != null) ? current.data : null;
    }
}