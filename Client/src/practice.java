
public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, k;
        for (i= 7;i>0;i=i-2)
        {
            for(k=7;k>0;k=k-2)
            {
                if(k==i)
                {
                    break;
                }
                else
                {
                    System.out.print("1");
                }
            }
            for(j=0;j<i;j++)
            {
                System.out.print("@");
            }
            System.out.println("");
        }

	}

}
