import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiServer 
{
	public static void main(String[] args)
	{
		try
		{
			int i=0;
			ServerSocket ss=new ServerSocket(8511);
			System.out.print("waiting...");
			while(true)
			{
				Socket soc=ss.accept();
				System.out.print("\nConnected to "+soc.getInetAddress()+" "+(++i));
				ClientThread ct=new ClientThread(soc,i);
			}
		}
		catch(Exception e)
		{
			System.out.print("Server msg: "+e.getMessage());
		}
	}
}

class ClientThread extends Thread
{
	Socket soc;
	int i;
	ClientThread(Socket soc,int i)
	{
		this.soc=soc;
		this.i=i;
		start();
	}
	public void run()
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			PrintWriter p=new PrintWriter(soc.getOutputStream(),true);
			while(true)
			{
				String str=br.readLine();
				System.out.print("\nMsg from "+i+": "+str);
				if(str.equalsIgnoreCase("stop"))
				{
					break;
				}
				else
				{
					StringBuffer sb=new StringBuffer(str);
					str=sb.reverse().toString();
					p.println(str);
				}
			}
		}
		catch(Exception e)
		{
			System.out.print("ClientThread error: "+e.getMessage());
		}
	}
}