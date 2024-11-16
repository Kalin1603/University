using Microsoft.AspNetCore.Identity;

namespace VideoGameSystem.Models
{
    public class ApplicationUser : IdentityUser
    {
        public string FirstName { get; set; }

        public string LastName { get; set; }

        public int Age { get; set; }

        public string Address { get; set; }

        public DateTime DateOfBirth { get; set; }
    }
}
