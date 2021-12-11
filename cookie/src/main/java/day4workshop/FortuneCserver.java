package day4workshop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FortuneCserver {
    

    public static void main(String[] args) throws IOException {
        String outputLineToClient=new String();
        ServerSocket serv=new ServerSocket(12345);
    System.out.println("listening at port " +serv.getLocalPort());
    Socket sock=serv.accept();
   try{
    InputStream inps=sock.getInputStream();
    OutputStream osos=sock.getOutputStream();
    BufferedInputStream binps= new BufferedInputStream(inps);
    DataInputStream dinps= new DataInputStream(binps);
    BufferedOutputStream bos=new BufferedOutputStream(osos);
    DataOutputStream dos=new DataOutputStream(bos);

    Cookie newCookie= new Cookie();
    String asas=new String("one");

while (newCookie.isLogin==false) {
    String inputFromClient=dinps.readUTF();
    Scanner scanForLogin=new Scanner(inputFromClient);
    if (scanForLogin.next().toLowerCase().equals("l"))
    {
        String logon=inputFromClient.substring(2);
            newCookie.login(logon);
            dos.writeUTF("Successful login");
           
    }
    else{
        dos.writeUTF("You are not registered. Please choose a username and password by typing in L followed by username/password");
       
    }
    dos.flush(); 
}


while (!asas.equals("exit"))
    {  
        String inputFromClient=dinps.readUTF();
         if (inputFromClient.equals("get-cookie"))
    {
        outputLineToClient=newCookie.returnCookie();
        dos.writeUTF(outputLineToClient);
        dos.flush();
    }
   else if (inputFromClient.equals("exit"))
   {
    dos.writeUTF("byebye");
    dos.flush();
   break;
   }
    else
    {
        dos.writeUTF("Wrong input");  
    dos.flush();
    }
    }
sock.close();
serv.close();
   }
   catch(Exception e)
   {
       System.out.println("server fail");
   }

}
}
