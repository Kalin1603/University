using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace AnonymousVotingSystem.Migrations
{
    /// <inheritdoc />
    public partial class VoteTrackCode : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "TrackCode",
                table: "Votes");

            migrationBuilder.CreateIndex(
                name: "IX_TrackCodes_VoteId",
                table: "TrackCodes",
                column: "VoteId",
                unique: true);

            migrationBuilder.AddForeignKey(
                name: "FK_TrackCodes_Votes_VoteId",
                table: "TrackCodes",
                column: "VoteId",
                principalTable: "Votes",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_TrackCodes_Votes_VoteId",
                table: "TrackCodes");

            migrationBuilder.DropIndex(
                name: "IX_TrackCodes_VoteId",
                table: "TrackCodes");

            migrationBuilder.AddColumn<string>(
                name: "TrackCode",
                table: "Votes",
                type: "nvarchar(max)",
                nullable: false,
                defaultValue: "");
        }
    }
}
