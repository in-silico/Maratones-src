import java.util.Scanner;

public class F
{
	static long menorDiferencia;
	static int tamSegundo;
	static int tamPrimero;
	
	public static void escogerSegundo(String acum, String posibles, int tam, long primero)
	{		
		if(tam == 0)
			menorDiferencia = Math.min(Math.abs(Long.parseLong(acum) - primero), menorDiferencia);
		else
		{
			int i = -1;
			for(char c : posibles.toCharArray())
			{
				i++;
				if(c == '0' && tam == tamSegundo && tamSegundo != 1)
					continue;
				escogerSegundo(acum + c, posibles.substring(0, i) + posibles.substring(i + 1, posibles.length()), tam - 1, primero);
			}
		}
	}
	
	public static void escogerPrimero(String acum, String posibles, int tam)
	{
		if(tam == 0)
			escogerSegundo("", posibles, tamSegundo, Long.parseLong(acum));
		else
		{
			int i = -1;
			for(char c : posibles.toCharArray())
			{
				i++;
				if(c == '0' && tam == tamPrimero && tamPrimero != 1)
					continue;
				escogerPrimero(acum + c, posibles.substring(0, i) + posibles.substring(i + 1, posibles.length()), tam - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++)
		{
			String s = sc.nextLine().replace(" ", "");
			if(s.length() % 2 == 0)
			{
				tamSegundo = s.length() / 2;
				tamPrimero = s.length() / 2;
			}
			else
			{
				tamSegundo = s.length() / 2;
				tamPrimero = s.length() / 2 + 1;
			}
			menorDiferencia = Long.MAX_VALUE;
			escogerPrimero("", s, tamPrimero);
			System.out.println(menorDiferencia);
		}
	}
}
