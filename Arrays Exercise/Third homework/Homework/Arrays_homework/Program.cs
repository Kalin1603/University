//1. Задача
/*
List<int> list1 = new List<int> { 1, 2, 3, 4, 5 };
List<int> list2 = new List<int> { 3, 4, 5, 6, 7 };

List<int> union = Union(list1, list2);
Console.WriteLine("Обединение:");
Console.WriteLine(string.Join(", ", union));

List<int> intersection = Intersection(list1, list2);
Console.WriteLine("Сечение:");
Console.WriteLine(string.Join(", ", intersection));

static List<int> Union(List<int> list1, List<int> list2)

{
    List<int> result = new List<int>();

    foreach (int item in list1)
    {
        if (!result.Contains(item))
        {
            result.Add(item);
        }
    }

    foreach (int item in list2)
    {
        if (!result.Contains(item))
        {
            result.Add(item);
        }
    }

    return result;
}

static List<int> Intersection(List<int> list1, List<int> list2)
{
    List<int> result = new List<int>();

    foreach (int item in list1)
    {
        if (list2.Contains(item) && !result.Contains(item))
        {
            result.Add(item);
        }
    }

    return result;
}
*/

//2. Задача
/*
List<int> numbers = new List<int> { 1, 1, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5 };

var result = FindLongestEqualSubsequence(numbers);

Console.Write("The longest subsequence of even numbers: ");
Console.WriteLine(string.Join(",", result));

static List<int> FindLongestEqualSubsequence(List<int> numbers)
{
    if (numbers.Count == 0)
    {
        return new List<int>();
    }

    int currentCount = 1;      
    int maxCount = 1;          
    int bestNumber = numbers[0]; 

    for (int i = 1; i < numbers.Count; i++)
    {
        if (numbers[i] == numbers[i - 1]) 
        {
            currentCount++; 
        }
        else
        {
            if (currentCount > maxCount)
            {
                maxCount = currentCount;
                bestNumber = numbers[i - 1];
            }

            currentCount = 1; 
        }
    }

    if (currentCount > maxCount)
    {
        maxCount = currentCount;
        bestNumber = numbers[numbers.Count - 1];
    }

    List<int> result = new List<int>();
    for (int i = 0; i < maxCount; i++)
    {
        result.Add(bestNumber);
    }

    return result;
}
*/

//3. Задача
/*
List<int> numbers = new List<int> { -5, 3, -1, 2, -8, 7, 0, -2 };

var result = RemoveNegatives(numbers);

Console.Write("The list without the negative numbers: ");
Console.WriteLine(string.Join(", ", result));


static List<int> RemoveNegatives(List<int> numbers)
{
    numbers.RemoveAll(n => n < 0);
    return numbers;
}
*/

//5. Задача
/*
int[] arr = { 1, 2, 4, 11, 12, 8 };
int num = 2;

int maxNum = FindMaxNum(arr, num);

Console.WriteLine($"Max value for num is: {maxNum}");

static int FindMaxNum(int[] arr, int num)
{
    foreach (int value in arr)
    {
        if (value == num)
        {
            num *= 2;
        }
    }

    return num;
}
*/

//6. Задача
/*
char[,] canvas = {
            { 'a', 'a', 'b', 'b', 'a' },
            { 'a', 'a', 'b', 'b', 'a' },
            { 'a', 'a', 'a', 'c', 'b' }
        };

int result = CountRegions(canvas);
Console.WriteLine($"Different blocks: {result}");

static int CountRegions(char[,] canvas)
{
    int rows = canvas.GetLength(0);
    int cols = canvas.GetLength(1);
    int count = 0;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            if (canvas[i, j] != '0')
            {
                char currentSymbol = canvas[i, j];
                MarkRegion(canvas, i, j, currentSymbol);
                count++;
            }
        }
    }

    return count;
}

static void MarkRegion(char[,] canvas, int row, int col, char symbol)
{
    int rows = canvas.GetLength(0);
    int cols = canvas.GetLength(1);

    if (row < 0 || row >= rows || col < 0 || col >= cols || canvas[row, col] != symbol)
    {
        return;
    }

    canvas[row, col] = '0';

    MarkRegion(canvas, row - 1, col, symbol);
    MarkRegion(canvas, row + 1, col, symbol);
    MarkRegion(canvas, row, col - 1, symbol);
    MarkRegion(canvas, row, col + 1, symbol);
}
*/