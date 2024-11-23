using Humanizer.Localisation;
using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel;

namespace VideoGameSystem.Models
{
    public class Game
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Title { get; set; }

        [ForeignKey(nameof(Genre))]
        [DisplayName(nameof(Genre))]
        public int GenreId { get; set; }

        public Genre Genre { get; set; }

        [ForeignKey(nameof(Publisher))]
        [DisplayName(nameof(Publisher))]
        public int PublisherId { get; set; }

        public Publisher Publisher { get; set; }

        [Required]
        [Range(0.0, 1000.0)]
        public decimal Price { get; set; }

        [Required]
        [Range(1, 100)]
        public int Players { get; set; }

        [Required]
        public DateTime ReleaseDate { get; set; }

        public string ImageUrl { get; set; }
    }
}
