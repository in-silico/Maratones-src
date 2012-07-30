import java.util.Scanner;

public class gnirut
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			System.out.println("6 " + n);
			System.out.println("0 1 1 1 R");
			System.out.println("1 0 2 0 R");
			System.out.println("1 1 3 1 R");
			System.out.println("2 0 1 0 L");
			System.out.println("3 1 4 1 R");
			System.out.println("4 0 4 0 R");
			for(int i = 0; i < n; i++)
			{
				String siguiente = sc.next();
				if(siguiente.equals("MLE"))
					System.out.println("3 1");
				else if(siguiente.equals("TLE"))
					System.out.println("1 1");
				else if(siguiente.equals("AC"))
					System.out.println("2 2");
				else if(siguiente.equals("WA"))
					System.out.println("2 3");
			}
		}
	}
}
