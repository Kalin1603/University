﻿using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;
using Weather_Pokemon_API.Models;

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

            Weather weather = new Weather();

            if (!string.IsNullOrEmpty(city))
            {
                try
                {
                    body = client.DownloadString(url);
                    JObject data = JObject.Parse(body);

                    if (data["cod"].ToString() == "200")
                    {
                        weather.City = data["name"].ToString();
                        weather.Temperature = (double)data["main"]["temp"];
                        weather.Description = data["weather"][0]["description"].ToString();


                        ViewData["weather"] = weather;
                    }
                    else
                    {
                        ViewData["error"] = "Градът не е намерен.";
                    }
                }
                catch (WebException ex)
                {
                    ViewData["error"] = "Грешка при заявката към API-то";
                }
            }

            ViewData["body"] = body;
            return View(weather);
        }
    }
}