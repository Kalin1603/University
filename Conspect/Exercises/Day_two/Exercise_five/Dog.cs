using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_five
{
    internal class Dog : Animal
    {
        public override void Sound()
        {
            base.Sound();
            Console.WriteLine("Woof");
        }
    }
}
