using Day_four;

Hotel hotel = new Hotel("Zora");

Guest guest = new Guest("123", "Kalin");
Guest guest2 = new Guest("321", "Georgi");

Room room1 = new Room(30.99, RoomType.Single, 10);
Room room2 = new Room(35.99, RoomType.Double, 20);

hotel.AddRoom(room1);
hotel.AddRoom(room2);

hotel.RegisterGuest(guest);
hotel.RegisterGuest(guest2);

// Kalin reserves room 10
guest.ReserveRom(room1);

// Displaying info
Console.WriteLine(guest.GetGuestInfo());
Console.WriteLine(room1.GetRoomInfo());
Console.WriteLine(room2.GetRoomInfo());

