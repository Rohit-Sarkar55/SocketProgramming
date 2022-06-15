import java.io.*;
import java.net.*;
import java.util.*;

public class Reciever{
	public static final String Host = "230.0.0.1";
	public static final int Port = 1234;
	public static void main(String []args)throws Exception{
		
	MulticastSocket sock = new MulticastSocket(Port);
	InetAddress group = InetAddress.getByName(Host);
	try{
	sock.joinGroup(group);
	System.out.println("Connected");
	for(int i=0 ; i<10; i++){
		byte []byt = new byte[30];
		DatagramPacket	packet = new DatagramPacket(byt,byt.length);
		sock.receive(packet);
		String str = new String(packet.getData());
		System.out.println(str);
		Thread.sleep(1500);	
	}
	sock.leaveGroup(group);
	sock.close();
	}
	catch(Exception e){
		System.out.println(e);
		System.exit(1);
	}
}


}