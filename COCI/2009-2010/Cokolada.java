import java.util.Scanner;


public class Cokolada 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int p = 1;
		while(p < k)
			p <<= 1;
		int cortes = intentar(p, k);
		System.out.println(p + " " + cortes);
	}

	private static int intentar(int p, int k) 
	{
		if(p == k)
			return 0;
		if(k - p / 2 > 0)
			return 1 + intentar(p / 2, k - p / 2);
		else
			return 1 + intentar(p / 2, k);
	}

}
