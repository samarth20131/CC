import java.rmi.*;
import java.rmi.server.*;
// import java.rmi.registry.*;

public class fiboServerImpl extends UnicastRemoteObject implements fiboServer
{
    fiboServerImpl() throws RemoteException
    {
        super();
    }
    public static void main(String args[]){
        try{
            fiboServerImpl Server = new fiboServerImpl();
            
            Naming.rebind("FIBO-SERVER",Server);

            System.out.println("Server Wailting ...");
        }
        catch(java.net.MalformedURLException ex){
            System.out.println("MalformedURLException: " + ex.toString());
        }
        catch(RemoteException re){
            System.out.println("RemoteException: " + re.toString());
        }
    }
    public int fibo(int n) throws RemoteException{ 
        if(n < 2)
            return n;
        else
            return fibo(n-1) + fibo(n-2);
    }
    public String palin(String n) throws RemoteException{
        int left=0;
        int right = n.length()-1;
        while(left<right){
            if(n.charAt(left)!= n.charAt(right)){
                return null;
            }
            left++;
            right--;
        }
        return "yes";
    }

    public int factorial(int n) throws RemoteException{
        int ans = 1;
        int i = 0;
        if(n < 2){
            return 1;
        }
        else{
            for(i=2; i<=n;i++){
                ans = ans*i;
            }
            return ans;
        }
    }

    public int arm(int n) throws RemoteException{
        int ans = 0;
        while(n!=0){
            int p = n%10;
            ans += p*p*p;
            n=n/10;
        }
        return ans;
    }

    public int prime(int p) throws RemoteException{
        int count = 0;
        if(p==1)
        return 1;
        for(int i=2; i<p; i++){
            if(p%i == 0){
                count = 1;
                break;
            }
        }   
        return count;
    }
}
