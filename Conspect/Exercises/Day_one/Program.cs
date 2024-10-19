//Exercise one

/*
Console.Write("Enter number: ");
int number = int.Parse(Console.ReadLine());

int squareNumber = number * number;
Console.WriteLine($"The number squared is: {squareNumber}");
*/

//Exercise two

/*
Console.Write("Enter number: ");
int number = int.Parse(Console.ReadLine());

if (number % 2 == 0)
{
    Console.WriteLine($"The number {number} is positive");
}
else
{
    Console.WriteLine($"The number {number} is negative");
}
*/

//Exercise three

/*
Console.Write("Enter year: ");
int year = int.Parse(Console.ReadLine());

if (year % 400 == 0)
{
    Console.WriteLine($"The year {year} is jumped up");
}

else if (year % 100 == 0)
{
    Console.WriteLine($"The year {year} is not jumped up");
}

else if(year % 4 == 0)
{
    Console.WriteLine($"The year {year} is jumped up");
}

else
{
    Console.WriteLine($"The year {year} is not jumped up");
}
*/

//Exercise four

/*
Console.Write("Enter number one: ");
int numberOne = int.Parse(Console.ReadLine());
Console.Write("Enter number two: ");
int numberTwo = int.Parse(Console.ReadLine());
Console.Write("Enter operation: ");
string operation = Console.ReadLine();

switch (operation)
{
    case "+":
        if (operation == "+")
        {
            int sum = numberOne + numberTwo;
            Console.WriteLine($"The sum is {sum}");
        }
        break;
    case "-":
        if (operation == "-")
        {
            int difference = numberOne - numberTwo;
            Console.WriteLine($"The difference is {difference}");
        }
        break;
    case "/":
        if (operation == "/")
        {
            int divisible = numberOne / numberTwo;
            Console.WriteLine($"The divisible is {divisible}");
        }
        break;
    case "*":
        if (operation == "*")
        {
            int multiply = numberOne * numberTwo;
            Console.WriteLine($"The multiply is {multiply}");
        }
        break;
    case "%":
        if (operation == "%")
        {
            int remainderNumber = numberOne % numberTwo;
            Console.WriteLine($"The remainder number is {remainderNumber}");
        }
        break;
    default:
        break;
}
*/

//Exercise five

/*
Console.Write("Enter string one: ");
string one = Console.ReadLine();
Console.Write("Enter string two: ");
string two = Console.ReadLine();

if (one.Length > two.Length)
{
    Console.WriteLine($"String {one} has larger length");
}

else if (one.Length < two.Length)
{
    Console.WriteLine($"String {two} has larger length");
}

else
{
    Console.WriteLine($"String {one} and string {two} have equal length");
}
*/

//Exercise six

/*
Console.Write("Enter number: ");
int number = int.Parse(Console.ReadLine());
int factorial = 1;
if (number > 0)
{
    for (int i = 1; i <= number; i++)
    {
        factorial *= i;
    }
    Console.WriteLine($"The factorial number is {factorial}.");
}
else
{
    Console.WriteLine("Cant accept negative numbers for factorial!");
}
*/

//Exercise seventh

/*
Console.Write("Enter minutes: ");
int minutes = int.Parse(Console.ReadLine());
int oneHour = 60;

int remainingMinutes = minutes % oneHour;
int hours = minutes / oneHour;

Console.WriteLine($"{minutes} minutes is {hours} hours and {remainingMinutes} minutes");
*/

//Exercise eight

/*
Console.Write("Enter number: ");
int number = int.Parse(Console.ReadLine());

if (number == 1)
{
    Console.WriteLine($"The number {number} is not initial number.");
}

else
{
    for (int i = 2; i <= number; i++)
    {
        if (number % i == 1)
        {
            Console.WriteLine($"The number {number} is initial number.");
            break;
        }

        else if (number % i == 0)
        {
            Console.WriteLine($"The number {number} is initial number.");
            break;
        }

        else
        {
            Console.WriteLine($"The number {number} is not initial number.");
            break;
        }
    }
}
*/

/*
Console.Write("Enter number: ");
int number = int.Parse(Console.ReadLine());
Console.Write("Add exponent: ");
int exponent = int.Parse(Console.ReadLine());

int result = 1;

for (int i = 1; i <= exponent; i++)
{
    result *= number;
}

Console.WriteLine($"The exponented number is {result}");
*/