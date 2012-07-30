package GoogleCode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class numbers 
{
	public static numero exponente(numero numero, int exponente)
	{
		if(exponente > 1)
		{
			if(exponente % 2 == 0)
			{
				numero anterior = exponente(numero, exponente / 2);
				numero actual = new numero();
				actual.entera = (anterior.entera * anterior.entera + 5 * anterior.irracional * anterior.irracional) % 1000;
				actual.irracional = anterior.entera * anterior.irracional;
				actual.irracional += actual.irracional;
				actual.irracional = actual.irracional % 1000;
				return actual;
			}
			else
			{
				numero anterior = exponente(numero, exponente / 2);
				numero actual = new numero();
				actual.entera = (3 * anterior.entera * anterior.entera + 15 * anterior.irracional * anterior.irracional + 10 * anterior.entera * anterior.irracional) % 1000;
				actual.irracional = (anterior.entera * anterior.entera + 5 * anterior.irracional * anterior.irracional + 6 * anterior.entera * anterior.irracional) % 1000;
				return actual;
			}
		}
		else
		{
			if(exponente == 1)
			{
				return numero;
			}
			else
			{
				return null;
			}
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new File("in.in"));
		int numeroCasos = sc.nextInt();
		FileWriter s = new FileWriter("out.txt");
		for(int i = 0; i < numeroCasos; i++)
		{
			numero n = new numero();
			n.entera = 3;
			n.irracional = 1;
			numero x = exponente(n, sc.nextInt());
			int res = (2 * x.entera - 1) % 1000;
			s.write("Case #" + (i + 1) + ": ");
			if(res < 10)
				s.write("00" + res + System.getProperty("line.separator"));
			else if(res < 100)
				s.write("0" + res + System.getProperty("line.separator"));
			else
				s.write(res + System.getProperty("line.separator"));
		}
		s.close();
	}
}

class numero
{
	int entera = 0;
	int irracional = 0;
}
