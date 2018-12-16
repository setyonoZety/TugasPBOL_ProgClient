package ClientSC;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;
 
public class ComClient {
    public static void main(String args[]) throws Exception{
        try {
            Scanner sc = new Scanner(System.in);
            String ip = "localhost";
            int socket = 8888;   //JOptionPane.socket);
            //JOptionPane.showMessageDialog(null,socket);
            Socket sk=new Socket(ip,socket);
            BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintStream sout=new PrintStream(sk.getOutputStream());
            BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
            String s;
            while (  true ){
                System.out.print("Client : ");
                s = stdin.readLine();
                sout.println(s);
                s = sin.readLine();
                
                System.out.print("Server : "+s+"\n");
                if (s.equalsIgnoreCase("quit"))
                    break;
                }
            sk.close();
            sin.close();
            sout.close();
            stdin.close();
        } catch (Exception e) {
            System.out.println("Gagal menghubungi server \nKemungkinan kesalahan ip dan socket");
        }
    }
}