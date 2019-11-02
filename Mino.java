class Mino
{
    public final int X;
    public final int Y;
    public final char TYPE;

    public Mino (int x, int y, char type)
    {
        X = x;
        Y = y;
        TYPE = type;
    }

    public boolean hasSamePositionAs(Mino other)
    {
        return (this.X == other.X && this.Y == other.Y);
    }
}
