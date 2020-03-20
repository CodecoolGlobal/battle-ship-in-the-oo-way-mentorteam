using System;

namespace battleship_warmup_csharp
{
    internal class Program
    {
        static void Main(string[] args)
        {   
            var ocean = new Ocean();
            ocean.AddShip(3, 0, 2);
            ocean.AddShip(4, 5, 8);

            while (true) {
                Console.WriteLine(ocean);
    
                var x = ReadCoordinate("X");
                var y = ReadCoordinate("Y");

                try
                {
                    Console.WriteLine(ocean.Shoot(x, y) ? "TRAFIONY!" : "PUDŁO!");
                } catch (ArgumentException e) {
                    Console.WriteLine(e);
                }
            }
        }

        private static int ReadCoordinate(string symbol) {
            int coor;

            Console.WriteLine("Provide " + symbol);
            var input = Console.ReadLine();

            while (int.TryParse(input, out coor) == false)
            {
                Console.WriteLine("Invalid input!");
                Console.WriteLine("Provide " + symbol);
                input = Console.ReadLine();
            }

            return coor;
        }
    }   
}
