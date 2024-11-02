using Microsoft.EntityFrameworkCore;

namespace Weather_Pokemon_API.Models
{
    public class WeatherDbContext : DbContext
    {
        public WeatherDbContext(DbContextOptions<WeatherDbContext> options) : base(options) 
        {

        }

        public DbSet<Weather> Weathers { get; set; }
    }
}
