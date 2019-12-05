import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.io.*;
import java.lang.*;

public class ResultRMIClient
{ public static void main(String args[]) throws Exception
  { 
    // Create and install the security manager
    System.setSecurityManager(new RMISecurityManager());

    FileReader fr = new FileReader("studentdetails.txt");
    StreamTokenizer tok = new StreamTokenizer(fr);
    String name="",classval,s;
    double marks[] = new double[10];
    int i=0;
    tok.eolIsSignificant(true);
    try
    { 
        ResultRMI myResult = (ResultRMI)Naming.lookup(""
                          + args[0] + "" + "myResultRMI");

        while( tok.nextToken() != tok.TT_EOF)
    {

        if(tok.ttype == tok.TT_WORD)
        {
            name = tok.sval;
            System.out.println("\\nname is:"+name);
            System.out.println("Obtained marks are:");
        }

        if(tok.ttype == tok.TT_NUMBER)
        {

            marks[i] = tok.nval;    
            System.out.println("Marks of subject "+i +" is "+marks[i]);
            i++;

        }    
        if(tok.ttype == tok.TT_EOL && tok.ttype != tok.TT_EOF)
        {
            classval = myResult.calcresult(marks,i);
            System.out.println(name +" has " + classval);
            i=0;

        }     
    }

    fr.close();

    } 
    catch(Exception e)
    { 
        System.err.println("System Exception" + e);
    }
   System.exit(0);
  }
}
