import java.util.Scanner;


public class Snail
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int h = sc.nextInt();
			int u = sc.nextInt();
			int d = sc.nextInt();
			int f = sc.nextInt();
			if(h == 0)
				return;
			double distanciaActual = u;
			double factor = u * (f / 100.0);
			int dia = 1;
			double actual = 0;
			while(true)
			{
				if(distanciaActual > 0)
					actual += distanciaActual;
				if(actual > h)
				{
					System.out.println("success on day " + dia);
					break;
				}
				actual -= d;
				if(actual < 0)
				{
					System.out.println("failure on day " + dia);
					break;
				}
				dia++;
				distanciaActual -= factor;
			}
		}
	}
}
