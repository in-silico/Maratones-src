import java.util.Scanner;


public class B 
{
	
	public static int contar(int n, int w, int d, int suma)
	{
		for(int i = 1; i < n; i++)
		{
			int resultado = (n) * (n - 1) / 2;
			resultado *= w;
			resultado -= (w * i);
			resultado += ((w - d) * i);
			if(resultado == suma)
				return i;
		}
		return n;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
			System.out.println(contar(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
	}

}
