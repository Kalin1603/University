using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_two
{
    internal class ProductFilterCategory : IFilterCategory
    {
        List<Product> IFilterCategory.ProductFilterCategory(List<Product> product)
        {
            return product.OrderByDescending(x => x.Category).ToList();
        }
    }
}
