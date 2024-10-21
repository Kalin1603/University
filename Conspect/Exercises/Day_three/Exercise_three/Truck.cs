using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_three
{
    internal class Truck : IVehicle
    {
        private int capacity;
        private int boxWidth;
        private int boxLength;
        private bool isDriving;
        private int maxSpeed;

        public Truck(bool isDriving, int boxLength, int boxWidth, int capacity, int maxSpeed)
        {
            this.IsDriving=isDriving;
            this.BoxLength=boxLength;
            this.BoxWidth=boxWidth;
            this.Capacity=capacity;
            this.MaxSpeed=maxSpeed;
        }
        public int MaxSpeed
        {
            get { return maxSpeed; }
            set { maxSpeed = value; }
        }

        public bool IsDriving
        {
            get { return isDriving; }
            set { isDriving = value; }
        }


        public int BoxLength
        {
            get { return boxLength; }
            set { boxLength = value; }
        }


        public int BoxWidth
        {
            get { return boxWidth; }
            set { boxWidth = value; }
        }


        public int Capacity
        {
            get { return capacity; }
            set { capacity = value; }
        }

        public void Drive()
        {
            if (this.isDriving == false)
            {
                Console.WriteLine("You must start the truck to drive!");
            }

            else
            {
                Console.WriteLine("You are driving the truck!");
            }
        }

        public void Stop()
        {
            if (this.IsDriving == true)
            {
                Console.WriteLine("You are still driving the truck!");
            }

            else
            {
                Console.WriteLine("You stopped driving!");
            }
        }
    }
}
