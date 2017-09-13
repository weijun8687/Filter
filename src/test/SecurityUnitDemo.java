package test;

import util.SecurityUtil;

import java.io.Serializable;

public class SecurityUnitDemo {

    public static void main(String[] args){
        String string = SecurityUtil.base64encode("老王");
        System.out.println(string);

        String string1 = SecurityUtil.md5("123");
        System.out.println(string1);

        String s = SecurityUtil.base64decode("6ICB546L");
        System.out.println(s);
    }
}

