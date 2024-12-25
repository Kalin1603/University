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

//4. Задача
/*
var list = new DoublyLinkedList<int>();
list.Add(1);
list.Add(2);
list.Add(3);
list.AddAt(1, 5); 
list.Remove(2);   
Console.WriteLine(list.GetAt(1));
Console.WriteLine(string.Join(", ", list.ToArray())); 

public class DoublyLinkedList<T>
{
    private class Node
    {
        public T Value;
        public Node? Prev;
        public Node? Next;

        public Node(T value)
        {
            Value = value;
        }
    }

    private Node? head;
    private Node? tail;
    private int count;

    public void Add(T value)
    {
        var newNode = new Node(value);

        if (head == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail!.Next = newNode;
            newNode.Prev = tail;
            tail = newNode;
        }

        count++;
    }

    public bool Remove(T value)
    {
        var current = head;

        while (current != null)
        {
            if (current.Value!.Equals(value))
            {
                if (current.Prev != null)
                    current.Prev.Next = current.Next;
                else
                    head = current.Next;

                if (current.Next != null)
                    current.Next.Prev = current.Prev;
                else
                    tail = current.Prev;

                count--;
                return true;
            }

            current = current.Next;
        }

        return false;
    }

    public int IndexOf(T value)
    {
        var current = head;
        int index = 0;

        while (current != null)
        {
            if (current.Value!.Equals(value))
                return index;

            current = current.Next;
            index++;
        }

        return -1; 
    }

    public void AddAt(int index, T value)
    {
        if (index < 0 || index > count)
            throw new ArgumentOutOfRangeException(nameof(index));

        var newNode = new Node(value);

        if (index == 0)
        {
            if (head == null)
            {
                head = tail = newNode;
            }
            else
            {
                newNode.Next = head;
                head.Prev = newNode;
                head = newNode;
            }
        }
        else if (index == count)
        {
            Add(value); 
        }
        else
        {
            var current = head;
            for (int i = 0; i < index; i++)
                current = current!.Next;

            newNode.Prev = current!.Prev;
            newNode.Next = current;

            current.Prev!.Next = newNode;
            current.Prev = newNode;
        }

        count++;
    }

    public T GetAt(int index)
    {
        if (index < 0 || index >= count)
            throw new ArgumentOutOfRangeException(nameof(index));

        var current = head;
        for (int i = 0; i < index; i++)
            current = current!.Next;

        return current!.Value;
    }

    public T[] ToArray()
    {
        var array = new T[count];
        var current = head;
        int i = 0;

        while (current != null)
        {
            array[i++] = current.Value;
            current = current.Next;
        }

        return array;
    }

    public override string ToString()
    {
        var current = head;
        var result = "";

        while (current != null)
        {
            result += current.Value + " ";
            current = current.Next;
        }

        return result.Trim();
    }
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

//7. Задача
/*
string inputTree1 = "10,5,15,2,null,12,17";
string inputTree2 = "10,5,15,null,null,9,17";

Console.WriteLine(IsBinarySearchTree(ParseTreeFromInput(inputTree1)) ? "True" : "False");
Console.WriteLine(IsBinarySearchTree(ParseTreeFromInput(inputTree2)) ? "True" : "False");

TreeNode? ParseTreeFromInput(string input)
{
    var values = input.Split(',');
    if (values.Length == 0 || values[0] == "null") return null;

    var root = new TreeNode(int.Parse(values[0]));
    var queue = new Queue<TreeNode>();
    queue.Enqueue(root);
    int i = 1;

    while (queue.Count > 0 && i < values.Length)
    {
        var current = queue.Dequeue();

        if (i < values.Length && values[i] != "null")
        {
            current.Left = new TreeNode(int.Parse(values[i]));
            queue.Enqueue(current.Left);
        }
        i++;

        if (i < values.Length && values[i] != "null")
        {
            current.Right = new TreeNode(int.Parse(values[i]));
            queue.Enqueue(current.Right);
        }
        i++;
    }

    return root;
}

bool IsBinarySearchTree(TreeNode? root)
{
    return ValidateBinarySearchTree(root, null, null);
}

bool ValidateBinarySearchTree(TreeNode? node, int? min, int? max)
{
    if (node == null) return true;

    if ((min.HasValue && node.Value <= min.Value) || (max.HasValue && node.Value >= max.Value))
    {
        return false;
    }

    return ValidateBinarySearchTree(node.Left, min, node.Value) && ValidateBinarySearchTree(node.Right, node.Value, max);
}

public class TreeNode
{
    public int? Value { get; set; }
    public TreeNode? Left { get; set; }
    public TreeNode? Right { get; set; }

    public TreeNode(int? value)
    {
        Value = value;
    }
}
*/