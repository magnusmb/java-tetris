import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MinoStack implements Minos
{
    private final Mino[] minos;

    public MinoStack ()
    {
        minos = new Mino[0];
    }

    public MinoStack (Mino[] minos)
    {
        this.minos = minos;
    }

    public MinoStack add(Minos newMinos)
    {
        Set<Mino> helperSet = new HashSet<>();

        for (Mino m : minos) helperSet.add(m);
        for (Mino m : newMinos.getMinos()) helperSet.add(m);

        Mino[] allMinos = new Mino[helperSet.size()];
        allMinos = helperSet.toArray(allMinos);

        return new MinoStack(allMinos);
    }

    @Override
    public Mino[] getMinos()
    {
        return Arrays.copyOf(minos, minos.length);
    }
}
