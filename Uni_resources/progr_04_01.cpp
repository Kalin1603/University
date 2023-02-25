// Програмиране с езика C++
// Задача 4.1. Файл progr_04_01.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  int d, m, y;
  cout << "ден месец година: ";
  cin >> d >> m >> y;
  int number = d - 1;
  for (int k = 1; k < m; ++k)
    switch (k) {
      default: number += 31; break;
      case 4: case 6: case 9: case 11: number += 30; break;
      case 2: number += 28 + (y % 400 == 0 || y % 4 == 0 && y % 100 != 0);
    }
  cout << "Брой дни: " << number << endl;
  cout << "Брой дни: "
       << d - 1 + (m - 1) * 31 - (m > 4) - (m > 6) - (m > 9) - (12 == m)
          - (m > 2) * (y % 400 == 0 || y % 4 == 0 && y % 100 != 0 ? 2 : 3)
       << endl;
}
