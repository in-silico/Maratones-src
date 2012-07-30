#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int const linesize = 72;
int const buffsize = 2 * 1024 * 1024;

int fmt(char *src, int isize, char *dest)
{
	int osize = 0;
	for (int first = 0, last = first; first < isize; first = last)
	{
		for (int next = last, nonblank = 0, word = 0; last < isize; last = next)
		{
			for (; next < isize && src[next] != ' ' && src[next] != '\n'; ++next)
			{
				++nonblank;
			}
			++word;
			if (next < isize && src[next] == '\n' && (src[next + 1] == ' ' || src[next+1] == '\n' || nonblank == 0 || next + 1 == isize))
			{
				last = next + 1;
				break;
			}
			if (next - first > linesize)
			{
				for (last = word > 1 ? last : next + 1; src[last] == ' '; ++last);
				src[last-1] = '\n';
				break;
			}
			src[next++] = ' ';
		}
		copy(src + first, src + last, dest + osize);
		osize += last - first;
		if (dest[osize - 1] == '\n')
		{
			for (; osize > 1 && dest[osize-2] == ' '; --osize);
			dest[osize-1] = '\n';
		}
	}
	return osize;
}

int main(int argc, char *argv[])
{
	char src[buffsize];
	char dest[buffsize];
	cin.read(src, buffsize);
	int isize = cin.gcount();
	int osize = fmt(src, isize, dest);
	cout.write(dest, osize);
	return 0;
}
