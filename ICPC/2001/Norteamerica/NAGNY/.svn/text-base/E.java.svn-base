import java.math.BigInteger;
import java.util.Scanner;


public class E 
{
	public static BigInteger sumatoria(BigInteger n)
	{
		return n.multiply(n.add(BigInteger.ONE)).shiftRight(1);
	}
	
	public static BigInteger antiSumatoria(BigInteger n)
	{
		BigInteger low = BigInteger.ZERO;
		BigInteger mid = null, sumatoriaMid;
		BigInteger high = n;
		while(low.compareTo(high) <= 0)
		{
			mid = low.add(high).shiftRight(1);
			sumatoriaMid = sumatoria(mid);
			if(n.compareTo(sumatoriaMid) > 0)
				low = mid.add(BigInteger.ONE);
			else if(n.equals(sumatoriaMid))
				return mid;
			else
				high = mid.subtract(BigInteger.ONE);
		}
		return mid.subtract(n.compareTo(sumatoria(mid)) < 0 ? BigInteger.ONE : BigInteger.ZERO);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			BigInteger nuevo = sc.nextBigInteger();
			BigInteger anti = antiSumatoria(nuevo);
			if(nuevo.compareTo(BigInteger.ONE.add(BigInteger.ONE)) > 0 && anti.multiply(anti.add(BigInteger.ONE)).divide(BigInteger.ONE.add(BigInteger.ONE)).equals(nuevo))
				System.out.println("Yes.");
			else
				System.out.println("No.");
		}
	}

}
