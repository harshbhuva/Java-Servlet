import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;


public class FileClient 
{

	
	public static void main(String[] args)
	{
		try
		{
			Socket soc=new Socket("localhost",4567);
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			FileOutputStream fis=new FileOutputStream("f1.html");
			int r;
			while((r=dis.read())!=-1)
			{
				fis.write((char)r);
			}
			System.out.print("File received...");
			
		}
		catch(Exception e)
		{
			System.out.print("Client Error: "+e.getMessage());
		}


	}

}
