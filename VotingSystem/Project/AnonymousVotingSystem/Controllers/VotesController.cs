using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using AnonymousVotingSystem.Models;
using Microsoft.AspNetCore.Http.HttpResults;

namespace AnonymousVotingSystem.Controllers
{
    public class VotesController : Controller
    {
        private readonly AppDbContext _context;

        public VotesController(AppDbContext context)
        {
            _context = context;
        }

        // GET: Votes
        public async Task<IActionResult> Index()
        {
            return View(await _context.Votes.ToListAsync());
        }

        [HttpPost]
        public async Task<IActionResult> SubmitVote(string option)
        {
            if (string.IsNullOrEmpty(option))
            {
                ModelState.AddModelError(string.Empty, "Моля, изберете опция за гласуване.");
                return View("Index");
            }

            var vote = new Vote();
            vote.Option = option;
            await _context.Votes.AddAsync(vote);
            await _context.SaveChangesAsync();

            var trackCode = new TrackCode();
            trackCode.VoteId = vote.Id;
            trackCode.Code = Guid.NewGuid().ToString();
            await _context.TrackCodes.AddAsync(trackCode);
            await _context.SaveChangesAsync();

            // Добавяме както кода за проследяване, така и самия избор
            ViewBag.TrackCode = trackCode.Code;
            ViewBag.Option = vote.Option; // Пращаме и избора на потребителя

            return View("VoteResult");
        }

        // GET: Votes/AllVotes
        public async Task<IActionResult> AllVotes()
        {
            var votesWithCodes = await _context.Votes
                .Include(v => v.TrackCode)
                .ToListAsync();

            return View(votesWithCodes);
        }

        // GET: Votes/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var vote = await _context.Votes
                .FirstOrDefaultAsync(m => m.Id == id);
            if (vote == null)
            {
                return NotFound();
            }

            return View(vote);
        }

        // GET: Votes/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Votes/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,UserId,Option,TrackCode")] Vote vote)
        {
            if (ModelState.IsValid)
            {
                _context.Add(vote);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(vote);
        }

        // GET: Votes/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var vote = await _context.Votes.FindAsync(id);
            if (vote == null)
            {
                return NotFound();
            }
            return View(vote);
        }

        // POST: Votes/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,UserId,Option,TrackCode")] Vote vote)
        {
            if (id != vote.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(vote);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!VoteExists(vote.Id))
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
            return View(vote);
        }

        // GET: Votes/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var vote = await _context.Votes
                .FirstOrDefaultAsync(m => m.Id == id);
            if (vote == null)
            {
                return NotFound();
            }

            return View(vote);
        }

        // POST: Votes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var vote = await _context.Votes.FindAsync(id);
            if (vote != null)
            {
                _context.Votes.Remove(vote);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool VoteExists(int id)
        {
            return _context.Votes.Any(e => e.Id == id);
        }
    }
}
