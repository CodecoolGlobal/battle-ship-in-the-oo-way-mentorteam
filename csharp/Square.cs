
namespace battleship_warmup_csharp
{
    public class Square
    {
        public bool IsHit { get; private set; }
        public string Symbol { get; set; }

        public Square()
        {
            IsHit = false;
            Symbol = "*";
        }

        public void Shoot()
        {
            IsHit = true;
        }

        public override string ToString() {
            return Symbol;
        }
    }
}