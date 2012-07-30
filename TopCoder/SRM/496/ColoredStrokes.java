
public class ColoredStrokes 
{
	
	char[][] pict;
	int height; 
	int width;
	
	public int getLeast(String[] picture)
	{
		height = picture.length;
		pict = new char[picture.length][];
		for(int i = 0; i < height; i++)
			pict[i] = picture[i].toCharArray();
		width = pict[0].length;
		int count = 0;
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				if(pict[i][j] == 'B' || pict[i][j] == 'G')
				{
					count++;
					visitBlue(i, j);
				}
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++)
				if(pict[i][j] == 'R')
				{
					count++;
					visitRed(i, j);
				}
		return count;
	}

	private void visitBlue(int i, int j) 
	{
		if(pict[i][j] == 'B')
			pict[i][j] = '.';
		else if(pict[i][j] == 'G')
			pict[i][j] = 'R';
		else
			return;
		if(i != 0)
			visitBlue(i - 1, j);
		if(i != height - 1)
			visitBlue(i + 1, j);
	}
	
	private void visitRed(int i, int j) 
	{
		if(pict[i][j] == 'R')
			pict[i][j] = '.';
		else
			return;
		if(j != 0)
			visitRed(i, j - 1);
		if(j != width - 1)
			visitRed(i, j + 1);
	}
	
	public static void main(String[] args)
	{
		new ColoredStrokes().getLeast(new String[]{"...B..",
 ".BRGRR",
 ".B.B.."});
	}
}

