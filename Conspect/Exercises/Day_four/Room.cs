using System;

namespace Day_four
{
    public class Room
    {
        private int roomNumber;
        private RoomType roomType;
        private bool isAvailable;
        private double pricePerNight;

        public Room(double pricePerNight, RoomType roomType, int roomNumber)
        {
            this.PricePerNight = pricePerNight;
            this.RoomType = roomType;
            this.RoomNumber = roomNumber;
            this.IsAvailable = true; // Стаята по подразбиране е налична
        }

        public double PricePerNight
        {
            get { return pricePerNight; }
            set { pricePerNight = value; }
        }

        public bool IsAvailable
        {
            get { return isAvailable; }
            set { isAvailable = value; }
        }

        public RoomType RoomType
        {
            get { return roomType; }
            set { roomType = value; }
        }

        public int RoomNumber
        {
            get { return roomNumber; }
            set { roomNumber = value; }
        }

        public string GetRoomInfo()
        {
            return $"Room: {this.RoomNumber}, Type: {this.RoomType} is {this.IsAvailable} with price per night {this.PricePerNight}";
        }

        public void Reserve()
        {
            if (!this.IsAvailable)
            {
                throw new Exception("The room is already reserved and is not available!");
            }
            else
            {
                this.IsAvailable = false; // Стаята вече е заета
                Console.WriteLine($"You reserved {GetRoomInfo()} successfully!");
            }
        }

        public void Release()
        {
            if (!this.IsAvailable)
            {
                this.IsAvailable = true; // Освобождаваме стаята
                Console.WriteLine($"You released the {GetRoomInfo()} successfully!");
            }
            else
            {
                throw new Exception($"The {GetRoomInfo()} is still available.");
            }
        }
    }
}
