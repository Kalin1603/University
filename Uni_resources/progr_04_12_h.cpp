// Програмиране с езика C++
// Задача 4.12. Файл progr_04_12_h.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  int const numberMax = 100;
  int numberOdd = 0, numberEven = 0, numberAll = 0;
  do {
    int next = rand() % 5 - 5;
    cout << next << "  ";
    ++numberAll;
    next % 2 ? ++numberOdd : ++numberEven;
  } while (numberAll < numberMax && numberOdd != numberEven);
  cout << "\n\n  Брой нечетни: " << numberOdd << "\n  Брой четни: "
       << numberEven << endl;
}
