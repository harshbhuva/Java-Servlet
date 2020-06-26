import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Multiclient
{
	public static void main(String[] args)
	{
		try
		{
			Socket soc=new Socket("localhost",8511);
			BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			PrintWriter p=new PrintWriter(soc.getOutputStream(),true);
			Scanner sc=new Scanner(System.in);
			
			while(true)
			{
				System.out.print("\nEnter message: ");
				String str=sc.nextLine();
				p.println(str);
				if(str.equalsIgnoreCase("stop"))
				{
					break;
				}
				str=br.readLine();
				System.out.print("Reverse msg: "+str);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.print("Client error: "+e.getMessage());
		}

	}

}
