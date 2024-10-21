using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_two
{
    internal class ProductFilterName : IFilterName
    {
        List<Product> IFilterName.ProductFilterName(List<Product> products, string name)
        {
            return products.OrderByDescending(p => p.Name).ToList();
        }
    }
}
