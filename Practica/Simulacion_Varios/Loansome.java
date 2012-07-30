import java.util.Scanner;


public class Loansome 
{
	static double[] prc = new double[120];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			if(n < 0)
				return;
			double pago = sc.nextDouble();
			double inicial = sc.nextDouble();
			int nval = sc.nextInt();
			for(int i = 0; i <= n; i++)
			{
				prc[i] = Double.POSITIVE_INFINITY;
			}
			for(int i = 0; i < nval; i++)
			{
				int pos = sc.nextInt();
				prc[pos] = sc.nextDouble();
			}
			double prcAnt = prc[0];
			double deuda = inicial;
			inicial += pago;
			pago = deuda / n;
			inicial = inicial - inicial * prcAnt;
			int i;
			for(i = 1; i <= n; i++)
			{
				if(deuda < inicial)
				{
					i = 0;
					break;
				}
				deuda -= pago;
				if(prc[i] != Double.POSITIVE_INFINITY)
					prcAnt = prc[i];
				inicial = inicial - inicial * prcAnt;
				if(deuda < inicial)
					break;
			}
			if(i == 1)
				System.out.println("1 month");
			else
				System.out.println(i + " months");
		}
	}

}
