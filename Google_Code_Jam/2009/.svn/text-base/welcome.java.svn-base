package GoogleCode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class welcome 
{
	static final char[] welcome = "welcome to code jam".toCharArray();
	static long nactual = 0;
	public static void main(String [] args) throws IOException
	{
		Scanner sc = new Scanner(new File("a.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("a.out"));
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++)
		{
			nactual = 0;
			char[] actual = sc.nextLine().toCharArray();
			int[][] dinamica = new int [welcome.length][actual.length];
			dinamica[0][0] = actual[0] == 'w' ? 1 : 0;
			for(int j = 1; j < actual.length; j++)
			{
				dinamica[0][j] = dinamica[0][j - 1];
				dinamica[0][j] += actual[j] == 'w' ? 1 : 0;
			}
			for(int j = 1; j < welcome.length; j++)
			{
				dinamica[j][0] = 0;
			}
			for(int j = 1; j < actual.length; j++)
			{
				for(int k = 0; k < actual.length; k++)
				{
					try
					{
						dinamica[j][k] = dinamica[j][k - 1];
						dinamica[j][k] += welcome[j] == actual[k] ? dinamica[j - 1][k - 1] : 0;
						dinamica[j][k] %= 10000;
					}
					catch(Exception e)
					{	
					}
				}
			}
			nactual = dinamica[welcome.length - 1][actual.length - 1];
			bw.write("Case #" + (i + 1) + ": " + ((nactual % 10000) < 10 ? "000" + (nactual % 10000) : (nactual % 10000) < 100 ? "00" + (nactual % 10000) : (nactual % 10000) < 1000 ? "0" + (nactual % 10000) : (nactual % 10000)));
			bw.write(System.getProperty("line.separator"));
		}
		bw.close();
	}
	

}
