using System;

namespace Day_three.Exercise_one
{
    internal class BookFormat
    {
        public string BookFormatter(Book book)
        {
            return $"The book '{book.Title}', written by {book.Author}, was released in {book.YearOfRelease}.";
        }
    }
}
