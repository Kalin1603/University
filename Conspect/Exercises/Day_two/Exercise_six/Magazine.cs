using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_six
{
    internal class Magazine : Item, IBorrowable
    {
        private string title;
        private int issue;
        private string date;
        private bool isAvailable;

        public bool IsAvailable
        {
            get { return isAvailable; }
            set { isAvailable = value; }
        }


        public Magazine(string date, int issue, string title, bool isAvailable = true)
        {
            this.Date=date;
            this.Issue=issue;
            this.Title=title;
            this.IsAvailable = isAvailable;
        }

        public string Date
        {
            get { return date; }
            set { date = value; }
        }


        public int Issue
        {
            get { return issue; }
            set { issue = value; }
        }


        public string Title
        {
            get { return title; }
            set { title = value; }
        }

        public void Borrow()
        {
            if (this.IsAvailable)
            {
                this.IsAvailable = false;
                Console.WriteLine($"The magazine {this.Title} has been borrowed.");
            }

            else
            {
                Console.WriteLine($"The magazine {this.Title} is unavailable.");
            }
        }

        public override string GetDetails()
        {
            return $"The magazine {this.Title}, Issue {this.Issue}, Date {this.Date}";
        }
    }
}
