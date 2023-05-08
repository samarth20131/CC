import java.rmi.*;

public interface fiboServer extends Remote
{
	public int fibo(int a) throws RemoteException;
	public String palin(String str) throws RemoteException;
	public int factorial(int a) throws RemoteException;
	public int arm(int a) throws RemoteException;
	public int prime(int a) throws RemoteException;


}
