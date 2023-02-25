// Програмиране с езика C++
// Задача 4.9. Файл progr_04_09_h.cpp
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  system("chcp 1251 > nul");
  int n;
  do {
    cout << "Брой от 3 до 15: ";
    cin >> n;
  } while (n < 3 || 15 < n);
  // 1-о решение
  for (int w1 = 1, w2 = n - 1, step = 1; w1 > 0; w1 += step, w2 -= 2 * step) {
    cout.fill(1 == w1 ? '#' : ' ');
    cout << endl << setw(w1) << '#';
    if (w2 > 0) cout << setw(w2) << '#';
    if (w2 <= 1) step = -step;
  }
  cout << endl;
  // 2-о решение
  for (int w1 = 1, w2 = n; w1 <= n; ++w1, --w2)
    if (w2 + 1 != w1) {
      cout.fill(1 == w1 || 1 == w2 ? '#' : ' ');
      cout << endl << setw(min(w1, w2)) << '#';
      if (w1 != w2) cout << setw(abs(w1 - w2)) << '#';
    }
  cout << endl;
}
