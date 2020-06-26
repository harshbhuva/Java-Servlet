import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SortServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket soc=new ServerSocket(9876);
			Socket s=soc.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			
			String msg=dis.readUTF();
			msg=msg.toUpperCase();
			
			dos.writeUTF(msg);
			
			/*int n=dis.readInt();
			int [] arr=new int[n];
			
			for(int i=0;i<n;i++)
			{
				arr[i]=dis.readInt();
			}
			
			Arrays.sort(arr);
			
			for(int i=0;i<n;i++)
			{
				dos.writeInt(arr[i]);
			}*/
			
			dos.close();
			dis.close();
			soc.close();
		}
		catch(Exception e)
		{
			System.out.print("Server Error: "+e.getMessage());
		}

	}
}
