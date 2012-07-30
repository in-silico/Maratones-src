import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class A 
{
	static class Figura
	{
		ArrayList <Figura> internas = new ArrayList<Figura>();
		long alto = -1;
		long ancho = -1;
		
		public static Figura parsear(LinkedList <Character> actuales)
		{
			Figura nueva = new Figura();
			actuales.pollFirst();
			while(actuales.peekFirst() == '(')
				nueva.internas.add(parsear(actuales));
			actuales.pollFirst();
			return nueva;
		}
		
		public static Figura primera(LinkedList <Character> actuales)
		{
			Figura nueva = new Figura();
			while(!actuales.isEmpty() && actuales.peekFirst() == '(')
				nueva.internas.add(parsear(actuales));
			nueva.llenarAA();
			return nueva;
		}
		
		public void llenarAA()
		{
			for(Figura a : internas)
				a.llenarAA();
			if(internas.isEmpty())
			{
				alto = 1;
				ancho = 1;
				return;
			}
			long ancho = internas.get(0).ancho;
			long alto = internas.get(0).alto;
			for(int i = 1; i < internas.size(); i++)
			{
				ancho += 1 + internas.get(i).ancho;
				alto = Math.max(alto, internas.get(i).alto);
			}
			this.alto = alto + 1;
			this.ancho = ancho + 2;
		}
		
		public long calcularAreaNegra(boolean negro)
		{
			if(negro)
			{
				long area = alto * ancho;
				for(Figura a : internas)
				{
					area -= a.alto * a.ancho;
					area += a.calcularAreaNegra(!negro);
				}
				return area;
			}
			else
			{
				long area = 0;
				for(Figura a : internas)
				{
					area += a.calcularAreaNegra(!negro);
				}
				return area;
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		for(int i = 0; i < t; i++)
		{
			br.readLine();
			char[] caracteresP = br.readLine().toCharArray();
			LinkedList <Character> lista = new LinkedList <Character> ();
			for(char c : caracteresP)
				lista.add(c);
			Figura nueva = Figura.primera(lista);
			System.out.println(nueva.calcularAreaNegra(false));
		}
	}
}
