// 1. Задача

/*
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

*/

// 2. Задача

/*

Console.Write("Enter numbers in the array: ");
int n = int.Parse(Console.ReadLine());

int[] arr = new int[n];
Random rnd = new Random();

for (int i = 0; i < n; i++)
{
    arr[i] = rnd.Next(10, 100);
    Console.Write(arr[i] + " \n");
}

Dictionary<int, int> numbersFrequency = new Dictionary<int, int>();
int mostFreqNum = arr[0];
int maxFreq = 0;

foreach (var num in arr)
{
    if (numbersFrequency.ContainsKey(num))
    {
        numbersFrequency[num]++;
    }
    else
    {
        numbersFrequency[num] = 1;
    }

    if (numbersFrequency[num] > maxFreq)
    {
        maxFreq = numbersFrequency[num];
        mostFreqNum = num;
    }
}

Console.WriteLine($"The most frequency number is {mostFreqNum} and meets {maxFreq} times.");
*/

// 3. Задача

/*

Console.Write("Enter the size of the matrix (n): ");
int n = int.Parse(Console.ReadLine());

int[,] matrix = new int[n, n];

Console.WriteLine("Enter the numbers for the matrix:");
for (int i = 0; i < n; i++)
{
    for (int j = 0; j < n; j++)
    {
        Console.Write($"Number for position ({i + 1},{j + 1}): ");
        matrix[i, j] = int.Parse(Console.ReadLine());
    }
}

int targetSum = 0;
for (int j = 0; j < n; j++)
{
    targetSum += matrix[0, j];
}

for (int i = 0; i < n; i++)
{
    int rowSum = 0;
    for (int j = 0; j < n; j++)
    {
        rowSum += matrix[i, j];
    }
    if (rowSum != targetSum)
    {
        Console.WriteLine("The matrix is not a magic square.");
        return;
    }
}

for (int j = 0; j < n; j++)
{
    int colSum = 0;
    for (int i = 0; i < n; i++)
    {
        colSum += matrix[i, j];
    }
    if (colSum != targetSum)
    {
        Console.WriteLine("The matrix is not a magic square.");
        return; 
    }
}

int mainDiagSum = 0;
for (int i = 0; i < n; i++)
{
    mainDiagSum += matrix[i, i];
}
if (mainDiagSum != targetSum)
{
    Console.WriteLine("The matrix is not a magic square.");
    return; 
}

int secDiagSum = 0;
for (int i = 0; i < n; i++)
{
    secDiagSum += matrix[i, n - i - 1];
}
if (secDiagSum != targetSum)
{
    Console.WriteLine("The matrix is not a magic square.");
    return; 
}

Console.WriteLine("The matrix is a magic square.");
*/