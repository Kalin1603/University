using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;
using System.Net;
using Weather_Pokemon_API.Models;

namespace Weather_Pokemon_API.Controllers
{
    public class PokemonController : Controller
    {
        private readonly PokemonDbContext _pokemonDbContext;

        public PokemonController(PokemonDbContext pokemonDbContext)
        {
            _pokemonDbContext = pokemonDbContext;
        }

        public IActionResult Index(string pokemonName)
        {
            var url = $"https://pokeapi.co/api/v2/pokemon/{pokemonName}";
            var client = new WebClient();
            Pokemon pokemon = new Pokemon();

            if (!string.IsNullOrEmpty(pokemonName))
            {
                try
                {
                    var json = client.DownloadString(url);
                    Console.WriteLine(json);
                    JObject data = JObject.Parse(json);

                    pokemon.Name = data["name"].ToString();
                    pokemon.Height = (double)data["height"];
                    pokemon.Weight = (double)data["weight"];
                    pokemon.Image = data["sprites"]["front_default"].ToString();

                    _pokemonDbContext.Add(pokemon);
                    _pokemonDbContext.SaveChanges();

                    ViewData["pokemon"] = pokemon;
                }
                catch
                {
                    ViewData["error"] = "Покемонът не беше намерен.";
                }
            }
            return View(pokemon);
        }
    }
}
