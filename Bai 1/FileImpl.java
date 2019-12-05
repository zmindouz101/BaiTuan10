import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
public class FileImpl extends UnicastRemoteObject implements FileInterface
{ private String name;
public FileImpl(String s)throws RemoteException {
super();
name=s;
}
public byte[] downloadFile(String fileName)throws RemoteException {
try {
File file=new File(fileName);

byte b[]=new byte[(int)file.length()];
BufferedInputStream bis=new BufferedInputStream(new FileInputStream(fileName));
bis.read(b,0,b.length);
bis.close();
return b;
} catch(Exception e) {
System.err.println(e);
return null;
}
}
}