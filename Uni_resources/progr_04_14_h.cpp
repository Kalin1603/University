// Програмиране с езика C++
// Задача 4.14. Файл progr_04_14_h.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  int numMin;
  do {
    cout << "Брой от 1 до 8: ";
    cin >> numMin;
  } while (numMin < 1 || 8 < numMin);
  int num = 0, next;
  do {
    cout << "Число (" << numMin << " нечетни за край): ";
    cin >> next;
    if (next % 2) ++num;
    else num = 0;
  } while (num < numMin);
  cout << "Край\n";
}