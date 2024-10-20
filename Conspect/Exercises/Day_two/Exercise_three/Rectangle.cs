using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_three
{
    internal class Rectangle : Shape
    {
        private double length;
        private double width;

        public Rectangle(double length, double width)
        {
            this.length = length;
            this.width = width;
        }

        public override double AreaCalculate()
        {
            return length * width;
        }

        public override void PrintArea()
        {
            Console.WriteLine($"Rectangle area is {AreaCalculate()}");
        }
    }
}
