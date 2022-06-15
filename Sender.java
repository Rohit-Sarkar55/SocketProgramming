import java.io.*;
import java.net.*;
import java.util.*;

public class Sender{
	public static final String Host = "230.0.0.1";
	public static final int Port = 1234;
	public static void main(String []args)throws Exception{
	
	DatagramSocket sock = new DatagramSocket(5050);
	try{
	
	for(int i=0 ; i<10; i++){
		byte []byt = new Date().toString().getBytes();
		InetAddress group = InetAddress.getByName(Host);
		DatagramPacket	packet = new DatagramPacket(byt,byt.length, group , Port);
		sock.send(packet);
			
	}
	
	sock.close();
	}
	catch(Exception e){
		System.out.println(e);
		System.exit(1);
	}	
		
}


}