// Програмиране с езика C++
// Задача 4.4. Файл progr_04_04.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  double next, max;
  int numMax = 0;
  do {
    cout << "Число (0 за край): ";
    cin >> next;
    if (0 == numMax || max < next) {
      max = next;
      numMax = 1;
    }
    else if (max == next) ++numMax;
  } while (next);
  cout << "Максимум: " << max
       << "\nБрой въвеждания на максимума: " << numMax << endl;
}
