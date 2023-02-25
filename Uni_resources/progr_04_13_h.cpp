// Програмиране с езика C++
// Задача 4.13. Файл progr_04_13_h.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned) time(NULL));
  int numberOdd = 0;
  do {
    int next = rand() % 16 - 10;
    cout << next << "  ";
    if(next % 2) ++numberOdd;
  } while (numberOdd < 3);
  cout << "\n\n";
}
