using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;

public class PokemonController : Controller
{
    public IActionResult Index(string pokemonName)
    {
        if (!string.IsNullOrEmpty(pokemonName))
        {
            var url = $"https://pokeapi.co/api/v2/pokemon/{pokemonName.ToLower()}";

            using (var client = new WebClient())
            {
                try
                {
                    var json = client.DownloadString(url);
                    JObject data = JObject.Parse(json);

                    ViewData["name"] = data["name"];
                    ViewData["height"] = data["height"];
                    ViewData["weight"] = data["weight"];
                    ViewData["image"] = data["sprites"]["front_default"];
                }
                catch
                {
                    ViewData["error"] = "Покемонът не беше намерен.";
                }
            }
        }

        return View();
    }
}
