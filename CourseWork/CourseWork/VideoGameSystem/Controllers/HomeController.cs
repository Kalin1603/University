using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using VideoGameSystem.Data;
using VideoGameSystem.Models;
using VideoGameSystem.ViewModels;

namespace VideoGameSystem.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly ApplicationDbContext _applicationDbContext;

        public HomeController(ILogger<HomeController> logger, ApplicationDbContext applicationDbContext)
        {
            _logger = logger;
            this._applicationDbContext = applicationDbContext;
        }

        public IActionResult Index()
        {
            var games = _applicationDbContext.Games
                        .Include(g => g.Genre)
                        .Include(g => g.Publisher)
                        .ToList();

            var model = new HomeViewModel
            {
                Games = games
            };

            return View(model);
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
