public interface ResultRMI extends java.rmi.Remote
{
    String calcresult(double marks[],int count) throws java.rmi.RemoteException;
}