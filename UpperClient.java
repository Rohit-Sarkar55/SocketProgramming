import java.io.*;
import java.net.*;
import java.util.*;

public class UpperClient{
	public static final int Port = 1234;
	public static void main(String []args)throws Exception{
		String s , caps;
		Scanner sc = new Scanner (System.in);
		try{
		Socket sock= new Socket("localhost" , Port);
		
		Scanner in = new Scanner(sock.getInputStream());
		DataOutputStream out =new DataOutputStream(sock.getOutputStream());
		s = sc.nextLine();
		out.writeBytes(s + "\n");
		caps = in.nextLine();
		System.out.println(caps);
		
		in.close();
		out.close();
		sc.close();
		sock.close();
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(1);
		}
	}
}