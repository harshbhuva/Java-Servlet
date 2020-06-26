import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SortClient 
{
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
			
			/*System.out.print("Enter no of elements: ");
			int n=sc.nextInt();
			dos.writeInt(n);
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
			{
				System.out.print("Enter no "+(i+1)+" : ");
				arr[i]=sc.nextInt();
				dos.writeInt(arr[i]);
			}			
			int [] arr1=new int[n];
			System.out.println("\n\nSorted array is: ");
			for(int i=0;i<n;i++)
			{
				arr1[i]=dis.readInt();
				System.out.print(" "+arr1[i]);
			}*/
			
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
