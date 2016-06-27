package com.merryyou.thread;

/**
 * Created on 2016/6/8 0008.
 *
 * @author zlf
 * @since 1.0
 */
public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    public static void doPost(String username,String password){
        try{
            usernameRef = username;
            if(username.equals("a")){
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username =" +usernameRef +"    password ="+passwordRef);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
