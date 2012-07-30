package UVA;

import java.util.Arrays;
import java.util.Scanner;

public class vito
{
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int ncasos = sc.nextInt();
		for(int i = 0; i < ncasos; i++)
		{
			int nfamiliares = sc.nextInt();
			int [] familiares = new int [nfamiliares];
			for(int j = 0; j < nfamiliares; j++)
			{
				familiares[j] = sc.nextInt();
			}
			Arrays.sort(familiares);
			int escogida = 0;
			if(nfamiliares % 2 == 0)
			{
				escogida = (familiares[(nfamiliares / 2) - 1] + familiares[(nfamiliares / 2)]) / 2;
			}
			else
			{
				escogida = familiares[nfamiliares / 2];
			}
			int distancia = 0;
			for(int j = 0; j < nfamiliares; j++)
			{
				distancia += Math.abs(escogida - familiares[j]);
			}
			System.out.println(distancia);
		}
	}

}
