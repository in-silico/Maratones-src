import java.util.LinkedList;
import java.util.Scanner;

public class E 
{
	static boolean[][][] visitados = new boolean[200][200][200];
	static int c1, c2, c3;
	static int t1, t2, t3;
	
	static class Valor
	{
		int x;
		int y;
		int z;
		int numero;
		
		public Valor(int i, int j, int k, int nn)
		{
			x = i;
			y = j;
			z = k;
			numero = nn;
		}
	}

	static LinkedList <Valor> valores = new LinkedList <Valor> ();
	
	static void agregar(int i, int j, int k, Valor padre)
	{
		if(!visitados[i][j][k])
		{
			visitados[i][j][k] = true;
			valores.add(new Valor(i, j, k, padre.numero + 1));
		}
	}
	
	static int iniciar(int i1, int i2, int i3)
	{
		for(int ii = 0; ii <= c1; ii++)
			for(int jj = 0; jj <= c2; jj++)
				for(int kk = 0; kk <= c3; kk++)
					visitados[ii][jj][kk] = false;
		valores.clear();
		valores.add(new Valor(i1, i2, i3, 0));
		while(!valores.isEmpty())
		{
			Valor siguiente = valores.poll();
			visitados[siguiente.x][siguiente.y][siguiente.z] = true;
			if(t1 == siguiente.x && t2 == siguiente.y && t3 == siguiente.z)
				return siguiente.numero;
			i1 = siguiente.x;
			i2 = siguiente.y;
			i3 = siguiente.z;
			int aPasar = Math.min(i1, c2 - i2);
			agregar(i1 - aPasar, i2 + aPasar, i3, siguiente);
			aPasar = Math.min(i1, c3 - i3);
			agregar(i1 - aPasar, i2, i3 + aPasar, siguiente);
			aPasar = Math.min(i2, c1 - i1);
			agregar(i1 + aPasar, i2 - aPasar, i3, siguiente);
			aPasar = Math.min(i2, c3 - i3);
			agregar(i1, i2 - aPasar, i3 + aPasar, siguiente);
			aPasar = Math.min(i3, c1 - i1);
			agregar(i1 + aPasar, i2, i3 - aPasar, siguiente);
			aPasar = Math.min(i3, c2 - i2);
			agregar(i1, i2 + aPasar, i3 - aPasar, siguiente);
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			c1 = sc.nextInt();
			if(c1 == 0)
				return;
			c2 = sc.nextInt();
			c3 = sc.nextInt();
			int i1 = sc.nextInt();
			int i2 = sc.nextInt();
			int i3 = sc.nextInt();
			t1 = sc.nextInt();
			t2 = sc.nextInt();
			t3 = sc.nextInt();
			System.out.println(iniciar(i1, i2, i3));
		}
	}

}
