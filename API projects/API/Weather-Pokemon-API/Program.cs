using Microsoft.EntityFrameworkCore;
using Weather_Pokemon_API.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

//First
var connectionString = builder.Configuration.GetConnectionString("DefaultConnectionString");
var connectionStringPokemons = builder.Configuration.GetConnectionString("DefaultConnectionStringPokemons");
builder.Services.AddDbContext<WeatherDbContext>(options => options.UseSqlServer(connectionString, x => x.MigrationsAssembly("Weather-Pokemon-API")));
builder.Services.AddDbContext<PokemonDbContext>(options => options.UseSqlServer(connectionStringPokemons, x => x.MigrationsAssembly("Weather-Pokemon-API")));

//Second
builder.Services.AddScoped<DbContext, WeatherDbContext>();
builder.Services.AddScoped<DbContext, PokemonDbContext>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
