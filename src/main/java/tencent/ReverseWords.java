package tencent;



/**
 * @author： chenr
 * @date： Created on 2021/1/19 17:31
 * @version： v1.0
 * @modified By:
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s ="Let's take LeetCode contest";
        System.out.println( new ReverseWords().reverseWords(s));
    }
    public String reverseWords1(String s) {
        String [] arrs = s.split(" ");
        for (int i = 0; i < arrs.length; i++) {
            char[] arrc = arrs[i].toCharArray();
            int j = arrc.length-1;
            for (int k = 0; k < j; k++) {
                char temp = arrc[k];
                arrc[k] = arrc[j];
                arrc[j--] = temp;
            }
            arrs[i] =  new String(arrc);
        }
        String result = "";
        for (int i = 0; i < arrs.length; i++) {

            if( i < arrs.length-1){
                result += arrs[i] + " ";
            }else{
                result += arrs[i];
            }
        }

        return result;
    }
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        char reg = ' ';
        int len = s.length();
        int i = 0;
        while( i < len){
           int start = i;
            while (i < len  && s.charAt(i) != reg) {
                i++;
            }
            for (int j = start; j < i; j++) {
                res.append(s.charAt(start+i-1-j));
            }
            while ( i < len && s.charAt(i) == reg){
                res.append(reg);
                i++;
            }
        }
        return res.toString();

    }
}
