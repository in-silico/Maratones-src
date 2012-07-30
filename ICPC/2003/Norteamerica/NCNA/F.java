import java.util.Scanner;

public class F
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int caso = 1;
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int res = 0;
			if(n == 1)
				res = 1;
			else
				res = (int) Math.pow(n, n - 2);
			System.out.println("Case " + caso++ + ", N = " + n + ", # of different labelings = " + res);
		}
	}
}

