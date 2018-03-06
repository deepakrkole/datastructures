package programcreek.trees;

/**
 * Created by deepakkole on 2/24/18.
 */
public class BTree {

    private BTree left;
    private BTree right;
    private int val;
    public BTree(int val){
        this.left = null;
        this.right=null;
        this.val=val;
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        this.left = left;
    }

    public BTree getRight() {
        return right;
    }

    public void setRight(BTree right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
