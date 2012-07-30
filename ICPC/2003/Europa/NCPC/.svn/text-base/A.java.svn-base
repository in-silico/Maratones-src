import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A 
{
	
	
	public static void agregar(int[] numeros, int numero)
	{
		if(numero == 0)
		{
			numeros[0]++;
			return;			        
		}
		while(numero != 0)
		{
			numeros[numero % 10]++;
			numero /= 10;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String linea1 = br.readLine();
			String linea2 = br.readLine();
			int nDirs = Integer.parseInt(linea2.split(" ")[0]);
			int procesadas = 0;
			int[] numeros = new int[10];
			while(procesadas != nDirs)
			{
				String lec = br.readLine();
				if(lec.charAt(0) == '+')
				{
					String[] pedazos = lec.split(" ");
					int a = Integer.parseInt(pedazos[1]);
					int b = Integer.parseInt(pedazos[2]);
					int d = Integer.parseInt(pedazos[3]);
					for(int j = a; j <= b; j += d)
					{
						agregar(numeros, j);
						procesadas++;
					}
				}
				else
				{
					agregar(numeros, Integer.parseInt(lec));
					procesadas++;
				}
			}
			System.out.println(linea1);
			System.out.println(linea2);
			int cuenta = 0;
			for(int j = 0; j < 10; j++)
			{
				System.out.println("Make " + numeros[j] + " digit " + j);
				cuenta += numeros[j];
			}
			if(cuenta == 1)
			{
				System.out.println("In total 1 digit");
			}
			else
			{
				System.out.println("In total " + cuenta + " digits");
			}
		}

	}

}
