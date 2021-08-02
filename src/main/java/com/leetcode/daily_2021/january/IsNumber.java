package com.leetcode.daily_2021.january;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/1/18 16:36
 * @version： v1.0
 * @modified By:
 */
public class IsNumber {
    public static void main(String[] args) {
        String number= "-3.141592.6";
        System.out.println( new IsNumber().isNumber(number));
    }
    public boolean isNumber(String s) {

        // 表示     缩写   含义   字符
        // blank          空格    ' ';
        // sign      s    正负号  '+','-';
        // digit     d    数字    '0'~'9';
        // dot       .    小数点  '.';
        // e         e    幂符号  'e','E';

        // 状态           描述
        // 0          起始的 blank;
        // 1          e 之前的 sign;
        // 2          dot 之前的 digit;
        // 3          dot 之前的 digit;
        // 4          当dot 前为空时, dot 后的digit;
        // 5          e;
        // 6          e之后的sign;
        // 7          e之后的digit;
        // 8          尾部的 blank;

        Map[] states ={
                //0
                new HashMap(4){{put(' ',0);put('s',1); put('d',2);put('.',4);}},
                //1
                new HashMap(2){{put('d',2);put('.',4);}},
                //2
                new HashMap(4){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
                //3
                new HashMap(3){{put('d',3);put('e',5);put(' ',8);}},
                //4
                new HashMap(1){{put('d',3);}},
                //5
                new HashMap(2){{put('s',6);put('d',7);}},
                //6
                new HashMap(1){{put('d',7);}},
                //7
                new HashMap(2){{put('d',7);put(' ',8);}},
                //8
                new HashMap(1){{put(' ',8);}}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <='9' ) {
                t = 'd';
            }else if (c == '+' || c =='-') {
                t = 's';
            }else if (c == 'e' || c == 'E'){
                t = 'e';
            }else if (c == '.' || c == ' ') {
                t = c;
            }else{
                t = '?';
            }
            if (! states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p== 3 || p == 7 || p == 8;
    }
}
