using System.Linq;


namespace Day_three.Exercise_two
{
    internal class ProductFilterPrice : IFilterPrice
    {
        List<Product> IFilterPrice.ProductFilterPrice(List<Product> products)
        {
            return products.OrderBy(p => p.Price).ToList();
        }
    }
}
