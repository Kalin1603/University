using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_six
{
    internal class Book : Item, IBorrowable
    {
        private string title;
        private string author;
        private int isbn;
        private bool isAvailable;

        public bool IsAvailable
        {
            get { return isAvailable; }
            set { isAvailable = value; }
        }


        public Book(int iSBN, string author, string title, bool isAvailable = true)
        {
            this.ISBN = iSBN;
            this.Author = author;
            this.Title = title;
            this.IsAvailable = isAvailable;
        }

        public int ISBN
        {
            get { return isbn; }
            set { isbn = value; }
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

        public void Borrow()
        {
            if (IsAvailable)
            {
                this.IsAvailable = false;
                Console.WriteLine($"The book {this.Title} has been borrowed.");
            }

            else
            {
                Console.WriteLine($"The book {this.Title} is unavailable.");
            }
        }

        public override string GetDetails()
        {
            return $"The book {this.Title}, Author {this.Author} with ISBN {this.ISBN}";
        }
    }
}
