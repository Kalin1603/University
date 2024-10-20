using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Channels;
using System.Threading.Tasks;

namespace Day_two.Exercise_five
{
    internal class Animal
    {
        public virtual void Sound()
        {
            Console.Write("The animal is making sound ");
        }
    }
}
