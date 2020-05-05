package com.zerasi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Md5Utils {

    public static void main(String[] args) {
        System.out.println(Encrypt("lisi"));
    }

    public static String Encrypt(String str){
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            byte[] s=md.digest(str.getBytes());
            String ss="";
            String result="";
            for(int i=0;i<s.length;i++){
                ss=Integer.toHexString(s[i] & 0xff);
                if(ss.length()==1){
                    result+="0"+ss;
                }else{
                    result+=ss;
                }
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
