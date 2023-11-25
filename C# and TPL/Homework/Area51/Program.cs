using Area51.Enums;
using System;
using System.Threading;
using System.Threading.Tasks;

public class Agent
{
    public SecurityLevel SecurityClearance { get; }

    public Agent(SecurityLevel securityLevel)
    {
        SecurityClearance = securityLevel;
    }

    public async Task CallElevator(Elevator elevator, Floor currentFloor, Floor destination, SemaphoreSlim semaphore)
    {
        await semaphore.WaitAsync();
        elevator.RequestFloor(this, currentFloor, destination);
        semaphore.Release();
    }
}

public class Elevator
{
    private Floor currentFloor;
    private bool[] floorButtonsEnabled;
    private SemaphoreSlim semaphore = new SemaphoreSlim(1, 1); 

    public Elevator()
    {
        currentFloor = Floor.G;
        floorButtonsEnabled = new bool[Enum.GetValues(typeof(Floor)).Length];
    }

    public void RequestFloor(Agent agent, Floor currentFloor, Floor destination)
    {
        lock (this)
        {
            Array.Clear(floorButtonsEnabled, 0, floorButtonsEnabled.Length);
            floorButtonsEnabled[(int)destination] = true;

            if (agent.SecurityClearance >= GetRequiredClearance(destination))
            {
                MoveToFloor(destination);
                Console.WriteLine($"Elevator opens at floor {destination} for Agent with {agent.SecurityClearance} clearance.");
            }
            else
            {
                Console.WriteLine($"Agent with {agent.SecurityClearance} clearance cannot access floor {destination}. Choosing another floor.");
            }
        }
    }

    private SecurityLevel GetRequiredClearance(Floor floor)
    {
        switch (floor)
        {
            case Floor.G:
                return SecurityLevel.Confidential;
            case Floor.S:
                return SecurityLevel.Secret;
            case Floor.T1:
            case Floor.T2:
                return SecurityLevel.TopSecret;
            default:
                return SecurityLevel.Confidential;
        }
    }

    private void MoveToFloor(Floor destination)
    {
        Console.WriteLine($"Moving elevator from {currentFloor} to {destination}");
        Thread.Sleep(1000);
        currentFloor = destination;
    }
}

class Program
{
    static async Task Main(string[] args)
    {
        Elevator elevator = new Elevator();
        SemaphoreSlim semaphore = new SemaphoreSlim(1, 1); 

        Agent[] agents = new Agent[]
        {
            new Agent(SecurityLevel.Confidential),
            new Agent(SecurityLevel.Secret),
            new Agent(SecurityLevel.TopSecret)
        };

        await Task.WhenAll(
            Task.Run(() => agents[0].CallElevator(elevator, Floor.G, Floor.S, semaphore)),
            Task.Run(() => agents[1].CallElevator(elevator, Floor.G, Floor.T1, semaphore)),
            Task.Run(() => agents[2].CallElevator(elevator, Floor.G, Floor.T2, semaphore))
        );
    }
}
