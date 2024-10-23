using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;

namespace Api_one.Controllers
{
    public class WeatherController : Controller
    {
        public ActionResult Index(string city)
        {
            string apiKey = "81d714e701ffc7b1464fb30405cef137";

            var url = $"https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={apiKey}";
            var client = new WebClient();
            var body = "";

            if (!string.IsNullOrEmpty(city))
            {
                try
                {
                    body = client.DownloadString(url);
                    JObject data = JObject.Parse(body);

                    if (data["cod"].ToString() == "200")
                    {
                        ViewData["city"] = data["name"];
                        ViewData["temperature"] = data["main"]["temp"];
                        ViewData["description"] = data["weather"][0]["description"];
                    }
                    else
                    {
                        ViewData["error"] = "Градът не е намерен. Моля, опитайте отново.";
                    }
                }
                catch (WebException ex)
                {
                    ViewData["error"] = "Грешка при заявката към API-то. Моля, опитайте по-късно.";
                }
            }

            ViewData["body"] = body;
            return View();
        }
    }
}
