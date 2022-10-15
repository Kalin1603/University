//Console.WriteLine("Enter numbers");
//List<int> evenNums = new List<int>();
//int a = int.Parse(Console.ReadLine());
//int b = int.Parse(Console.ReadLine());
//int c = int.Parse(Console.ReadLine());
//int oddNum = int.Parse(Console.ReadLine());
//evenNums.Add(a);
//evenNums.Add(b);
//evenNums.Add(c);

//foreach (var num in evenNums)
//{
//    if (a != oddNum)
//    {
//        Console.WriteLine(num);
//    }
//}


int[] a = new int[100];
int[] b = new int[100];
int i = 0;
int k = 1;
bool flag = false;
do
{
    Console.Write("a[" + (i + 1) + "] = ");
    a[i] = int.Parse(Console.ReadLine());
    if (a[i] % 2 != 0)
    {
        b[k - 1] = a[i];
        if (k >= 2)
        {
            for (int j = 0; j < k - 1; j++)
            {
                if (b[j] != 0)
                {
                    if (b[j] != b[j + 1])
                    {
                        flag = true;
                        break;
                    }
                }
            }
        }

        k++;
    }
    i++;

} while (flag == false);
foreach (var item in a)
{
    if (item % 2 == 0 && item != 0)
    {
        Console.WriteLine(item);
    }
}
Console.ReadKey();
