using System;

namespace battleship_warmup_csharp
{
    class Program
    {
        static void Main(string[] args)
        {   
            Ocean ocean = new Ocean();
            ocean.AddShip(3, 0, 2);
            ocean.AddShip(4, 5, 8);
            int x, y;

            while (true) {
                System.Console.WriteLine(ocean);
    
                System.Console.WriteLine("Provide x coordinate");
                string x_input = Console.ReadLine();
                System.Console.WriteLine("Provide y coordinate");

                string y_input = Console.ReadLine();

                if (Int32.TryParse(x_input, out x) && Int32.TryParse(y_input, out y))
                {
                    if (ocean.Shoot(x, y))
                        System.Console.WriteLine("TRAFIONY!");
                    else
                        System.Console.WriteLine("PUDŁO!");
                }
            }
        }
    }
}
