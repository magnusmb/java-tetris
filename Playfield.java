import java.util.Random;

class Playfield
{
    public final int WIDTH = 10;
    public final int HEIGHT = 40;
    public final Tetramino tetramino;
    public final MinoStack stack;
    private Random rand = new Random();

    public Playfield ()
    {
        tetramino = new Tetramino(4, HEIGHT - 22);
        stack = new MinoStack();
    }

    public Playfield (Tetramino tetramino, MinoStack stack)
    {
        this.tetramino = tetramino;
        this.stack = stack;

        if (collision(tetramino, stack)) System.exit(0);
    }

    private boolean outOfBounds (Tetramino tetramino)
    {
        for (Mino mino : tetramino.getMinos())
        {
            if (mino.X >= WIDTH
                    || mino.X < 0
                    || mino.Y >= HEIGHT
                    || mino.Y < 0)
            {
                return true;
            }
        }

        return false;
    }

   private static boolean collision(Minos someMinos, Minos otherMinos)
   {
       for (Mino someMino : someMinos.getMinos())
       {
           for (Mino otherMino : otherMinos.getMinos())
           {
               if (someMino.hasSamePositionAs(otherMino)) return true;
           }
       }

       return false;
   }

   private boolean isPossibleMove(Tetramino t, MinoStack s)
   {
       return !(collision(t, s) || outOfBounds(t));
   }

    public Playfield moveTetramino ()
    {
        if (rand.nextInt(5) == 0 && isPossibleMove(tetramino.rotate(), stack))
        {
            return new Playfield(tetramino.rotate(), stack);
        }

        if (isPossibleMove(tetramino.moveDown(), stack))
        {
            return new Playfield(tetramino.moveDown(), stack);
        }

        Tetramino newTetramino = new Tetramino(4, HEIGHT - 23);
        return new Playfield(newTetramino, stack.add(tetramino));

    }

    public Playfield step ()
    {
        return moveTetramino();
    }
}
