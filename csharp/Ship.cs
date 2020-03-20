using System.Collections.Generic;

namespace battleship_warmup_csharp
{
    public class Ship {
        private readonly List<Square> _squares;

        public Ship(List<Square> squares)
        {
            _squares = squares;
        }

        public bool Contains(Square square) 
        {
            return _squares.Contains(square);
        }
    }
}