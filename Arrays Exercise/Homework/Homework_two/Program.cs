// 1. Задача

/*
Console.Write("Enter the size of the numbers: ");
int number = int.Parse(Console.ReadLine());

if (number == 9)
{
    double[] numbers = new double[9];

    Console.WriteLine("Enter 9 real numbers");

    for (int i = 0; i < numbers.Length; i++)
    {
        Console.Write($"Enter number {i + 1}: ");
        numbers[i] = double.Parse(Console.ReadLine());
        Console.WriteLine($"You entered number {numbers[i]}");
    }

    if (IsMonotonicallyIncreasing(numbers,0))
    {
        Console.WriteLine("The numbers are monotonically increasing");
    }

    else
    {
        Console.WriteLine("The numbers are not monotonically increasing");
    }
}

else
{
    Console.WriteLine("The size of the numbers must be 9.");
}

static bool IsMonotonicallyIncreasing(double[] numbers, int index)
{
    return index >= numbers.Length - 1 || (numbers[index] <= numbers[index + 1] && IsMonotonicallyIncreasing(numbers, index + 1));
}
*/

// 2. Задача

/*
Console.Write("Enter number between 10 and 100010: ");
int number = int.Parse(Console.ReadLine());

if (number >= 10 && number <= 100010)
{
    int nextNumber = number + 1;

    while (!IsInitialNumber(nextNumber))
    {
        nextNumber++;
    }
    Console.WriteLine($"The next initial number after number: {number} is {nextNumber}");

}

else
{
    Console.WriteLine("Enter number between the given range.");
}

static bool IsInitialNumber(int number)
{
    if (number <= 1)
    {
        return false;
    }

    else
    {
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}

*/

// 3. Задача

/*
Console.Write("Enter number between 10 and 100010: ");
int number = int.Parse(Console.ReadLine());

if (number >= 10 && number <= 100010)
{
    int sum = Sum(number);

    Console.WriteLine($"The digits sum of the number {number} is {sum}");
}

else
{
    Console.WriteLine("Enter number between the given range.");
}


static int Sum(int number)
{
    if (number == 0)
    {
        return 0;
    }

    else
    {
        return  number % 10 + Sum(number / 10); 
    }
}
*/