// Програмиране с езика C++
// Задача 4.11. Файл progr_04_11_h.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  double next = 0.0, Last = 1.0 / next;
  int Len = 0, maxLen = 0;
  do {
    cout << "Число (0 за край): ";
    cin >> next;
    if (next > Last) ++Len;
    else { // започва нова строго възходяща част от редицата въвеждани числа
      if (maxLen < Len) maxLen = Len;
      Len = 1;
    }
    Last = next;
  } while (next);
  cout << "Максимална дължина на строго растяща част: " << maxLen << endl;
}
