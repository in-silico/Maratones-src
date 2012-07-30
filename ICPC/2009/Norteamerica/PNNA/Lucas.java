import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;


public class Lucas
{
	static LinkedHashSet <Integer> entradas = new LinkedHashSet <Integer> (100007);
	static LinkedHashSet <Integer> entradasNuevas = new LinkedHashSet <Integer> (100007);
	static ArrayList <Integer> enOrden = new ArrayList <Integer> (100007);

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String nuevo = br.readLine();
			if(nuevo.equals("0"))
				return;
			entradas.clear();
			int tamano = nuevo.length();
			int mascara = (1 << tamano) - 1;
			int i = 0;
			for(char c : nuevo.toCharArray())
				entradas.add((c - '0') << tamano | 1 << i++);
			int valorAnterior = 0;
			while(true)
			{
				entradasNuevas.clear();
				int a = 0;
				for(int e : entradas)
				{
					if(a < valorAnterior)
					{
						a++;
						continue;
					}
					int b = 0;
					int faltan = tamano - Integer.bitCount(e & mascara);
					for(int n : entradas)
					{
						if(b++ == a)
							break;
						if(Integer.bitCount(n & mascara) - 1 > faltan)
							break;
						if(((e & mascara) & (n & mascara)) == 0)
						{
							int ambos = (e & mascara) | (n & mascara); 
							int eNum = e >> tamano;
							int nNum = n >> tamano;
							int u = ((eNum + nNum) << tamano) | ambos;
							if(!entradas.contains(u))
								entradasNuevas.add(u);
							u = ((eNum - nNum) << tamano) | ambos;
							if(!entradas.contains(u))
								entradasNuevas.add(u);
							u = ((nNum - eNum) << tamano) | ambos;
							if(!entradas.contains(u))
								entradasNuevas.add(u);
							u = ((nNum * eNum) << tamano) | ambos;
							if(!entradas.contains(u))
								entradasNuevas.add(u);
							if(eNum != 0)
							{
								u = ((nNum / eNum) << tamano) | ambos;
								if(!entradas.contains(u))
									entradasNuevas.add(u);
							}
							if(nNum != 0)
							{
								u = ((eNum / nNum) << tamano) | ambos;
								if(!entradas.contains(u))
									entradasNuevas.add(u);
							}
						}
					}
					a++;
				}
				valorAnterior = entradas.size();
				for(Integer in : entradasNuevas)
					entradas.add(in);
				if(valorAnterior == entradas.size())
					break;
			}
			enOrden.clear();
			for(int in : entradas)
			{
				if((in & mascara) == mascara)
					enOrden.add(in >> tamano);
			}
			Collections.sort(enOrden);
			int num = 0;
			for(int a : enOrden)
			{
				if(a < 1)
					continue;
				if(a == num)
					continue;
				if(a != num + 1)
					break;
				else
					num++;
			}
			System.out.println(++num);
		}
	}
}
