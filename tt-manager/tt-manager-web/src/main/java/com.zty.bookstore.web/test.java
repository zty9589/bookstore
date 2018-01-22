package com.zty.bookstore.web;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class test {

        //@Test
       /* public  void test1(){
        // TODO 多个参数时使用例子
        // String[] temp = new String[]{"0x12341234"};
        // Object[] params = new Object[]{"0x1", "0x2", "0x8888f1f195afa192cfee860698584c030f4c9db1", temp};

        // 密码为123456
       *//* Object[] params = new Object[] {};
        String methodName = "personal_listAccounts";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }*//*

    }*/
    /*public static void main(String[] args){
        Object[] params = new Object[] {};
        String methodName = "personal_listAccounts";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/

   /* //@Test
    public void test2(){
        //设置参数
        Object[] params = new Object[]{};
        //设置要访问的接口名
        String methodName = "admin_datadir";
        //设置头部
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        try{
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010"));
            String address = client.invoke(methodName, params, String.class, headers);
            System.out.println("=====================address: " + address);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }*/

   /* public static void main(String[] args){
        Object[] params = new Object[] {};
        String methodName = "admin_datadir";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/

    /*public static void main(String[] args){
        Object[] params = new Object[] {};
        String methodName = "admin_nodeInfo";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/

    /*public static void main(String[] args){
        Object[] params = new Object[] {};
        String methodName = "admin_peers";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/

   /* public static void main(String[] args){
        Object[] params = new Object[] {"/usr/bin/solc"};
        String methodName = "admin_setSolc";// personal_listAccounts personal_newAccount
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        try {
            JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
            String[ ] address = client.invoke(methodName, params, String[].class, headers);
            System.out.println("=====================address: " + address);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/

    public static void main(String[] args){
     Object[] params = new Object[]{};
     String methodName = "admin_startRPC";
     Map<String,String> headers = new HashMap<>();
     headers.put("Content-Type","application/json");
     try{
         JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://192.168.0.15:140010 "));
         String[] flag = client.invoke(methodName, params, String[].class, headers);
         System.out.println(flag);
     }catch(Throwable throwable){
         throwable.printStackTrace();
     }
    
    }





}
