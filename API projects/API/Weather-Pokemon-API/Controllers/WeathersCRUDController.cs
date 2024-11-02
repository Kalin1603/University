using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using Weather_Pokemon_API.Models;

namespace Weather_Pokemon_API.Controllers
{
    public class WeathersCRUDController : Controller
    {
        private readonly WeatherDbContext _context;

        public WeathersCRUDController(WeatherDbContext context)
        {
            _context = context;
        }

        // GET: WeathersCRUD
        public async Task<IActionResult> Index()
        {
              return _context.Weathers != null ? 
                          View(await _context.Weathers.ToListAsync()) :
                          Problem("Entity set 'WeatherDbContext.Weathers'  is null.");
        }

        // GET: WeathersCRUD/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Weathers == null)
            {
                return NotFound();
            }

            var weather = await _context.Weathers
                .FirstOrDefaultAsync(m => m.Id == id);
            if (weather == null)
            {
                return NotFound();
            }

            return View(weather);
        }

        // GET: WeathersCRUD/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: WeathersCRUD/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,City,Temperature,Description")] Weather weather)
        {
            if (ModelState.IsValid)
            {
                _context.Add(weather);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(weather);
        }

        // GET: WeathersCRUD/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Weathers == null)
            {
                return NotFound();
            }

            var weather = await _context.Weathers.FindAsync(id);
            if (weather == null)
            {
                return NotFound();
            }
            return View(weather);
        }

        // POST: WeathersCRUD/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,City,Temperature,Description")] Weather weather)
        {
            if (id != weather.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(weather);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!WeatherExists(weather.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(weather);
        }

        // GET: WeathersCRUD/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Weathers == null)
            {
                return NotFound();
            }

            var weather = await _context.Weathers
                .FirstOrDefaultAsync(m => m.Id == id);
            if (weather == null)
            {
                return NotFound();
            }

            return View(weather);
        }

        // POST: WeathersCRUD/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Weathers == null)
            {
                return Problem("Entity set 'WeatherDbContext.Weathers'  is null.");
            }
            var weather = await _context.Weathers.FindAsync(id);
            if (weather != null)
            {
                _context.Weathers.Remove(weather);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool WeatherExists(int id)
        {
          return (_context.Weathers?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
