using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_three.Exercise_three
{
    internal interface IManager
    {
        public void AddVehicle(IVehicle vehicle);
        public List<IVehicle> GetVehicles();
    }
}
