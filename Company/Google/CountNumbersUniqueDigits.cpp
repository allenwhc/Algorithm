#include <iostream>
using namespace std;

int countNumbersWithUniqueDigits(int n) {
	if (n<=0) return 0;
	int res = 1;
	long base = 9;
	for (int i=0; i<n; i++)
	{	
		res += base;
		base *= (10-i-1);
	}
	return res;
}

int main(int argc, char const *argv[])
{
	int n = 13;
	cout << countNumbersWithUniqueDigits(n) << endl;
	return 0;
}