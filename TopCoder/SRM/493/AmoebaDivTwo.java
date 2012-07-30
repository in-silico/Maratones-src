
public class AmoebaDivTwo 
{
	public int count(String[] table, int K)
	{
		int tamI = table.length;
		int tamJ = table[0].length();
		boolean[][] tabla = new boolean[tamI][tamJ];
		for(int i = 0; i < tamI; i++)
			for(int j = 0; j < tamJ; j++)
				tabla[i][j] = table[i].charAt(j) == 'A';
		if(K == 1)
		{
			int count = 0;
			for(int i = 0; i < tamI; i++)
				for(int j = 0; j < tamJ; j++)
					if(tabla[i][j])
						count++;
			return count;
		}
		int cuenta = 0;
		for(int i = 0; i < tamI; i++)
			for(int j = 0; j < tamJ; j++)
			{
				boolean termino = false;
				for(int k = 0; k < K; k++)
					if(j + k >= tamJ || !tabla[i][j + k])
					{
						termino = true;
						break;
					}
				if(!termino)
					cuenta++;
			}
		for(int i = 0; i < tamI; i++)
			for(int j = 0; j < tamJ; j++)
			{
				boolean termino = false;
				for(int k = 0; k < K; k++)
					if( i + k >= tamI || !tabla[i + k][j])
					{
						termino = true;
						break;
					}
				if(!termino)
					cuenta++;
			}
		return cuenta;
	}
}
