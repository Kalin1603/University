using Microsoft.AspNetCore.Identity;
using VideoGameSystem.Models;

namespace VideoGameSystem.Data
{
    public class ApplicationDbInitializer
    {
        public static async Task Initialize(IServiceProvider serviceProvider, UserManager<ApplicationUser> userManager)
        {
            var roleManager = serviceProvider.GetRequiredService<RoleManager<IdentityRole>>();

            string[] roleNames = { "Admin", "User" };
            foreach (var roleName in roleNames)
            {
                var roleExist = await roleManager.RoleExistsAsync(roleName);
                if (!roleExist)
                {
                    await roleManager.CreateAsync(new IdentityRole(roleName));
                }
            }

            var adminUser = await userManager.FindByEmailAsync("admin@example.com");
            if (adminUser == null)
            {
                adminUser = new ApplicationUser
                {
                    UserName = "admin@example.com",
                    Email = "admin@example.com",
                    FirstName = "Admin",
                    LastName = "User",
                    Age = 30,
                    DateOfBirth = DateTime.Now.AddYears(-30),
                    Address = "Admin Address"
                };
                var result = await userManager.CreateAsync(adminUser, "Admin@123");

                if (result.Succeeded)
                {
                    await userManager.AddToRoleAsync(adminUser, "Admin");
                }
            }

            var normalUser = await userManager.FindByEmailAsync("user@example.com");
            if (normalUser == null)
            {
                normalUser = new ApplicationUser
                {
                    UserName = "user@example.com",
                    Email = "user@example.com",
                    FirstName = "Normal",
                    LastName = "User",
                    Age = 25,
                    DateOfBirth = DateTime.Now.AddYears(-25),
                    Address = "User Address"
                };

                var result = await userManager.CreateAsync(normalUser, "User@123");

                if (result.Succeeded)
                {
                    await userManager.AddToRoleAsync(normalUser, "User");
                }
            }
        }
    }
}
