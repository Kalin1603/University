using System.ComponentModel.DataAnnotations;

namespace VideoGameSystem.Models
{
    public class Publisher
    {
        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(50)]
        public string Country { get; set; }

        public ICollection<Game> Games { get; set; }
    }
}
