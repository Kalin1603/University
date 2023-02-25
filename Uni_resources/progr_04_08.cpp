// Програмиране с езика C++
// Задача 4.8. Файл progr_04_08.cpp
#include <iostream>
using namespace std;
int main() {
  system("chcp 1251 > nul");
  long long pred, Last;
  int num = 1;
  cout << "Цяло число (за край - два пъти едно и също число): ";
  cin >> Last;
  do {
    pred = Last;
    cout << "Цяло число (за край - два пъти едно и също число): ";
    cin >> Last;
    ++num;
  } while (pred != Last);
  cout << "Брой прочетени: " << num << endl;
}
