import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B
{
	public static String convertirA(int numero)
	{
		switch(numero)
		{
			case 0: return "063";
			case 1: return "010";
			case 2: return "093";
			case 3: return "079";
			case 4: return "106";
			case 5: return "103";
			case 6: return "119";
			case 7: return "011";
			case 8: return "127";
			case 9: return "107";
		}
		return null;
	}
	
	public static int convertirDe(String s)
	{
		if(s.equals("063"))
			return 0;
		if(s.equals("010"))
			return 1;
		if(s.equals("093"))
			return 2;
		if(s.equals("079"))
			return 3;
		if(s.equals("106"))
			return 4;
		if(s.equals("103"))
			return 5;
		if(s.equals("119"))
			return 6;
		if(s.equals("011"))
			return 7;
		if(s.equals("127"))
			return 8;
		if(s.equals("107"))
			return 9;
		throw(new RuntimeException());
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String siguiente = br.readLine();
			String este = siguiente;
			if(siguiente.equals("BYE"))
				return;
			String[] numeros = siguiente.split("\\+");
			numeros[1] = numeros[1].substring(0, numeros[1].length() - 1);
			String numeroUno = "";
			while(numeros[0].length() != 0)
			{
				numeroUno += convertirDe(numeros[0].substring(0, 3));
				numeros[0] = numeros[0].substring(3);
			}
			String numeroDos = "";
			while(numeros[1].length() != 0)
			{
				numeroDos += convertirDe(numeros[1].substring(0, 3));
				numeros[1] = numeros[1].substring(3);
			}
			int resultado = Integer.parseInt(numeroUno) + Integer.parseInt(numeroDos);
			String res = "";
			while(resultado != 0)
			{
				res = convertirA(resultado % 10) + res;
				resultado /= 10;
			}
			System.out.println(este + res);
		}
	}
	
}
