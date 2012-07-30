import java.util.Scanner;

public class J 
{
	static boolean[] noPrimo = new boolean[1000001];
	
	public static void main(String[] args)
	{
		for(int i = 2; i <= 1000000; i++)
		{
			if(!noPrimo[i])			
				for(int j = i * 2; j <= 1000000; j += i)
				{
					noPrimo[j] = true;
				}
		}
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int num = sc.nextInt();
			if(num == -1)
				return;
			boolean paila = false;
			for(int i = 2; i <= num; i++)
			{
				if(!noPrimo[i] && num % i == 0)
					if(i % 10 != 3)
					{
						paila = true;
						break;
					}
			}
			System.out.print(num + " ");
			if(paila)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}