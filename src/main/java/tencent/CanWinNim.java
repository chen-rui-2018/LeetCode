package tencent;

/**
 * @author： chenr
 * @date： Created on 2021/1/20 11:39
 * @version： v1.0
 * @modified By:
 */
public class CanWinNim {
    public static void main(String[] args) {
        System.out.println( new CanWinNim().canWinNim(7));
    }
    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
