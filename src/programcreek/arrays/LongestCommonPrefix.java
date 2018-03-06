package programcreek.arrays;

/**
 * Created by deepakkole on 2/15/18.
 */
public class LongestCommonPrefix {

    private int findMinLength(String[] strings){
        int min = Integer.MAX_VALUE;
        for (String str: strings){
            if(str.length() < min){
                min = str.length();
            }
        }
        return min;
    }
    private boolean checkPrefix(String strings[], String str, int start, int end){
        for(int i = 0 ; i < strings.length; i++){
            for(int j = start; j <= end; j++){
                if(strings[i].charAt(j) != str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public String longestCommonPrefix(String strings[]){
        int n = strings.length;
        if(strings == null || strings.length <= 0){
            return null;
        }

        int minLength = findMinLength(strings);

        String prefix = new String();
        int low =0;
        int high = minLength;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(checkPrefix(strings, strings[0], low, mid)){
                prefix = prefix + strings[0].substring(low, (mid - low) +1);
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return prefix;
    }

    public String lonCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        //find the shortest String
        int shortest = 0;
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int curLen = strs[i].length();
            if (curLen < len) {
                len = curLen;
                shortest = i;
            }
        }
        //find the longest common prefix
        String sub = strs[shortest];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                sub = sub.substring(0, sub.length()-1);
            }
        }
        return sub;
    }
    public static void main(String[] args) {

        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        String[] strings = new String[]{"geeksforgeeks", "geeks", "geek", "geezer"};
        //System.out.println(commonPrefix.longestCommonPrefix(strings));
        System.out.println(commonPrefix.lonCommonPrefix(strings));
    }
}
