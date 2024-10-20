namespace Day_two.Exercise_one
{
    internal class Person
    {
		private string firstName;

        private string lastName;

        private int age;

        public Person(string firstName, string lastName, int age)
        {
            this.FirstName=firstName;
            this.LastName=lastName;
            this.Age=age;
        }

        public string FirstName
		{
			get { return firstName; }
			set { firstName = value; }
		}

		public string LastName
		{
			get { return lastName; }
			set { lastName = value; }
		}

		public int Age
		{
			get { return age; }
			set { age = value; }
		}

		public virtual void PrintInfo()
		{
			Console.Write($"{this.FirstName} {this.LastName} is {this.Age} ");
		}
	}
}
