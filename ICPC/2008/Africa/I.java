import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class I 
{
	
	
	static int numeroCuadrante(long x, long y, long lado)
	{
		if(lado == 1)
			return 1;
		if(lado == 2)
		{
			if(x == 1 && y == 1)
				return -1;
			else
				return 1;
		}
		long ladoMedios = lado / 2;
		if(x >= ladoMedios && y >= ladoMedios)
		{
			return -numeroCuadrante(x % ladoMedios, y % ladoMedios, ladoMedios);
		}
		else
		{
			return numeroCuadrante(x % ladoMedios, y % ladoMedios, ladoMedios);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			if(n == -1 && r == -1 && s == -1 && e == -1)
				return;
			n = 1L << (n);
			long cuenta = 0;
			for(long i = s; i <= e; i++)
				cuenta += numeroCuadrante(r, i, n);
			System.out.println(cuenta);
		}
	}

}
