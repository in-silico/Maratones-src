import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map.Entry;


public class plague
{
	
	static class Configuration
	{
		Hashtable <String, Integer> proteinas = new Hashtable <String, Integer> (1000);
		
		public boolean comparar(Configuration cura)
		{
			int cuenta = 0;
			for(Entry <String, Integer> p : proteinas.entrySet())
			{
				cuenta++;
				if(!cura.proteinas.containsKey(p.getKey()) || p.getValue().intValue() != cura.proteinas.get(p.getKey()).intValue())
					return false;
			}
			return cuenta == cura.proteinas.size();
		}
		
		public boolean mutar(Hashtable <String, String> mutaciones)
		{
			Hashtable <String, Integer> proteinasNuevas = new Hashtable <String, Integer> (1000);
			boolean muto = false;
			for(Entry <String, String> e : mutaciones.entrySet())
			{
				if(proteinas.containsKey(e.getKey()))
				{
					muto = true;
					if(proteinasNuevas.containsKey(e.getValue()))
						proteinasNuevas.put(e.getValue(), proteinasNuevas.get(e.getValue()) + proteinas.get(e.getKey()));
					else
						proteinasNuevas.put(e.getValue(), proteinas.get(e.getKey()));
				}
			}
			for(Entry <String, Integer> e : proteinas.entrySet())
			{
				if(!mutaciones.containsKey(e.getKey()))
				{
					if(proteinasNuevas.containsKey(e.getKey()))
						proteinasNuevas.put(e.getKey(), proteinasNuevas.get(e.getKey()) + proteinas.get(e.getKey()));
					else
						proteinasNuevas.put(e.getKey(), proteinas.get(e.getKey()));
				}
			}
			proteinas = proteinasNuevas;
			return muto;
		}
	}

	public static void main(String[] args) throws IOException
	{
		Integer a = 200;
		Integer b = 200;
		System.out.println(a == b);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String read = br.readLine();
			String [] readA = read.split(" ");
			int nm = Integer.parseInt(readA[0]);
			int ni = Integer.parseInt(readA[1]);
			int nc = Integer.parseInt(readA[2]);
			int n = Integer.parseInt(readA[3]);
			if(nm == 0 && ni == 0 && nc == 0 && n == 0)
				return;
			Hashtable <String, String> mutaciones = new Hashtable <String, String> (nm);
			boolean determinismo = true;
			for(int i = 0; i < nm; i++)
			{
				String [] readB = br.readLine().split(" ");
				String p = readB[0];
				String q = readB[1];
				if(mutaciones.containsKey(p) && !mutaciones.get(p).equals(q))
				{
					System.out.println("Protein mutations are not deterministic");
					determinismo = false;
				}
				else
				{
					mutaciones.put(p, q);
				}
			}
			Configuration doctor = new Configuration();
			for(int j = 0; j < ni; j++)
			{
				String [] readB = br.readLine().split(" ");
				String p = readB[0];
				int  i = Integer.parseInt(readB[1]);
				doctor.proteinas.put(p, i);
			}
			Configuration cura = new Configuration();
			for(int j = 0; j < nc; j++)
			{
				String [] readB = br.readLine().split(" ");
				String p = readB[0];
				int  i = Integer.parseInt(readB[1]);
				cura.proteinas.put(p, i);
			}
			if(!determinismo)
			{
				continue;
			}
			boolean terminoMal = false;
			int i = 0;
			for(i = 0; i <= n; i++)
			{
				if(doctor.comparar(cura))
					break;
				if(i == n)
				{
					terminoMal = true;
					break;
				}
				doctor.mutar(mutaciones);
			}
			if(terminoMal)
			{
				System.out.println("Nostalgia for Infinity is doomed");
			}
			else
			{
				System.out.println("Cure found in " + i + " mutation(s)");
			}
		}
	}
	

}