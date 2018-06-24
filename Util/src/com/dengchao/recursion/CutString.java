package com.dengchao.recursion;

import java.io.UnsupportedEncodingException;

/*定义一个方法，按照最大的字节数来截取子串。
 例如，对“ab你好”，如果取三个字节，那么子串就是ab与“你”字的一半，
 另一半就要舍弃；如果取四个字节，那么子串就是“ab你”，取五个字节，还是“ab你”。*/
public class CutString {

    public static void main(String[] args) throws Exception {
        String str = "你a好";
        int len = str.getBytes("utf-8").length;
        for (int x = 1; x <= len; x++) {
            System.out.println("截取" + x + "个字符 ： " + cutStringByUTF8Byte(str, x));
        }
    }

    public static String cutStringByUTF8Byte(String str, int x) {
        try {
            byte[] buf = str.getBytes("utf-8");
            int count = 0;

            for (int i = x - 1; i >= 0; i--) {
                if (buf[i] < 0) {
                    count++;
                } else {
                    break;
                }
            }
            if (count % 3 == 0) {
                return new String(buf, 0, x, "utf-8");
            } else if (count % 3 == 1) {
                return new String(buf, 0, x - 1, "utf-8");
            } else {
                return new String(buf, 0, x - 2, "utf-8");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;

    }

}
