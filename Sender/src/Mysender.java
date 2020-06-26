import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Mysender {

	public static void main(String[] args) {
		try
		{
			DatagramSocket sen=new DatagramSocket(123);
			DatagramPacket pack=null;
			String msg="";
			byte b[]=new byte[1024];
			Scanner sc=new Scanner(System.in);
					
			System.out.print("Enter msg for receiver: ");
			msg=sc.nextLine();
			b=msg.getBytes();
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,1234);
			sen.send(pack);
			
			System.out.println(" Waiting...");
			pack=new DatagramPacket(b,b.length);
			sen.receive(pack);
			b=pack.getData();
			msg=new String(b);
			//msg=msg.toUpperCase();
			System.out.println(" Message from receiver : "+msg);
			
			
			sen.close();
			sc.close();
		}
		catch(Exception e)
		{
			System.out.println("Sender Msg: "+e.getMessage());
		}
	}

}
