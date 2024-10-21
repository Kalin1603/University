using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_three
{
    internal class FleetManager : IManager
    {
        private readonly List<IVehicle> _vehicles = new List<IVehicle>();

        public void AddVehicle(IVehicle vehicle)
        {
            _vehicles.Add(vehicle);
        }

        public List<IVehicle> GetVehicles()
        {
            foreach (var vehicle in _vehicles)
            {
                if (vehicle is Car car)
                {
                    Console.WriteLine($"Car: {car.Brand} {car.Model} has {car.DoorNumber} doors and max speed is {car.MaxSpeed}");
                }

                else if (vehicle is Truck truck)
                {
                    Console.WriteLine($"Truck capacity: {truck.Capacity}, length {truck.BoxLength} and width {truck.BoxWidth}, max speed is {truck.MaxSpeed}");
                }

                else if (vehicle is Bus bus)
                {
                    Console.WriteLine($"Bus has {bus.SeatCount} seats and max speed {bus.MaxSpeed}");
                }
            }
            return _vehicles;
        }
    }
}
