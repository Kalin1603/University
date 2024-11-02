using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;
using Weather_Pokemon_API.Models;

namespace Weather_Pokemon_API.Controllers
{
    public class WeatherController : Controller
    {
        private readonly WeatherDbContext _weatherDbContext;

        public WeatherController(WeatherDbContext weatherDbContext)
        {
            _weatherDbContext = weatherDbContext;
        }

        public IActionResult Index(string city)
        {
            string apiKey = "81d714e701ffc7b1464fb30405cef137";

            var url = $"https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={apiKey}";
            var client = new WebClient();

            Weather weather = new Weather();

            if (!string.IsNullOrEmpty(city))
            {
                try
                {
                    var json = client.DownloadString(url);
                    JObject data = JObject.Parse(json);

                        weather.City = data["name"].ToString();
                        weather.Temperature = (double)data["main"]["temp"];
                        weather.Description = data["weather"][0]["description"].ToString();

                    _weatherDbContext.Add(weather);
                    _weatherDbContext.SaveChanges();

                    ViewData["weather"] = weather;
                }
                catch (WebException ex)
                {
                    ViewData["error"] = "Грешка при заявката към API-то";
                }
            }

            return View(weather);
        }
    }
}
