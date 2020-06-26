import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Myreceiver {

	public static void main(String[] args) {
		try
		{
			DatagramSocket rec=new DatagramSocket(1234);
			DatagramPacket pack=null;
			String msg="";
			byte b[]=new byte[1024];
			
			pack=new DatagramPacket(b,b.length);
			rec.receive(pack);
			b=pack.getData();
			msg=new String(b);
			System.out.println(" Message from sender : "+msg);
			String data="";
			
			for(int i=0;i<msg.length();i++)
			{
				//System.out.println("here");
				char ch=msg.charAt(i);
				if(ch>65 && ch<90)
				{
					ch=(char)(ch+32);
				}
				else
				{
					ch=(char)(ch-32);
				}
				data=msg+ch;
			}
			
			System.out.println("Sending Data back...");
			b=data.getBytes();
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,1234);
			rec.send(pack);
			
			
			
			rec.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Receiver Msg: "+e.getMessage());
		}

	}

}
