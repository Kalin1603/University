using System;

namespace Day_three.Exercise_one
{
    internal class Book
    {
        private string title;
        private string author;
        private int yearOfRelease;

        public Book(int yearOfRelease, string author, string title)
        {
            this.YearOfRelease = yearOfRelease;
            this.Author = author;
            this.Title = title;
        }

        public int YearOfRelease
        {
            get { return yearOfRelease; }
            set { yearOfRelease = value; }
        }

        public string Author
        {
            get { return author; }
            set { author = value; }
        }

        public string Title
        {
            get { return title; }
            set { title = value; }
        }
    }
}
