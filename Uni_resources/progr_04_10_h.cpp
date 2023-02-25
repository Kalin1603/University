// Програмиране с езика C++
// Задача 4.10. Файл progr_04_10_h.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  double next, max1, max2;
  cout << "Число (0 за край): ";
  cin >> max1;
  next = max2 = max1;
  while (next) {
    cout << "Число (0 за край): ";
    cin >> next;
    if (max1 < next) {
      max2 = max1;
      max1 = next;
    }
    else if (max2 < next && next < max1 || max2 == max1) max2 = next;
  }
  if (max1 == max2) cout << "Единствено число: " << max1 << endl;
  else cout << "Най-големи различни числа: " << max1 << " > " << max2 << endl;
}
