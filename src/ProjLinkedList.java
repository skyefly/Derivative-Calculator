public class ProjLinkedList<T> {
    private ProjNode<T> head;
    
    public ProjLinkedList() {
        head = null;
    }
    
    public void add(T data) {
        ProjNode<T> newNode = new ProjNode<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    public T getAt(int index) {
        ProjNode<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return (current != null) ? current.data : null;
    }
}