namespace Weather_Pokemon_API.Models
{
    public class Weather
    {
        public int Id { get; set; }

        public string City { get; set; }

        public double Temperature { get; set; }

        public string Description { get; set; }
    }
}
