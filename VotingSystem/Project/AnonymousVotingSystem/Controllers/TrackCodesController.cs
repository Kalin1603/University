using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using AnonymousVotingSystem.Models;

namespace AnonymousVotingSystem.Controllers
{
    public class TrackCodesController : Controller
    {
        private readonly AppDbContext _context;

        public TrackCodesController(AppDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IActionResult TrackVote()
        {
            return View(); 
        }

        [HttpPost]
        public async Task<IActionResult> TrackVote(string code)
        {
            if (string.IsNullOrEmpty(code))
            {
                return NotFound();
            }

            var trackCode = _context.TrackCodes.FirstOrDefault(tc => tc.Code == code);
            if (trackCode != null)
            {
                var vote = _context.Votes.FirstOrDefault(v => v.Id == trackCode.VoteId);
                ViewBag.VoteOption = vote?.Option?? "Няма намерен избор за този код.";
            }
            else
            {
                ViewBag.ErrorMessage = "Невалиден код!";
            }

            return View("TrackCode");
        }

        // GET: TrackCodes/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var trackCode = await _context.TrackCodes
                .FirstOrDefaultAsync(m => m.Id == id);
            if (trackCode == null)
            {
                return NotFound();
            }

            return View(trackCode);
        }

        // GET: TrackCodes/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: TrackCodes/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,VoteId,Code")] TrackCode trackCode)
        {
            if (ModelState.IsValid)
            {
                _context.Add(trackCode);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(trackCode);
        }

        // GET: TrackCodes/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var trackCode = await _context.TrackCodes.FindAsync(id);
            if (trackCode == null)
            {
                return NotFound();
            }
            return View(trackCode);
        }

        // POST: TrackCodes/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,VoteId,Code")] TrackCode trackCode)
        {
            if (id != trackCode.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(trackCode);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!TrackCodeExists(trackCode.Id))
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
            return View(trackCode);
        }

        // GET: TrackCodes/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var trackCode = await _context.TrackCodes
                .FirstOrDefaultAsync(m => m.Id == id);
            if (trackCode == null)
            {
                return NotFound();
            }

            return View(trackCode);
        }

        // POST: TrackCodes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var trackCode = await _context.TrackCodes.FindAsync(id);
            if (trackCode != null)
            {
                _context.TrackCodes.Remove(trackCode);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool TrackCodeExists(int id)
        {
            return _context.TrackCodes.Any(e => e.Id == id);
        }
    }
}
