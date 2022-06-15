import java.io.*;
import java.util.*;
import java.net.*;
public class Test1{
	public static void main(String []args)throws Exception{
		InetAddress add = InetAddress.getLocalHost();
		System.out.println(add);
		
		String sites;
		Scanner sc = new Scanner (System.in);
		sites = sc.next();
		String ipadd = InetAddress.getByName(sites).toString();
		System.out.println(ipadd);
	}
}