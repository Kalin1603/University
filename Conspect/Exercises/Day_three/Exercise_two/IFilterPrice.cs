using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_two
{
    internal interface IFilterPrice
    {
        List<Product> ProductFilterPrice(List<Product> products);
    }
}
