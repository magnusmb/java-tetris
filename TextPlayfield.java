import java.util.Arrays;

class TextPlayfield
{
    private String[][] textBoard;

    public TextPlayfield (Playfield playfield)
    {
        textBoard = new String[playfield.HEIGHT][playfield.WIDTH];
        System.out.print("\033[2J\033[H");
    }

    public void render (Playfield playfield)
    {
        Mino[] tetramino = playfield.tetramino.getMinos();
        Mino[] stack = playfield.stack.getMinos();

        for (String[] row: textBoard) Arrays.fill(row, "░░");
        renderMinos(tetramino);
        renderMinos(stack);

        System.out.print(this);
    }

    private void renderMinos (Mino[] minos)
    {
        for (Mino mino : minos)
        {
            TextMino textMino = new TextMino(mino);
            textBoard[mino.Y][mino.X] = textMino.toString();
        }
    }

    public String toString ()
    {
        String playfieldText = "\033[H";
        String[][] visiblePlayfield =
            Arrays.copyOfRange(textBoard, 17, textBoard.length);

        for (String[] row : visiblePlayfield)
        {
            for (String cell : row) playfieldText += cell;
            playfieldText += "\n";
        }

        return playfieldText;
    }
}
