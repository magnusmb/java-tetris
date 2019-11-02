import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Tetramino implements Minos
{
   public final int X;
   public final int Y;
   public final char TYPE;
   private final Mino[] minos;

   public static final char[] TYPES =
       {'I', 'J', 'L', 'O', 'S', 'T', 'Z'};

   public Tetramino (int x, int y)
   {
       int r = new Random().nextInt(7);
       this.X = x;
       this.Y = y;
       this.TYPE = TYPES[r];
       this.minos = shape(TYPE);
   }

   public Tetramino (int x, int y, char type)
   {
       this.X = x;
       this.Y = y;
       this.TYPE = type;
       this.minos = shape(TYPE);
   }

   public Tetramino (Mino[] minos, char type, int x, int y)
   {
       this.X = x;
       this.Y = y;
       this.TYPE = type;
       this.minos = minos;
   }

   public Tetramino (Tetramino old, Mino[] newMinos)
   {
       this.X = old.X;
       this.Y = old.Y;
       this.TYPE = old.TYPE;
       this.minos = newMinos;
   }

   public Tetramino rotate()
   {
       if (this.TYPE == 'O')
       {
           return this;
       }

       Mino[] newMinos = new Mino[4];

       for (int i = 0; i < 4; i++)
       {
           Mino mino = minos[i];
           int x = mino.X;
           int y = mino.Y;

           Mino newMino;

           if (this.TYPE == 'I')
           {
               newMino = new Mino(1-y, x, this.TYPE);
           }

           else
           {
               newMino = new Mino(-y, x, this.TYPE);
           }

           newMinos[i] = newMino;
       }

       return new Tetramino(this, newMinos);
   }

   public Tetramino moveDown()
   {
       return new Tetramino(minos, TYPE, X, Y+1);
   }

   @Override
   public Mino[] getMinos()
   {
       Mino[] relativeMinos = minos;
       Mino[] positionedMinos = new Mino[4];

       for (int i = 0; i < 4; i++)
       {
           int posX = relativeMinos[i].X + X;
           int posY = relativeMinos[i].Y + Y;
           Mino absoluteMino = new Mino(posX, posY, TYPE);
           positionedMinos[i] = absoluteMino;
       }

       return positionedMinos;
   }

   private static Mino[] shape (char type)
   {
        Mino[] minos;

        switch (type)
        {
            case 'I': minos = new Mino[]
                      {
                          new Mino(-1,  0, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type),
                          new Mino( 2,  0, type)
                      };
                      break;

            case 'J': minos = new Mino[]
                      {
                          new Mino(-1, -1, type),
                          new Mino(-1,  0, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type)
                      };
                      break;

            case 'L': minos = new Mino[]
                      {
                          new Mino( 1, -1, type),
                          new Mino(-1,  0, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type)
                      };
                      break;

            case 'O': minos = new Mino[]
                      {
                          new Mino( 0, -1, type),
                          new Mino( 1, -1, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type)
                      };
                      break;

            case 'S': minos = new Mino[]
                      {
                          new Mino( 1, -1, type),
                          new Mino( 0, -1, type),
                          new Mino( 0,  0, type),
                          new Mino(-1,  0, type)
                      };
                      break;

            case 'Z': minos = new Mino[]
                      {
                          new Mino(-1, -1, type),
                          new Mino( 0, -1, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type)
                      };
                      break;

            default:
            case 'T': minos = new Mino[]
                      {
                          new Mino( 0, -1, type),
                          new Mino(-1,  0, type),
                          new Mino( 0,  0, type),
                          new Mino( 1,  0, type)
                      };
                      break;
        }

        return minos;
   }
}
