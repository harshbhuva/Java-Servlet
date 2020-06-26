import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Clint {

	public static void main(String[] args)
	{
		try
		{
			Socket soc=new Socket("localhost",9876);
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter message: ");
			String msg=sc.nextLine();
			dos.writeUTF(msg);
			msg=dis.readUTF();
			System.out.println(msg);

			sc.close();
			dos.close();
			dis.close();
			soc.close();
		}
		catch(Exception e)
		{
			System.out.print("Client Error: "+e.getMessage());
		}

	}

}
