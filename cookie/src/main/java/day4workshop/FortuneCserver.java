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
   
    InputStream inps=sock.getInputStream();
    OutputStream osos=sock.getOutputStream();
        BufferedInputStream binps= new BufferedInputStream(inps);
        DataInputStream dinps= new DataInputStream(binps);
        BufferedOutputStream bos=new BufferedOutputStream(osos);
    DataOutputStream dos=new DataOutputStream(bos);

String mm=new String(dinps.readUTF());
System.out.println(mm);
Cookie newCookie= new Cookie();
if (mm.equals("get-cookie"))
{
opop=newCookie.returnCookie();
System.out.println(opop); 
}

dos.writeUTF(opop);
dos.flush();
sock.close();
serv.close();

}
}
