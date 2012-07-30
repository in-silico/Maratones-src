import java.util.Scanner;

public class B 
{
	static int[] pitches = new int[100];
	static int n;
	
	private static int intentar(int numero) 
	{
		int sumas = 0;
		int mayor = 0;
		for(int i = 0; i < n; i++)
		{
			sumas += pitches[i];
			mayor = Math.max(mayor, pitches[i]);
		}
		int mejor = numero / mayor + 1;
		if(numero < mayor || mejor < 2 || numero < sumas * 2)
			return 0;
		return mejor;
	}
	

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			n = sc.nextInt();
			if(n == 0)
				return;
			for(int i = 0; i < n; i++)
				pitches[i] = sc.nextInt();
			System.out.println(intentar(50) + " " + intentar(60) + " " + intentar(70));
		}
	}
}
