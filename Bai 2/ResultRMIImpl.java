
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ResultRMIImpl extends UnicastRemoteObject implements ResultRMI
{

  public ResultRMIImpl(String name) throws RemoteException
  {
    super();
    try
    {
      Naming.rebind(name, this);
    } 
    catch (Exception e)
    { 
      System.out.println("Exception: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public String calcresult(double marks[],int count) throws RemoteException
  { 
    double total=0.0,average;
    for(int i=0;i<count;i++)
    {
        total=total+marks[i];
    }
    average = total/count;
    if(average >= 70)
    {
        return "Distinction";
    }
    else if(average >=60 && average < 70)
    {
        return "Firstclass";
    }
    else if(average >=50 && average < 60)
    {
        return "secondclass";
    }
    else if(average >=40 && average <50)
    {
        return "passcalss";
    }
    else 
    {
        return "fail";
    }

  }
}