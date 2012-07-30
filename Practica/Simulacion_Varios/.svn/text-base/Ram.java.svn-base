import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Hashtable;


public class Ram 
{
	static class Variable
	{
		int nbytes;
		BigInteger valor;
		
		public Variable(int nb)
		{
			nbytes = nb;
		}
	}
	
	static Hashtable <String, Variable> variables = new Hashtable <String, Variable> ();
	static Variable[] variablesA = new Variable[201];
	static StringBuilder acum = new StringBuilder(64);
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			variables.clear();
			String linea = br.readLine();
			if(linea == null)
				return;
			String[] pedazos = linea.split(" ");
			int v = Integer.parseInt(pedazos[1]);
			for(int i = 0; i < v; i++)
			{
				String lineaF = br.readLine();
				int indice = lineaF.indexOf(' ');
				variablesA[i] = new Variable(Integer.parseInt(lineaF.substring(indice + 1)));
				variables.put(lineaF.substring(0, indice), variablesA[i]);
			}
			for(int j = 0; j < v; j++)
			{
				Variable var = variablesA[j];
				acum.setLength(0);
				for(int i = 0; i < var.nbytes; i++)
				{
					acum.append(br.readLine());
				}
				var.valor = new BigInteger(acum.toString(), 2);
			}
			int q = Integer.parseInt(br.readLine());
			for(int i = 0; i < q; i++)
			{
				String sActual = br.readLine();
				Variable actual = variables.get(sActual);
				if(actual == null)
				{
					System.out.println(sActual + "=");
				}
				else
				{
					System.out.println(sActual + "=" + actual.valor);
				}
			}
		}
	}
}
