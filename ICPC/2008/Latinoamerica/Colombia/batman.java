package UVA;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class batman 
{
	Boolean termino = false;
	int maxCalorias = 0;
	public static Scanner sc;
	ArrayList <Villano> villanos;
	ArrayList <Superpoder> superpoderes;
	public int [][] minimoCosto;
	public static long inicio;
	
	public static void main (String [] args) throws FileNotFoundException
	{
		sc = new Scanner(System.in);
		for(;;)
		{
			batman m = new batman();
			if(m.termino || !sc.hasNextLine())
			{
				return;
			}
		}
	}
	
	public batman()
	{
		Scanner sc2 = new Scanner(sc.nextLine());
		villanos = new ArrayList <Villano> ();
		superpoderes = new ArrayList <Superpoder> ();
		int nPoderes = sc2.nextInt();
		int nVillanos = sc2.nextInt();
		minimoCosto = new int [nPoderes + 1][nVillanos + 1];
		for(int i = 0; i < nPoderes; i++)
		{
			minimoCosto[i][0] = 0;
		}
		maxCalorias = sc2.nextInt();
		if(nPoderes == 0 && nVillanos == 0 && maxCalorias == 0)
		{
			termino = true;
			return;
		}
		Superpoder p = new Superpoder();
		p.nombre = "";
		p.ataque = 0;
		p.consumo = Integer.MAX_VALUE;
		superpoderes.add(p);
		for(int i = 0; i < nPoderes; i++)
		{
			sc2 = new Scanner(sc.nextLine());
			Superpoder s = new Superpoder();
			s.nombre = sc2.next();
			s.ataque = sc2.nextInt();
			s.consumo = sc2.nextInt();
			superpoderes.add(s);
		}
		if(nVillanos == 0)
		{
			System.out.println("Yes");
			return;
		}
	    Villano p1 = new Villano();
	    p1.defensa = Integer.MAX_VALUE;
	    villanos.add(p1);
		for(int i = 0; i < nVillanos; i++)
		{
			sc2 = new Scanner(sc.nextLine());
			Villano v = new Villano();
			sc2.next();
			v.defensa = sc2.nextInt();
			Scanner sc3 = new Scanner(sc2.next());
			sc3.useDelimiter(",");
			while(sc3.hasNext())
			{
				v.superpoderes.add(sc3.next());
			}
			villanos.add(v);
		}
		if(nPoderes == 0)
		{
			System.out.println("Yes");
			return;
		}
		for(int j = 1; j < nVillanos + 1; j++)
		{
			for(int i = j; i < nPoderes + 1; i++)
			{
				int costoAnterior = i > 0 ? minimoCosto[i - 1][j - 1] : 0; 
				int costoDerrotar = villanos.get(j).superpoderes.contains(superpoderes.get(i).nombre) && (villanos.get(j).defensa <= superpoderes.get(i).ataque) ? costoAnterior != Integer.MAX_VALUE ? superpoderes.get(i).consumo + costoAnterior : Integer.MAX_VALUE : Integer.MAX_VALUE;
				int costoUnPoderMenos = i > j ? minimoCosto[i - 1][j] : Integer.MAX_VALUE;
				minimoCosto[i][j] = Math.min(costoDerrotar, costoUnPoderMenos);
			}
		}
		System.out.println(minimoCosto[nPoderes][nVillanos] <= maxCalorias ? "Yes" : "No");
	}
	
	private class Villano
	{
		int defensa;
		ArrayList <String> superpoderes = new ArrayList <String> ();
	}

	private class Superpoder
	{
		String nombre;
		int ataque;
		int consumo;
	}
}