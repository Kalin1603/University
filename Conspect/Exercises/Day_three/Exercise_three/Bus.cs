using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_three
{
    internal class Bus : IVehicle
    {
        private int seatCont;
        private bool isDriving;
        private int maxSpeed;

        public Bus(int seatCount, bool isDriving, int maxSpeed)
        {
            this.SeatCount=seatCount;
            this.IsDriving=isDriving;
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

        public int SeatCount
        {
            get { return seatCont; }
            set { seatCont = value; }
        }

        public void Drive()
        {
            if (this.isDriving == false)
            {
                Console.WriteLine("You must start the bus to drive!");
            }

            else
            {
                Console.WriteLine("You are driving the bus!");
            }
        }

        public void Stop()
        {
            if (this.IsDriving == true)
            {
                Console.WriteLine("You are still driving the bus!");
            }

            else
            {
                Console.WriteLine("You stopped driving!");
            }
        }
    }
}
