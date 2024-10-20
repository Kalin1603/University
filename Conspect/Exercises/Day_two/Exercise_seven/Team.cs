using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Day_two.Exercise_seven
{
    internal class Team
    {
		private string teamName;
		private List<Player> playerList = new List<Player>();

        public Team(string teamName)
        {
            this.TeamName = teamName;
        }

        public string TeamName
		{
			get { return teamName; }
			set { teamName = value; }
		}

		public string AddPlayer(Player player)
		{
            if (playerList.Any(p => p.Name == player.Name))
            {
				throw new ArgumentException("Cannot add duplicates!");
            }

            else
            {

                playerList.Add(player);
                return playerList.ToString();
            }
		}

		public string RemovePlayer(string playerName)
		{
            var playerToRemove = playerList.FirstOrDefault(p => p.Name == playerName);

            if (playerToRemove == null)
            {
                throw new KeyNotFoundException($"Player cannot be found.");
            }

            else
            {
                playerList.Remove(playerToRemove);
                Console.WriteLine($"The player {playerName} has been removed from the team.");
                return playerList.ToString();
            }
        }

        public void TeamInfo()
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.AppendLine($"Team name: {this.TeamName}");
            stringBuilder.AppendLine($"Players:");
            foreach (var player in playerList)
            {
                stringBuilder.AppendLine(player.PlayerInfo());
            }

            Console.WriteLine(stringBuilder.ToString());
        }
	}
}
