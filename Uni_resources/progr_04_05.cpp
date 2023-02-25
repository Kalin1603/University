// Програмиране с езика C++
// Задача 4.5. Файл progr_04_05.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  double next, max;
  int numMax = 0;
  do {
    cout << "Число (0 за край): ";
    cin >> next;
    if(next)
      if (0 == numMax || max < next) {
        max = next;
        numMax = 1;
      }
      else if (max == next) ++numMax;
  } while (next);
  if(numMax)
    cout << " Максимум: " << max
         << "\n Брой максимални: " << numMax << endl;
  else cout << "Няма числа, различни от нула.\n";
}
