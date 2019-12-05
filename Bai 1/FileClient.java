import java.rmi.*;
import java.io.*;
public class FileClient
{
	public static void main(String[] args) throws Exception
	{	if(args.length!=2) {
				System.out.println("Su dung:java FileClient fileName machineName ");
				System.exit(0);
			}
			String name="rmi://"+args[1]+"/FileServer";
			FileInterface fi=(FileInterface)Naming.lookup(name);
			byte[] filedata=fi.downloadFile(args[0]);
			File file =new File(args[0]);
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file.getName()));
			bos.write(filedata,0,filedata.length);
			bos.flush();
			bos.close();
	}
}