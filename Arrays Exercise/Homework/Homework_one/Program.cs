// 1. Задача

int N;
do
{
    Console.Write("Enter number N: ");
    N = int.Parse(Console.ReadLine());
} while (!(N <= 0 || N < 20));

double[] array = new double[N];
double sum = 0;

for (int i = 0; i < N; i++)
{
    Console.Write($"Enter number in the array {i + 1}: ");
    array[i] = double.Parse(Console.ReadLine());
    sum += array[i];
}

Console.WriteLine($"Sum of the first {N} elements is: {sum}");