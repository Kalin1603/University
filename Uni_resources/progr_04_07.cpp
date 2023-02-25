// Програмиране с езика C++
// Задача 4.7. Файл progr_04_07.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand(time(NULL));
  int pred, Last = -1, number = 0;
  do {
    pred = Last;
    Last = rand() % 11 + 10;
    cout << Last << "  ";
    number += Last % 3 == 0;
    //if (Last % 3 == 0) ++number; // може така вместо горния ред
  } while ( pred % 3 != Last % 3 );
  cout << "\n  Брой кратни на три: " << number << endl;
}
