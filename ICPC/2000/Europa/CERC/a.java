import java.util.Scanner;
import java.util.TreeMap;


public class a 
{
	static TreeMap <Long, Long> dp = new TreeMap <Long, Long> ();
	
	static long numero(long n)
	{
		if(n < 12)
			return n;
		if(dp.containsKey(n))
			return dp.get(n);
		long val = Math.max(n, numero(n / 2) + numero(n / 3) + numero(n / 4));
		dp.put(n, val);
		return val;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int numero = sc.nextInt();
			System.out.println(numero(numero));
		}
	}
}
