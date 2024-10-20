namespace Day_two.Exercise_one
{
    internal class Student : Person
    {
        private double grade;

        public Student(string firstName, string lastName, int age, double grade) : base(firstName, lastName, age)
        {
            this.Grade = grade;
        }

        public double Grade
        {
            get { return grade; }
            set { grade = value; }
        }

        public override void PrintInfo()
        {
            base.PrintInfo();
            Console.Write($"with grade {this.Grade}");
        }
    }
}
