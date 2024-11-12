using Microsoft.EntityFrameworkCore;

namespace AnonymousVotingSystem.Models
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

        public DbSet<User> Users { get; set; }
        public DbSet<Vote> Votes { get; set; }
        public DbSet<TrackCode> TrackCodes { get; set; }
    }
}
