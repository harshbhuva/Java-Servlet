import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class FileServer
{

	
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket soc = new ServerSocket(4567);
			Socket s=soc.accept();
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			FileInputStream ff=new FileInputStream("src//f1.html");
			int r;
			while((r=ff.read())!=-1)
			{
				dos.write(r);
			}
			
			ff.close();
			dos.close();
			soc.close();
		}
		catch(Exception e)
		{
			System.out.print("Server Error: "+e.getMessage());
		}

	}

}
