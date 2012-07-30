package UVA;

import java.util.Scanner;


public class laser 
{
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int altura = sc.nextInt();
			int ancho = sc.nextInt();
			if(altura == 0 && ancho == 0)
				return;
			int[] columnas = new int[ancho];
			for(int i = 0; i < ancho; i++)
				columnas[i] = sc.nextInt();
			int anterior = altura;
			int cuenta = 0;
			for(int i = 0; i < ancho; i++)
			{
	            if(columnas[i] < anterior)
                    cuenta += anterior - columnas[i];
	            anterior = columnas[i];
			}
			System.out.println(cuenta);
		}
	}

}
