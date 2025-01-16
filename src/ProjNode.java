public class ProjNode<T> {
    T data; // data stored in node
    ProjNode<T> next; // pointer to next node
    
    // Constructs node with specified data
    public ProjNode(T data) {
        this.data = data;
        this.next = null;
    }
}