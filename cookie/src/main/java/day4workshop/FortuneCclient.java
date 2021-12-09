package day4workshop;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FortuneCclient {
    public static void main(String[] args) throws UnknownHostException,IOException {
        Socket sock=new Socket("localhost",12345);
OutputStream osos=sock.getOutputStream();
InputStream inps=sock.getInputStream();

    BufferedOutputStream bos=new BufferedOutputStream(osos);
    DataOutputStream dos=new DataOutputStream(bos);
    BufferedInputStream binps= new BufferedInputStream(inps);
    DataInputStream dinps= new DataInputStream(binps);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

String msg=br.readLine();
dos.writeUTF(msg);

dos.flush();
String abc=new String(dinps.readUTF());
System.out.println(abc);
sock.close();
    }
}
