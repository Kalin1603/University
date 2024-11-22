using System.ComponentModel.DataAnnotations;
using System.Configuration;

namespace VideoGameSystem.Models
{
    public class Genre
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(250)]
        public string Description { get; set; }

        [Required]
        [Range(2,18)]
        public int AgeRestriction { get; set; }

        public int PopularityRank { get; set; }

        public double AverageRating { get; set; }

        public ICollection<Game> Games { get; set; }
    }
}
