
public class Painting 
{
	char[][] destino, pintada;
	int height, width;
	
	public int largestBrush(String[] picture)
	{
		destino = new char[picture.length][];
		pintada = new char[picture.length][picture[0].length()];
		height = picture.length;
		width = picture[0].length();
		for(int i = 0; i < picture.length; i++)
		{
			destino[i] = picture[i].toCharArray();
		}
		int i = 2;
		for(; i <= 50; i++)
		{
			for(int j = 0; j < height; j++)
				for(int k = 0; k < width; k++)
					pintada[j][k] = 'W';
			for(int j = 0; j <= height - i; j++)
				for(int k = 0; k <= width - i; k++)
					if(lleno(j, k, i))
						pintar(j, k, i);
			if(!iguales())
				break;
		}
		return i - 1;
	}
	
	private boolean lleno(int jj, int kk, int ii) 
	{
		int heightE = jj + ii;
		int widthE = kk + ii;
		for(int i = jj; i < heightE; i++)
			for(int j = kk; j < widthE; j++)
				if(destino[i][j] != 'B')
					return false;
		return true;
	}
	

	private void pintar(int jj, int kk, int ii) 
	{
		int heightE = jj + ii;
		int widthE = kk + ii;
		for(int i = jj; i < heightE; i++)
			for(int j = kk; j < widthE; j++)
				pintada[i][j] = 'B';
	}

	
	private boolean iguales() {
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				if(pintada[i][j] != destino[i][j])
					return false;
		return true;
	}
}
