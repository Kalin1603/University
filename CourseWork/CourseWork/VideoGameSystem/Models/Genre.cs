using System.ComponentModel.DataAnnotations;

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

        public ICollection<Game> Games { get; set; }
    }
}
