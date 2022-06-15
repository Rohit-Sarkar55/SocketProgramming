import java.io.*;
import java.util.*;
import java.net.*;

public class TimeClient{
	public static final int PORT = 1234;
	public static void main(String []args) throws Exception{
	
	Socket socket = null;
	socket = new Socket("localhost" , PORT) ; 
	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	Date date = (Date)in.readObject();
	System.out.println("Date & Time " + date);
	}
}