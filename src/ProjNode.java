public class ProjNode<T> {
    T data;
    ProjNode<T> next;
    
    public ProjNode(T data) {
        this.data = data;
        this.next = null;
    }
}