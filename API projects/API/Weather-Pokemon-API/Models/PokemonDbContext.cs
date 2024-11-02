using Microsoft.EntityFrameworkCore;

namespace Weather_Pokemon_API.Models
{
    public class PokemonDbContext : DbContext
    {
        public PokemonDbContext(DbContextOptions<PokemonDbContext> options) : base(options)
        {

        }

        public DbSet<Pokemon> Pokemons { get; set; }
    }
}
