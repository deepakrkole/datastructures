package programcreek.trees;

import java.util.*;

/**
 * Created by deepakkole on 2/24/18.
 */
public class BTreeOperations {

    public void inorderRecPrint(BTree root){
        if(root == null){
            return;
        }
        inorderRecPrint(root.getLeft());
        System.out.print(root.getVal() + " ");
        inorderRecPrint(root.getRight());
    }

    public void preOrderRecPrint(BTree root){
        if(root == null){
            return;
        }

        System.out.print(root.getVal() + " ");
        preOrderRecPrint(root.getLeft());
        preOrderRecPrint(root.getRight());
    }

    public void postOrderRecPrint(BTree root){
        if(root == null){
            return;
        }

        postOrderRecPrint(root.getLeft());
        postOrderRecPrint(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    public void inorderPrint(BTree root){
        Stack<BTree> current = new Stack<>();
        while(true){
            while(root!=null){
                current.add(root);
                root = root.getLeft();
            }

            if(current.isEmpty()){
                return;
            }

            BTree pop = current.pop();
            System.out.print( pop.getVal() + " ");
            root = pop.getRight();
        }
    }

    public void preOrderPrint(BTree root){
        Stack<BTree> s = new Stack<BTree>();
        while (true) {

            while (root != null) {
                System.out.print(root.getVal() + " ");
                s.push(root);
                root = root.getLeft();
            }

            if (s.isEmpty()) {
                return;
            }

            root = s.pop();
            root = root.getRight();
        }
    }

    public void postOrderPrint(BTree root){
        Stack<BTree> stack1 = new Stack<>();
        Stack<BTree> stack2 = new Stack<>();

        if(root != null){
            stack1.push(root);

            while(!stack1.isEmpty()){
                BTree current = stack1.pop();
                stack2.push(current);
                if(current.getLeft() != null){
                    stack1.push(current.getLeft());
                }

                if(current.getRight() != null){
                    stack1.push(current.getRight());
                }

            }

            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().getVal() + " ");
            }
        }
    }

    public void levelOrderPrint(BTree root){
        Queue q = new LinkedList();
        int levelNodes =0;
        if(root==null) return;
        q.add(root);
        while(!q.isEmpty()){
            levelNodes = q.size();
            while(levelNodes>0){
                BTree n = (BTree)q.remove();
                System.out.print(" " + n.getVal());
                if(n.getLeft()!=null) q.add(n.getLeft());
                if(n.getRight()!=null) q.add(n.getRight());
                levelNodes--;
            }
            System.out.println("");
        }
    }

    public void printPaths(BTree root, int[] paths, int counter){
        if(root == null){
            return;
        }
        paths[counter++] = root.getVal();
        if(root.getLeft() == null && (root.getRight() == null)){
            for (int i=0;i< counter; i ++) {
                System.out.print(paths[i] + " ");
            }
            System.out.println();
            }else{
                printPaths(root.getLeft(), paths, counter);
                printPaths(root.getRight(), paths, counter);
        }
    }
    int maxSumSoFar = 0;
    public int maxSumPath(BTree root){
        if(root == null){
            return 0;
        }
        int left = maxSumPath(root.getLeft());
        int right = maxSumPath(root.getRight());

        int currentSum = 0;
        if(left < 0 && right < 0){
            currentSum = root.getVal();
        }else{
            currentSum = Math.max(root.getVal() + left + right, Math.max(left, right));
        }

        if(currentSum > maxSumSoFar){
            maxSumSoFar = currentSum;
        }

        return Math.max(left, right);
    }

    public void printAllTraversals(BTree root){
        System.out.println("PreOrder:");
        preOrderPrint(root);
        System.out.println();
        preOrderRecPrint(root);
        System.out.println();
        System.out.println("PostOrder:");
        postOrderPrint(root);
        System.out.println();
        postOrderRecPrint(root);
        System.out.println();
        System.out.println("InOrder:");
        inorderPrint(root);
        System.out.println();
        inorderRecPrint(root);
        System.out.println();
        System.out.println("LevelOrder:");
        levelOrderPrint(root);
        System.out.println();
    }

    private BTree createTree(){
        BTree root = new BTree(1);
        root.setLeft(new BTree(2));
        root.setRight(new BTree(3));
        root.getLeft().setLeft(new BTree(4));
        root.getLeft().setRight(new BTree(5));
        root.getRight().setLeft(new BTree(6));
        root.getRight().setRight(new BTree(7));
        return root;
    }

    public static void main(String[] args) {
        BTreeOperations i = new BTreeOperations();
        BTree root = i.createTree();
        i.printAllTraversals(root);
        System.out.println("PrintPaths:");
        int[] paths = new int[100];
        int counter = 0;
        i.printPaths(root, paths,counter);
        System.out.println();
    }
}
