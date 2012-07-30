import java.util.Scanner;


public class I 
{
	public static int buscar(int n)
	{
		int l = 0;
		int h = n;
		while(l <= h)
		{
			int mid = (l + h) / 2;
			long pos = (((long) mid) * (mid + 1)) / 2;
		    if(pos < n)
				l = mid + 1;
			else if(pos > n)
			    h = mid - 1;
			else
				return mid;
		}
		return l;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int buscado = sc.nextInt();
			int numero = buscar(buscado);
			int base = ((numero - 1) * (numero)) / 2 + 1;
			if(numero % 2 == 0)
			{
				System.out.println("TERM " + buscado + " IS " + (buscado -  base + 1) + "/" + (numero - (buscado - base)));
			}
			else
			{
				System.out.println("TERM " + buscado + " IS " + (numero - (buscado - base)) + "/" + (buscado -  base + 1));
			}
		}
	}
}
