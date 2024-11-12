namespace AnonymousVotingSystem.Models
{
    public class Vote
    {
        public int Id { get; set; }
        public int UserId { get; set; }
        public string Option { get; set; }
        public virtual TrackCode TrackCode { get; set; }
    }
}
