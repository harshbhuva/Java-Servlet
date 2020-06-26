import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServr {
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
