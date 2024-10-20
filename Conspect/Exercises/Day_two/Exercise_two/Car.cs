using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_two
{
    internal class Car : Vehicle
    {
		private string brand;
		private string model;
		private int horsePower;

        public Car(int horsePower, string model, string brand)
        {
            this.HorsePower=horsePower;
            this.Model=model;
            this.Brand=brand;
        }

        public int HorsePower
		{
			get { return horsePower; }
			set { horsePower = value; }
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

		public void Drive()
		{
            if (isEngineStarted)
            {
                Console.WriteLine($"The {this.Brand} {this.Model} with {this.HorsePower} horsepower is driving.");
            }

            else
            {
                Console.WriteLine($"Start the engine first.");
            }
        }
	}
}
