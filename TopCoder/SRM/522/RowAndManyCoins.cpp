#include <string>

using namespace std;

class RowAndManyCoins{
	public:
	string getWinner(string cells){
		if(cells[0] == 'A' || cells[cells.size()-1]== 'A')
			return "Alice";
		else
			return "Bob";
	}
};
