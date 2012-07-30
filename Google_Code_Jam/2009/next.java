package GoogleCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class next 
{

	public static void main(String [] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("b.in"));
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
		{
			long tiempoInicio = System.currentTimeMillis();
			BigInteger s;
			try
			{
				s = sc.nextBigInteger();
			}
			catch(Exception e)
			{
				System.out.println("Case #" + (i + 1) + ": X");
				sc.next();
				continue;
			}
			BigInteger s1 = s.add(BigInteger.ONE);
			ArrayList <Character> s3 = new ArrayList <Character> ();
			for(char z : (s.toString().replace("0", "").toCharArray()))
			{
				s3.add(z);
			}
			while(true)
			{
				ArrayList <Character> s2 = new ArrayList <Character> (s3.size());
				s2.addAll(s3);
				String nuevo = s1.toString().replace("0", "");
				boolean borro = true;
				for(Character s5 : nuevo.toCharArray())
				{
					borro = borro && s2.remove(s5);
				}
				if(borro && s2.isEmpty())
				{
					System.out.println("Case #" + (i + 1) + ": " + s1);
					break;
				}
				else
				{
					s1 = s1.add(BigInteger.ONE);
					if(System.currentTimeMillis() > tiempoInicio + 5000)
					{
						ArrayList <Character> s5 = new ArrayList <Character> ();
						for(char x : s.toString().toCharArray())
						{
							s5.add(x);
						}
						s5.add('0');
						Collections.sort(s5);
						for(int i1 = 0; i1 < s5.size(); i1++)
						{
							if(s5.get(i1) != '0')
							{
								s5.add(0, s5.remove(i1));
								break;
							}
						}
						String s22 = "";
						for(Character v : s5)
						{
							s22 += v;
						}
						System.out.println("Case #" + (i + 1) + ": " + s22);
						break;
					}
				}
			}
		}
	}
}
