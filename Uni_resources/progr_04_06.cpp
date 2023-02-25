// Програмиране с езика C++
// Задача 4.6. Файл progr_04_06.cpp
#include <iostream>
using namespace std;
#include <ctime>
int main() {
  system("chcp 1251 > nul");
  srand((unsigned)time(NULL));
  for (int n = 1; n <= 10; ++n)
    cout << rand() << "  ";
  cout << "\n------------\n";
  for (int n = 1; n <= 10; ++n)
    cout << rand() % 20 << "  ";
  cout << "\n------------\n";
  for (int n = 1; n <= 10; ++n)
    cout << rand() % 21 - 10 << "  ";
  cout << "\n------------\n";
  for (int n = 1; n <= 10; ++n)
    cout << rand() % 11 * 2 - 10 << "  ";
  cout << "\n------------\n";
}
