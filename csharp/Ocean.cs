using System;
using System.Collections.Generic;
using System.Linq;

namespace battleship_warmup_csharp
{
    public class Ocean{

        public static readonly int Width = 10;
        public static readonly int Height = 10;
        private readonly List<List<Square>> _board;
        private readonly List<Ship> _ships;

        public Ocean(){
            _board = new List<List<Square>>();
            _ships = new List<Ship>();

            for (var i = 0; i < Height; i++){
                var row = new List<Square>();
                for (var j = 0; j < Width; j++){
                    row.Add(new Square());
                }
                _board.Add(row);
            }
        }

        public bool AddShip(int shipLength, int x, int y) { 
            if (x < 0 || x >= Width)
                throw new ArgumentException("x coordinate should be in range 0..9");
            if (y < 0 || y >= Height)
                throw new ArgumentException("y coordinate should be in range 0..9");
            if (shipLength < 1 || shipLength > 4)
                throw new ArgumentException();
            
            var squares = new List<Square>();
            for (var i = 0 ; i < shipLength ; i++)
                squares.Add(_board[y][x + i]);
            
            _ships.Add(new Ship(squares));
            Console.WriteLine(_ships);
            return true;
        }

        public bool Shoot(int x, int y) {
            if (x < 0 || x >= Width)
                throw new ArgumentException("x coordinate should be in range 0..9");
            if (y < 0 || y >= Height)
                throw new ArgumentException("y coordinate should be in range 0..9");

            var square = _board[x][y];
            
            square.Shoot();

            if (_ships.Any(ship => ship.Contains(square)))
            {
                square.Symbol = "X";
                return true;
            }

            square.Symbol = "O";
            return false;

        }
        
        public override string ToString(){

            var str = " 12345678910\n";
            var ascii = 97;
            foreach (var row in _board) {
                str += (char)ascii;
                str = row.Aggregate(str, (current, square) => current + square);
                str += "\n";
                ascii++;
            }
            return str;
        }
    }
}