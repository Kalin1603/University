// Програмиране с езика C++
// Задача 4.3. Файл progr_04_03.cpp
#include <iostream>
using namespace std;
#include <iomanip>
int main() {
  system("chcp 1251 > nul");

  int x, y, z;
  do {
    cout << "Броеве: x y z (15 >= x > y > z > 0): ";
    cin >> x >> y >> z;
    //} while ( ! (15 >= x && x > y && y > z && z > 0) );
  } while (15 < x || x <= y || y <= z || z <= 0);

  // 1-о решение
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << endl;
  for (int w1 = x, w2 = y, w3 = z, w4 = 1, w4_2 = 1, w4_3 = 1; w1 > 0;) {
      cout.fill(' ');
      cout << setw(1 + x - w1) << left << '.';
    cout.fill('#');
    cout << setw(w1--) << '#';
      cout.fill('v');
      cout << setw(w2) << "";
      w2 > 0 ? --w2 : w4_2 = 0;
    cout.fill(':');
    cout << setw(w3) << "";
    w3 > 0 ? --w3 : w4_3 = 0;
      cout.fill(' ');
      cout << setw(w4) << right << '.' << endl;
      w4 += w4_2 + w4_3;
  }
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << "\n\n";

  // 2-о решение (разликата е само в начина на промяна на w1, w2, w3 и w4)
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << endl;
  for (int w1 = x, w2 = y, w3 = z, w4 = 1; w1 > 0; --w1, --w2, --w3) {
    cout.fill(' ');
    cout << setw(1 + x - w1) << left << '.';
    cout.fill('#');
    cout << setw(w1) << '#';
    if (w2 > 0) {
      cout.fill('v');
      cout << setw(w2) << 'v';
    }
    if (w3 > 0) {
      cout.fill(':');
      cout << setw(w3) << ':';
    }
    cout.fill(' ');
    cout << setw(w4) << right << '.' << endl;
    w4 += (w2 > 0) + (w3 > 0);
  }
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << "\n\n";

  // 3-о решение
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << endl;
  for (int w1 = x, w2 = y, w3 = z, w4 = 1, w4Old; w1 > 0;) {
    cout.fill(' ');
    cout << setw(1 + x - w1) << left << '.';
    cout.fill('#');
    cout << setw(w1--) << '#';
    w4Old = w4;
    w4 += (w2 > 0) + (w3 > 0);
    if (w2 > 0) {
      cout.fill('v');
      cout << setw(w2--) << 'v';
    }
    if (w3 > 0) {
      cout.fill(':');
      cout << setw(w3--) << ':';
    }
    cout.fill(' ');
    cout << setw(w4Old) << right << '.' << endl;
  }
  cout.fill('.');
  cout << setw(x + y + z + 2) << '.' << "\n\n";

}
