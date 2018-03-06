package programcreek.linkedList;

/**
 * Created by deepakkole on 1/22/18.
 */
public class NodeStr {

    private int value;
    private NodeStr next;

    NodeStr(){
        this.value = 0;
        this.next = null;
    }
    public NodeStr(int value, NodeStr head){
        this.value = value;
        this.next = head;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeStr getNext() {
        return next;
    }

    public void setNext(NodeStr head) {
        this.next = head;
    }
}
