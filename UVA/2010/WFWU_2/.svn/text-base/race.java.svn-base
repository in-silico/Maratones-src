package UVA;

import java.text.DecimalFormat;
import java.util.*;

public class race {
	
	static final int MAX = 1000000;
	static double [] prob = new double[MAX];
	static ArrayList<Integer> prime = new ArrayList<Integer>(100000);
//	static int[] primosHasta = new int[1000000];
	static boolean [] esPrimo = new boolean[MAX];
	static int [] factores = new int[100];
	
	static void calcProb() {
		int n=0;
		for (int i = 2; i <= MAX; i++) {
			int m;
			int fact = 0;
			int actual = i;
			while(!esPrimo[actual - 1])
			{
				m = (int) (Math.sqrt(actual)) + 1;
				for (int fac : prime) {
					if(fac >= m)
						break;
					if (actual % fac == 0) 
					{
						boolean esta = false;
						for(int j = 0; j < fact; j++)
							if(factores[j] == fac)
								esta = true;
						if(!esta)
							factores[fact++] = fac;
						actual /= fac;
						break;
					}
				}
				if(fact == 0)
					break;
			}
			if(fact > 0)
			{
				double p = 0.0;
				boolean ya = false;
				for(int j = 0; j < fact; j++)
				{
					p += prob[(i / factores[j]) - 1];
					if(factores[j] == actual)
						ya = true;
				}
				if(!ya)
				{
					fact++;
					p += prob[(i / actual) - 1];
				}
				p /= fact;
				p += (n + 0.0) / fact;
				prob[i - 1] = p;
			}
			else 
			{
				prime.add(i);
				n++;
				prob[i - 1] = n;
				esPrimo[i - 1] = true;
			}
//			if(i != 1000000)
//				primosHasta[i] = n; 
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.0000000000");
		prob[0]=0.0;
		calcProb();
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
//		Random r = new Random();
		for (int i=0; i<T; i++) {
			int D = in.nextInt();
//			int prueba = 0;
//			for(int j = 0; j < 1000000; j++)
//			{
//				int cuenta = 0;
//				int actual = D;
//				while(actual != 1)
//				{
//					int azar = r.nextInt(primosHasta[actual]);
//					cuenta++;
//					if(actual % prime.get(azar) == 0)
//					{
//						actual /= prime.get(azar);
//					}
//				}
//				prueba += cuenta;
//			}
//			System.out.println((prueba + 0.0) / 1000000);
			System.out.print("Case " + (i+1) + ": ");
			if (D>1)
				System.out.println( df.format(prob[D-1]) );
			else
				System.out.println( "0.0000000000" );
		}
	}
}
