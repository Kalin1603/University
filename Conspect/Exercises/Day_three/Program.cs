using Day_three.Exercise_one;
using Day_three.Exercise_three;
using Day_three.Exercise_two;
using System.Text;

//Exercise one
/*
Book book = new Book(2019, "Nuton", "The Matrix");
BookFormat format = new BookFormat();
BookPrinter printer = new BookPrinter();

string bookFormatted = format.BookFormatter(book);
printer.BookPrinterInfo(bookFormatted);
*/

//Exercise two

/*
List<Product> products = new List<Product>
{
    new Product(20.22, "T-Shirt", "Clothes"),
    new Product(5.12, "Keyboard", "PC"),
    new Product(30.99, "Monitor", "PC"),
    new Product(50.00, "Cup", "Accessories")
};

IFilterPrice filterPrice = new ProductFilterPrice();

List<Product> filteredProducts = filterPrice.ProductFilterPrice(products);

foreach (var product in filteredProducts)
{
    Console.WriteLine($"{product.Name} - {product.Price} - {product.Category}");
}
*/

//Exercise three

/*
Car car = new Car(true, "A5", "Audi", 4, 500);
Car car2 = new Car(true, "E202", "Mercedes", 4, 200);

Truck truck = new Truck(true, 120, 240, 4, 1000);
Truck truck2 = new Truck(true, 230, 700, 2, 700);

Bus bus = new Bus(4, true, 100);
Bus bus2 = new Bus(2, true, 120);

car.Drive();
truck2.Drive();
truck2.Stop();

FleetManager manager = new FleetManager ();
manager.AddVehicle(car);
manager.AddVehicle(car2);
manager.AddVehicle(truck);
manager.AddVehicle(truck2);
manager.AddVehicle(bus);
manager.AddVehicle(bus2);

manager.GetVehicles();
*/