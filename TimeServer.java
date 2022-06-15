import java.io.*;
import java.util.*;
import java.net.*;

public class TimeServer{
	public static final int PORT = 1234;
	public static void main(String []args) throws Exception{
		ServerSocket server = null;
		Socket socket = null;
		try{
			server = new ServerSocket(PORT);
			System.out.println("Connected");
			while(true){
				//try{
				socket = server.accept();
				//}
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(new Date());
			out.close();
			socket.close();
			}
		}
		catch(Exception e){
			System.out.println(e);		
		}
		
	}
}