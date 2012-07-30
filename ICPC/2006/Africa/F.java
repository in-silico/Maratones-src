import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class F 
{
	static int[] p = new int[1000001];
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		p[1] = -1;
		for(int i = 2; i < 1000001; i++)
		{
			int cuenta = 0;
			int ii = i;
			int limite = Math.min(ii - 1, (int) (Math.round(Math.sqrt(ii)) + 1));
			for(int j = 2; j <= limite; j++)
			{
				if(ii % j == 0)
				{
					cuenta++;
					ii /= j;
					break;
				}
			}
			System.setOut(new PrintStream("sd.txt"));
			if(cuenta == 0)
				p[i] = 1;
			else
				p[i] = 1 + p[ii];
		}
		for(int i = 2; i < 1000001; i++)
		{
			if(p[i] == 1)
				p[i] = -2;
			else
				p[i]--;
		}
		int caso = 1;
		while(true)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == -1 && b == -1)
				return;
			int cuenta = 0;
			for(int i = a; i <= b; i++)
				cuenta += p[i];
			int cuanto = 0;
			int mejorA = 0;
			int cualA = a;
			for(int j = a + 1; j <= b; j++)
			{
				cuanto += p[j - 1];
				if(cuanto < mejorA)
				{
					mejorA = cuanto;
					cualA = j;
				}
			}
			cuanto = 0;
			int mejorB = 0;
			for(int j = b - 1; j >= cualA; j--)
			{
				cuanto += p[j + 1];
				if(cuanto < mejorB)
					mejorB = cuanto;
			}
			int suma = cuenta - mejorA - mejorB;
			System.out.println(caso++ + ". " + suma);
		}
	}

}
