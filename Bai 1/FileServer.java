import java.io.*;
import java.rmi.*;
import java.net.*;
public class FileServer
{
	public static void main(String[] args) throws Exception
	{
		FileInterface fi=new FileImpl("FileServer");
		InetAddress dc=InetAddress.getLocalHost();
		Naming.rebind("rmi://"+dc.getHostAddress()+"/FileServer",fi);
		System.out.println("Server ready for client requests...");
	}
}