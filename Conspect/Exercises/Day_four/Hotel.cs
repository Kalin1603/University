using System;
using System.Collections.Generic;
using System.Linq;

namespace Day_four
{
    public class Hotel
    {
        private string name;
        private List<Room> rooms = new List<Room>();
        private List<Guest> guests = new List<Guest>();

        public Hotel(string name)
        {
            this.Name = name;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public void AddRoom(Room room)
        {
            rooms.Add(room);
        }

        public void RegisterGuest(Guest guest)
        {
            if (guests.Any(g => g.GuestId == guest.GuestId))
            {
                throw new Exception("There is already a guest with this Id");
            }

            guests.Add(guest);
            Console.WriteLine($"Guest {guest.Name} is registered in {this.Name} successfully!");
        }

        public List<Room> GetAvailableRooms()
        {
            return rooms.Where(room => room.IsAvailable).ToList();
        }

        public List<Guest> GetAllGuests()
        {
            return guests;
        }
    }
}
