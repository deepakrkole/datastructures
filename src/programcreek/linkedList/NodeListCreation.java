package programcreek.linkedList;

/**
 * Created by deepakkole on 1/22/18.
 */
public class NodeListCreation {

    NodeStr head = null;
    int count = 0;
    public void createNode(){
        if(head == null){
            head = new NodeStr(10, null);
            count = 1;
        }
    }

    public void insertNodeFromStart(int val){
        if(head == null){
            createNode();
        }

        NodeStr newNode = new NodeStr(val, null);
        newNode.setNext(head);
        count++;
        head = newNode;
        displayList();
    }

    public void insertNodeFromEnd(int val){
        if(head == null){
            createNode();
        }

        NodeStr newNode = new NodeStr(val, null);
        NodeStr p = head;
        while(p.getNext() != null){
            p = p.getNext();
        }

        p.setNext(newNode);
        count++;
        displayList();
    }

    public void insertNodeInMiddle(int val, int pos){
        if(pos > count){
            System.out.println("Cannnot insert at specified position");
            return;
        }

        if(head == null){
            createNode();
        }

        NodeStr p = head;
        NodeStr q =p;
        int counter = 1;
        while(p != null && pos != counter){
            q = p;
            p = p.getNext();
            counter++;
        }

        NodeStr newNode= new NodeStr(val, null);
        newNode.setNext(p.getNext());
        q.setNext(newNode);
        count++;
        displayList();
    }

    public void deleteNodeFromStart(){
        if(head == null){
            System.out.println("List is empty!!!");
            return;
        }

        NodeStr p = head;
        head = head.getNext();
        p.setNext(null);
        count--;
    }

    public void deleteNodeFromEnd(){
        if(head == null){
            System.out.println("List is empty!!!");
            return;
        }

        NodeStr p = head;
        NodeStr q = p;
        while(p.getNext() != null){
            q = p;
            p = p.getNext();
        }
        q.setNext(null);
        count--;
    }

    public void deletefromMiddle(int pos){
        if(head == null || pos > count){
            System.out.println("List is empty OR position to delete is inaccurate!!!");
            return;
        }
        int counter = 1;
        NodeStr temp = head;
        NodeStr temp1= temp;
        while(temp!=null && pos != counter ){
            temp1=temp;
            temp = temp.getNext();
            counter++;
        }

        temp1.setNext(temp.getNext());
        count--;
    }

    public void displayList(){
        NodeStr p = head;
        if(head == null){
            System.out.println("Empty List!!!");
            return;
        }
        while(p != null){
            System.out.print(p.getValue() + "-->");
            p = p.getNext();
        }

        System.out.println("NULL");
    }

    public boolean searchNode(int searchNode){
        if(head == null) {
            System.out.println("Empty List");
            return false;
        }

        NodeStr p = head;
        while(p != null){
            if(p.getValue() == searchNode){
                System.out.println("Value found");
                return true;
            }
            p = p.getNext();
        }
        System.out.println("Value Not found");
        return false;
    }

    public boolean searchNodeRecur(int searchNode, NodeStr temp){
        if(temp == null){
            return false;
        }

        if(searchNode == temp.getValue()){
            System.out.println("Value found!!!");
            return true;
        }

        boolean flag = searchNodeRecur(searchNode, temp.getNext());
        return flag;
    }

    public void reverseList(){
        if(head == null){
            System.out.println("Empty List!!!!");
            return;
        }

        NodeStr current = head;
        NodeStr prev = null;
        NodeStr next = null;

        while(current !=null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void reverseListRecur(NodeStr current, NodeStr prev){

        if(current.getNext() == null){
            head = current;
            current.setNext(prev);
            return;
        }

        NodeStr next = current.getNext();

        current.setNext(prev);

        reverseListRecur(next, current);
    }


    public static void main(String[] args) {

        NodeListCreation node = new NodeListCreation();
        node.displayList();
        node.insertNodeFromStart(20);
        node.insertNodeFromStart(30);
        node.insertNodeFromStart(40);
        node.insertNodeFromStart(50);
        node.displayList();
        node.insertNodeFromEnd(110);
        node.insertNodeFromEnd(120);
        node.insertNodeFromEnd(130);
        node.displayList();
        node.insertNodeInMiddle(35, 3);
        node.insertNodeInMiddle(45, 4);
        node.insertNodeInMiddle(55, 5);
        node.displayList();

        //DELETE Records:

//        node.deleteNodeFromStart();
//        node.deleteNodeFromStart();
//        node.deleteNodeFromStart();
//        node.displayList();
//        node.deleteNodeFromEnd();
//        node.deleteNodeFromEnd();
//        node.deleteNodeFromEnd();
        node.displayList();

//Search Node
//        System.out.println(node.searchNode(130));
//        System.out.println(node.searchNodeRecur(130, node.head));

//Reverse List

        node.reverseList();
        node.displayList();
        node.reverseListRecur(node.head, null);
        node.displayList();
    }
}
