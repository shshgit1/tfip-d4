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

public class FortuneCserver {

    public static void main(String[] args) throws IOException {
        String opop=new String();
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

String inputFromClient="1";

System.out.println(inputFromClient);
Cookie newCookie= new Cookie();

while (!inputFromClient.equals("exit"))
{
    inputFromClient=dinps.readUTF();
if (inputFromClient.equals("get-cookie"))
{
    System.out.println(inputFromClient);
opop=newCookie.returnCookie();
System.out.println(opop); 
dos.writeUTF(opop);

}
else
{System.out.println("wrong: "+inputFromClient);
    dos.writeUTF("Wrong input");  
    
}
dos.flush();
}
sock.close();
serv.close();
   }
   catch(Exception e)
   {
       System.out.println("error!!!");
   }

}
}
