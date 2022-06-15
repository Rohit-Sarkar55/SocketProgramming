
import java.io.*;
import java.net.*;
public class TCPEchoClient {
    public static void main(String args[])throws IOException
    {
        if(args.length<2 || args.length>3)
            throw new IllegalArgumentException("Parameters:<Server><word>[<port>]");
        String server=args[0];
        byte[] word=args[1].getBytes();
        int port=(args.length==3)?Integer.parseInt(args[2]):7;
        Socket sock = new Socket(server,port);
        System.out.println("Connected to server .... Sending echo string");

        InputStream in=sock.getInputStream();
        OutputStream out=sock.getOutputStream();
        out.write(word);


        int totalByteRead=0;
        int bytesread;
        while(totalByteRead<word.length){
            if((bytesread=in.read(word,totalByteRead,word.length-totalByteRead))==-1)
                throw new SocketException("connection closed prematurely ");
            totalByteRead+=bytesread;
        }
        System.out.println("Received : "+new String(word));
        sock.close();
    }
}