import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Grants 
{
	
	static class Estudiante
	{
		int numero;
		int monedas = 40;
		
		Estudiante(int n)
		{
			numero = n;
		}
	}
	
	static LinkedList <Estudiante> fila = new LinkedList <Estudiante> ();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(n == 0 && k == 0)
				return;
			fila.clear();
			for(int i = 1; i <= n; i++)
				fila.add(new Estudiante(i));
			int cuentaActual = 1;
			int monedasActuales = 1;
			ArrayList <Integer> ordenSalida = new ArrayList <Integer> ();
			while(true)
			{
				if(monedasActuales == 0)
					monedasActuales = cuentaActual;
				if(fila.isEmpty())
					break;
				Estudiante primero = fila.getFirst();
				if(primero.monedas <= monedasActuales)
				{
					monedasActuales -= primero.monedas;
					if(monedasActuales == 0)
					{
						cuentaActual++;
						if(cuentaActual == k + 1)
							cuentaActual = 1;
					}
					ordenSalida.add(primero.numero);
					fila.removeFirst();
				}
				else
				{
					primero.monedas -= monedasActuales;
					monedasActuales = 0;
					cuentaActual++;
					if(cuentaActual == k + 1)
						cuentaActual = 1;
					fila.addLast(fila.removeFirst());
				}
			}
			for(int e : ordenSalida)
			{
				if(e >= 10)
					System.out.print(" " + e);
				else
					System.out.print("  " + e);
			}
			System.out.println();
		}
	}

}
