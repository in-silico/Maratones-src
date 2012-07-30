import java.util.Arrays;
import java.util.Scanner;


public class F 
{
	static class Partido
	{
		int a;
		int b;
		
		public Partido(int ai, int bi) 
		{
			a = ai;
			b = bi;
		}
	}
	
	static class Equipo implements Comparable <Equipo>
	{
		String nombre;
		int puntos;
		int peor;
		int mejor;

		public Equipo(String no)
		{
			nombre = no;
			puntos = 0;
			peor = 1;
			mejor = n;
		}
		
		@Override
		public int compareTo(Equipo o) 
		{
			return -Integer.valueOf(puntos).compareTo(o.puntos);
		}
	}
	
	static Equipo[] equipos = new Equipo[20];
	static Equipo[] equiposO = new Equipo[20];
	static Partido[] partidos = new Partido[20];
	static int[][] resultados = new int[2][20];
	static int n;
	static int fb = 0;
	
	public static void fb(int actual)
	{
		if(actual == fb)
		{
			Arrays.sort(equipos, 0, n); 
			int posicion = 1;
			int anterior = -1;
			for(int i = 0; i < n; i++)
			{
				if(equipos[i].puntos != anterior)
				{
					posicion = i;
					anterior = equipos[i].puntos;
				}
				equipos[i].mejor = Math.min(equipos[i].mejor, posicion + 1);
				equipos[i].peor = Math.max(equipos[i].peor, posicion + 1);
			}
		}
		else
		{
			Partido este = partidos[actual];
			equiposO[este.a].puntos += 3;
			fb(actual + 1);
			equiposO[este.a].puntos -= 3;
			equiposO[este.b].puntos += 3;
			fb(actual + 1);
			equiposO[este.b].puntos -= 3;
			equiposO[este.a].puntos++;
			equiposO[este.b].puntos++;
			fb(actual + 1);
			equiposO[este.a].puntos--;
			equiposO[este.b].puntos--;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		boolean inicio = false;
		while(true)
		{
			fb = 0;
			n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0)
				return;
			if(inicio)
				System.out.println();
			else
				inicio = true;
			for(int i = 0; i < n; i++)
				equipos[i] = equiposO[i] = new Equipo(sc.next());
			for(int i = 0; i < m; i++)
			{
				String a = sc.next();
				sc.next();
				String b = sc.next();
				b = b.substring(0, b.length() - 1);
				int ap = sc.nextInt();
				int bp = sc.nextInt();
				int ai = 0, bi = 0;
				for(int j = 0; j < n; j++)
					if(equipos[j].nombre.equals(a))
						ai = j;
				for(int j = 0; j < n; j++)
					if(equipos[j].nombre.equals(b))
						bi = j;
				if(ap == -1 && bp == -1)
					partidos[fb++] = new Partido(ai, bi);
				else
				{
					if(ap > bp)
						equipos[ai].puntos += 3;
					else if(ap < bp)
						equipos[bi].puntos += 3;
					else
					{
						equipos[ai].puntos++;
						equipos[bi].puntos++;
					}
				}
			}
			fb(0);
			for(int i = 0; i < n; i++)
			{
				Equipo actual = equiposO[i];
				System.out.print("Team " + equiposO[i].nombre + " can finish as high as " + actual.mejor);
				if(actual.mejor == 1)
					System.out.print("st");			
				else if(actual.mejor == 2)
					System.out.print("nd");
				else if(actual.mejor == 3)
					System.out.print("rd");
				else
					System.out.print("th");
				System.out.print(" place and as low as " + actual.peor);
				if(actual.peor == 1)
					System.out.print("st");			
				else if(actual.peor == 2)
					System.out.print("nd");
				else if(actual.peor == 3)
					System.out.print("rd");
				else
					System.out.print("th");
				System.out.println(" place.");
			}
		}
	}
}
