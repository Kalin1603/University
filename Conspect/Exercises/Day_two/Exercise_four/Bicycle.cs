using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_four
{
    internal class Bicycle : IMovable
    {
        public bool isMoving { get; set; }

        public void Move()
        {
            if (isMoving == true)
            {
                Console.WriteLine("The bicycle is moving.");
            }
        }
    }
}
