using System;
using System.Collections.Generic;

namespace Day_four
{
    public class Guest
    {
        private string name;
        private string guestId;
        private List<Room> reservedRooms = new List<Room>();

        public Guest(string guestId, string name)
        {
            this.GuestId = guestId;
            this.Name = name;
        }

        public string GuestId
        {
            get { return guestId; }
            set { guestId = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public void ReserveRom(Room room)
        {
            if (room.IsAvailable)
            {
                room.Reserve(); // Резервираме стаята
                reservedRooms.Add(room); // Добавяме стаята в списъка на резервираните стаи
                Console.WriteLine($"The room {room.RoomNumber} is reserved by {this.Name}!");
            }
            else
            {
                Console.WriteLine("You cannot reserve this room, because it is not available!");
            }
        }

        public void ReleaseRoom(Room room)
        {
            reservedRooms.Remove(room);
        }

        public string GetGuestInfo()
        {
            return reservedRooms.Count == 0
                ? $"Guest {this.Name}, Id {this.GuestId} has reserved No rooms reserved!"
                : $"Guest {this.Name}, Id {this.GuestId} has reserved {string.Join(", ", reservedRooms)}!";
        }
    }
}
