using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_seven
{
    internal class Player
    {
		private string name;
		private int age;
		private string position;
		private int goalScored;

        public Player(string name, int age, string position, int goalScored = 0)
        {
			this.Name = name;
			this.Age = age;
			this.Position = position;
			this.GoalScored = goalScored;
        }

        public int GoalScored
		{
			get { return goalScored; }
			set { goalScored = value; }
		}


		public string Position
		{
			get { return position; }
			set 
			{
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("Add position.");
                }

                position = value;
			}
		}


		public int Age
		{
			get { return age; }
			set 
			{
                if (!(value >= 16 && value <= 40))
                {
					throw new ArgumentException("Age range must be between 16 and 40.");
                }

                age = value;
			}
		}


		public string Name
		{
			get { return name; }
			set
            {
                if (string.IsNullOrEmpty(value))
                {
					throw new ArgumentNullException("Add name.");
                }

                name = value;
            }
		}

		public void ScoreGoal()
		{
			this.goalScored++;
		}

		public string PlayerInfo()
		{
            return $"Player {this.Name} {this.Age} age, {this.Position} position has goal scored {this.GoalScored}";
		}
	}
}
