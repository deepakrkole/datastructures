package programcreek.matrices;

import java.util.Stack;

/**
 * Created by deepakkole on 2/17/18.
 */
public class FloodFill {

    private static void floodFill(int[][] input, int row, int col, int preValue, int color){
        if(row > input.length || col > input[0].length || row < 0 || col < 0 ){
            return;
        }

        if(input[row][col] != preValue){
            return;
        }

        input[row][col] = color;
        floodFill(input, row+1, col, preValue, color);
        floodFill(input, row-1, col, preValue, color);
        floodFill(input, row, col-1, preValue, color);
        floodFill(input, row, col+1, preValue, color);

    }
    public static int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;

        for(int i=0; i<=s.length()-1; i++){
            char c = s.charAt(i);
            if(c=='(' || c =='{' || c == '['){
                int[] a = {i,0};
                stack.push(a);
            }else{
                if(stack.empty()||stack.peek()[1]==1){
                    int[] a = {i,1};
                    stack.push(a);
                }else{
                    stack.pop();
                    int currentLen=0;
                    if(stack.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int input[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 0, 0},
//            {1, 0, 0, 1, 1, 0, 1, 1},
//            {1, 2, 2, 2, 2, 0, 1, 0},
//            {1, 1, 1, 2, 2, 0, 1, 0},
//            {1, 1, 1, 2, 2, 2, 2, 0},
//            {1, 1, 1, 1, 1, 2, 1, 1},
//            {1, 1, 1, 1, 1, 2, 2, 1},
//        };
//        int x = 4, y = 4, newC = 3;
//        floodFill(input,x, y, input[x][y], newC);
//
//        for (int i =0; i < input.length;i++){
//            System.out.print( "{");
//            for (int j =0; j < input[0].length;j++){
//                System.out.print( input[i][j] + " ");
//            }
//            System.out.println( "},");
//        }

        System.out.println(longestValidParentheses("[(){}(]"));
    }
}
