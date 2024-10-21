using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_two
{
    internal class Product
    {
		private string name;
		private double price;
		private string category;

        public Product(double price, string name, string category)
        {
            this.Price=price;
            this.Name=name;
			this.Category=category;
        }

        public string Category
		{
			get { return category; }
			set { category = value; }
		}


        public double Price
		{
			get { return price; }
			set { price = value; }
		}


		public string Name
		{
			get { return name; }
			set { name = value; }
		}

	}
}
