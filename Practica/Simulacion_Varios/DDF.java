import java.util.ArrayList;
import java.util.Scanner;


public class DDF 
{
	
	public static void main(String[] args)
	{
		ArrayList < ArrayList <Integer> > factores = new ArrayList < ArrayList <Integer> >(3001);
		factores.add(new ArrayList <Integer> ());
		for(int i = 1; i <= 3000; i++)
		{
			ArrayList <Integer> factoresEste = new ArrayList <Integer> ();
			factoresEste.add(1);
			if(i != 1)
				factoresEste.add(i);
			for(int j = 2; j <= i / 2; j++)
			{
				if(i % j == 0)
					factoresEste.add(j);
			}
			factores.add(factoresEste);
		}
		boolean[] esta = new boolean[3001];
		ArrayList <ArrayList <Integer> > DDF = new ArrayList< ArrayList <Integer> > (3001);
		ArrayList <Integer> cero = new ArrayList <Integer> ();
		cero.add(0);
		ArrayList <Integer> uno = new ArrayList <Integer> ();
		uno.add(1);
		DDF.add(cero);
		DDF.add(uno);
		for(int i = 2; i <= 3000; i++)
		{
			for(int j = 0; j <= 3000; j++)
			{
				esta[j] = false;
			}
			int actual = i;
			ArrayList <Integer> este = new ArrayList <Integer> ();
			esta[actual] = true;
			este.add(actual);
			while(true)
			{
				int cuenta = 0;
				for(int a : factores.get(actual))
				{
					while(a != 0)
					{
						cuenta += a % 10;
						a /= 10;
					}
				}
				if(esta[cuenta])
					break;
				este.add(cuenta);
				esta[cuenta] = true;
				actual = cuenta;
			}
			DDF.add(este);
		}
		Scanner sc = new Scanner(System.in);
		int act = 1;
		while(sc.hasNextInt())
		{
			int menor = sc.nextInt();
			int mayor = sc.nextInt();
			System.out.println("Input" + act + ": " + menor + " " + mayor);
			if(menor > mayor)
			{
				int temp = menor;
				menor = mayor;
				mayor = temp;
			}
			int mejor = 0;
			int numMejor = 0;
			for(int i = menor; i <= mayor; i++)
			{
				if(DDF.get(i).size() > mejor)
				{
					numMejor = i;
					mejor = DDF.get(i).size();
				}
			}
			System.out.print("Output" + act++ + ":");
			for(int i : DDF.get(numMejor))
			{
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}

}
