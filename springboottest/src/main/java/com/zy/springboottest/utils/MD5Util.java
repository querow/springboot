package com.zy.springboottest.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

public class MD5Util {
    private static String salt;

    public static String getMD5(String password,String userName){
        salt = userName;
        if(StringUtils.isBlank(password)){
            return null;
        }
        String base = password+"/"+salt;
        for (int i=0;i<1024;i++){
            base = DigestUtils.md5DigestAsHex(base.getBytes());
        }
        return base;
    }
    public static void main(String[] args){
        System.out.println(MD5Util.getMD5("1111","张三"));
    }

}
