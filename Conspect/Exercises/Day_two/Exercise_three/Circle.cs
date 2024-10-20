using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_three
{
    internal class Circle : Shape
    {
        private double radius;

        public Circle(double radius)
        {
            this.radius = radius;
        }

        public override double AreaCalculate()
        {
            return Math.PI * radius * radius;
        }

        public override void PrintArea()
        {
            Console.WriteLine($"Circle area is {AreaCalculate()}");
        }
    }
}
