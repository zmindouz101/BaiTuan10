import java.rmi.*;
import java.rmi.server.*;

public class ResultRMIServer
{

 public static void main(String args[])
 {

   // Create and install the security manager
   System.setSecurityManager(new RMISecurityManager());

   try
   {
     // Create ResultRMIImpl
     ResultRMIImpl myResult = new ResultRMIImpl("//Binita/myResultRMI");
     System.out.println("ResultRMI Server ready.");
   } 
   catch (Exception e)
   { 
     System.out.println("Exception: " + e.getMessage());
     e.printStackTrace();
   }
 }
}
