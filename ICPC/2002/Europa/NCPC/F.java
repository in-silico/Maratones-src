import java.util.Scanner;


public class F 
{
	public static void main(String[] args)
	{
		boolean[] noPrimo = new boolean[1 << 15 + 1];
		for(int i = 2; i < 1 << 15 + 1; i++)
			if(!noPrimo[i])
				for(int j = i << 1; j < 1 << 15 + 1; j += i)
					noPrimo[j] = true;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			int limite = n >> 1;
			int cuenta = 0;
			for(int j = 2; j <= limite; j++)
			{
				if(!noPrimo[j] && !noPrimo[n - j])
					cuenta++;
			}
			System.out.println(cuenta);
		}
	}

}
