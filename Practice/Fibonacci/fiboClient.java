import java.rmi.*;
// import java.rmi.server.*;

public class fiboClient 
{
    public static void main(String[] args) {
        try {
            System.out.println("Security Manager Loaded");
            String url = "//localhost/FIBO-SERVER";

            fiboServer remoteObject = (fiboServer)Naming.lookup(url);
            
            System.out.println("Got remote object");
            System.out.print("\n");
            System.out.print("Fibonaacci Series : ");
            int a = Integer.parseInt(args[0]);
            for(int i=0;i<a;i++){
                System.out.print(remoteObject.fibo(i) + " ");
            }
            System.out.println("\n");
            String str = (args[1]);
            if(remoteObject.palin(str) != null){
                System.out.println("Entered Stirng is Palindrome");
            }
            else{
                System.out.println("Entered Stirng is Not Palindrome");
            }

            System.out.print("\n");
            int p = Integer.parseInt(args[2]);
            System.out.println("Factorial of " + p + " is : " + remoteObject.factorial(p));
            
            System.out.print("\n");
            int n = Integer.parseInt(args[3]);
            if(remoteObject.arm(n) == n)
            System.out.println(n + " is Armstrong number ");
            else
            System.out.println(n + " is not Armstrong number ");
            
            
            int m = Integer.parseInt(args[4]);
            if(remoteObject.prime(m)==0)
                System.out.println(m+" is prime");
            else
                System.out.println(m+" is not prime");

        }
        catch(RemoteException re){
            System.out.println("RemoteException: " + re.toString());
        }
        catch(java.net.MalformedURLException ex){
            System.out.println("MalformedURLException: " + ex.toString());
        }
        catch(java.rmi.NotBoundException exc){
            System.out.println("NotBoundException: " + exc.toString());
        }
    }
}