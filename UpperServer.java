import java.io.*;
import java.net.*;
import java.util.*;

public class UpperServer{
	public static final int Port = 1234;
	public static void main(String []args)throws Exception{
		String s , caps;
		ServerSocket server = new ServerSocket(Port);
		System.out.println("Connected");
		Socket sock = null;
		try{
		while(true){
			
			sock = server.accept();
			Scanner in = new Scanner(sock.getInputStream());
			DataOutputStream out = new DataOutputStream(sock.getOutputStream());
			s = in.nextLine();
			caps = s.toUpperCase();
			out.writeBytes(caps);
			out.close();
			in.close();
			sock.close();
		}
		}catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}
	}
}