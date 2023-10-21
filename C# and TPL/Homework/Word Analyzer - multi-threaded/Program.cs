using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        string filePath = @"D:\Uni-Repository\C# and TPL\Homework\Text\Aleko_Konstantinov_-_Baj_Ganxo_-_1763-b.txt";
        string text = File.ReadAllText(filePath, System.Text.Encoding.UTF8);

        string[] words = text.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

        List<string> validWords = new List<string>();

        foreach (string word in words)
        {
            string cleanWord = Regex.Replace(word, @"[^а-яА-Я]+", "");
            if (cleanWord.Length >= 3)
            {
                validWords.Add(cleanWord);
            }
        }

        var tasks = new List<Task>
        {
            Task.Run(() => CalculateWordCount(validWords)),
            Task.Run(() => CalculateShortestWord(validWords)),
            Task.Run(() => CalculateLongestWord(validWords)),
            Task.Run(() => CalculateAverageWordLength(validWords)),
            Task.Run(() => CalculateMostCommonWords(validWords, 5)),
            Task.Run(() => CalculateLeastCommonWords(validWords, 5)),
        };

        Task.WhenAll(tasks).Wait();
    }

    static void CalculateWordCount(List<string> validWords)
    {
        int numWords = 0;
        foreach (string word in validWords)
        {
            numWords++;
        }
        Console.WriteLine($"1. Number of words: {numWords}");
    }

    static void CalculateShortestWord(List<string> validWords)
    {
        string shortestWord = GetShortestWord(validWords);
        Console.WriteLine($"2. Shortest word: {shortestWord}");
    }

    static void CalculateLongestWord(List<string> validWords)
    {
        string longestWord = GetLongestWord(validWords);
        Console.WriteLine($"3. Longest word: {longestWord}");
    }

    static void CalculateAverageWordLength(List<string> validWords)
    {
        double avgWordLength = GetAverageWordLength(validWords);
        Console.WriteLine($"4. Average word length: {avgWordLength:F2}");
    }

    static void CalculateMostCommonWords(List<string> validWords, int count)
    {
        List<string> mostCommonWords = GetMostCommonWords(validWords, count);
        Console.WriteLine($"5. Five most common words: {string.Join(", ", mostCommonWords)}");
    }

    static void CalculateLeastCommonWords(List<string> validWords, int count)
    {
        List<string> leastCommonWords = GetLeastCommonWords(validWords, count);
        Console.WriteLine($"6. Five least common words: {string.Join(", ", leastCommonWords)}");
    }

    static int GetWordCount(string[] words)
    {
        return words.Length;
    }

    static string GetShortestWord(List<string> words)
    {
        string shortest = null;
        foreach (string word in words)
        {
            if (shortest == null || word.Length < shortest.Length)
            {
                shortest = word;
            }
        }
        return shortest;
    }

    static string GetLongestWord(List<string> words)
    {
        string longest = null;
        foreach (string word in words)
        {
            if (longest == null || word.Length > longest.Length)
            {
                longest = word;
            }
        }
        return longest;
    }

    static double GetAverageWordLength(List<string> words)
    {
        if (words.Count == 0)
            return 0;

        int totalLength = 0;
        foreach (string word in words)
        {
            totalLength += word.Length;
        }

        int wordCount = 0;
        foreach (string word in words)
        {
            if (word.Length >= 3)
            {
                wordCount++;
            }
        }

        return (double)totalLength / wordCount;
    }

    static List<string> GetMostCommonWords(List<string> words, int count)
    {
        Dictionary<string, int> wordCounts = new Dictionary<string, int>();
        foreach (string word in words)
        {
            if (wordCounts.ContainsKey(word))
            {
                wordCounts[word]++;
            }
            else
            {
                wordCounts[word] = 1;
            }
        }
        List<string> mostCommon = new List<string>();
        for (int i = 0; i < count; i++)
        {
            string mostCommonWord = null;
            int highestCount = 0;
            foreach (var pair in wordCounts)
            {
                if (pair.Value > highestCount)
                {
                    highestCount = pair.Value;
                    mostCommonWord = pair.Key;
                }
            }
            if (mostCommonWord != null)
            {
                mostCommon.Add(mostCommonWord);
                wordCounts.Remove(mostCommonWord);
            }
        }
        return mostCommon;
    }

    static List<string> GetLeastCommonWords(List<string> words, int count)
    {
        Dictionary<string, int> wordCounts = new Dictionary<string, int>();
        foreach (string word in words)
        {
            if (wordCounts.ContainsKey(word))
            {
                wordCounts[word]++;
            }
            else
            {
                wordCounts[word] = 1;
            }
        }
        List<string> leastCommon = new List<string>();
        for (int i = 0; i < count; i++)
        {
            string leastCommonWord = null;
            int lowestCount = int.MaxValue;
            foreach (var pair in wordCounts)
            {
                if (pair.Value < lowestCount)
                {
                    lowestCount = pair.Value;
                    leastCommonWord = pair.Key;
                }
            }
            if (leastCommonWord != null)
            {
                leastCommon.Add(leastCommonWord);
                wordCounts.Remove(leastCommonWord);
            }
        }
        return leastCommon;
    }
}

