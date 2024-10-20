using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_two
{
    internal class Vehicle
    {
        public bool isEngineStarted { get; set; }
        public bool isEngineStopped { get; set; }

        public void StartEngine()
        {
            if (isEngineStarted == true)
            {
                Console.WriteLine("The vehicle engine is started.");
            }

            else
            {
                Console.WriteLine("The vehicle engine is not started.");
            }
        }

        public void StopEngine()
        {
            if (isEngineStopped == true)
            {
                Console.WriteLine("The vehicle engine has stopped.");
            }
            else
            {
                Console.WriteLine("The vehicle engine has not stopped.");
            }
        }
    }
}
