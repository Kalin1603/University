using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_three
{
    internal class Car : IVehicle
    {
        private int doorNumber;
        private string brand;
        private string model;
        private bool isDriving;
        private int maxSpeed;


        public Car(bool isDriving, string model, string brand, int doorNumber, int maxSpeed)
        {
            this.IsDriving=isDriving;
            this.Model=model;
            this.Brand=brand;
            this.DoorNumber=doorNumber;
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


        public string Model
        {
            get { return model; }
            set { model = value; }
        }


        public string Brand
        {
            get { return brand; }
            set { brand = value; }
        }


        public int DoorNumber
        {
            get { return doorNumber; }
            set { doorNumber = value; }
        }

        public void Drive()
        {
            if (this.isDriving == false)
            {
                Console.WriteLine("You must start the car to drive!");
            }

            else
            {
                Console.WriteLine("You are driving the car!");       }
        }

        public void Stop()
        {
            if (this.IsDriving == true)
            {
                Console.WriteLine("You are still driving the car!");
            }

            else
            {
                Console.WriteLine("You stopped driving!");
            }
        }
    }
}
