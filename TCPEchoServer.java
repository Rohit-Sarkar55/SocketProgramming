import java.io.*;
import java.net.*;
public class TCPEchoServer {
    public static final int BUFSIZE=80;
    public static void main(String args[])throws IOException
    {
        if(args.length!=1)
            throw new IllegalArgumentException("Paremeter :<port>");

        int servPort=Integer.parseInt(args[0]);
        ServerSocket servSock=new ServerSocket(servPort);   //create server

        int recMsgSize;                                 //msg size
        byte[] byteBuf=new byte[BUFSIZE];               //msg buffer

        for(;;){
            Socket cliSock=servSock.accept(); //connection established
            InputStream in=cliSock.getInputStream();
            OutputStream out= cliSock.getOutputStream();
            while((recMsgSize= in.read(byteBuf))!=-1)       //text is stored in bytebuf ; recMsgSize = size of bytebuf
                out.write(byteBuf,0,recMsgSize);
            cliSock.close();
        }

    }
}