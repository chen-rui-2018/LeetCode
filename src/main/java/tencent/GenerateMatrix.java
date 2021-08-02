package tencent;

/**
 * @author： chenr
 * @date： Created on 2021/3/5 10:26
 * @version： v1.0
 * @modified By:
 */
public class GenerateMatrix {
    public static void main(String[] args) {
     int[][] res =    new GenerateMatrix().generateMatrix(3);
        System.out.println();
    }
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int l = 0,  r = n-1, t = 0, b = n-1;
        int num = 1, tar = n*n;
        while (num <= tar ){
            for (int i = l; i <= r; i++) { res[t][i] = num;   num++;  } t++;
            for (int i = t; i <= b; i++) { res[i][r] = num;   num++;  } r--;
            for (int i = r; i >= l; i--) { res[b][i] = num;   num++;  } b--;
            for (int i = b; i >= t; i--) { res[i][l] = num;   num++;  } l++;

        }
        return res;
    }
}

