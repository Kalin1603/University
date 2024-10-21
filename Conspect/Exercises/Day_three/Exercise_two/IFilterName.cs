using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_two
{
    internal interface IFilterName
    {
        List<Product> ProductFilterName(List<Product> products, string name);
    }
}
