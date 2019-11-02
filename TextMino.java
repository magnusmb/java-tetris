class TextMino
{
    public final Mino MINO;

    public TextMino(Mino mino)
    {
        MINO = mino;
    }

    public String toString ()
    {
        String text = "";

        switch (MINO.TYPE)
        {
            case 'I': text += Colors.Text.CYAN;
                      break;
            case 'J': text += Colors.Text.BLUE;
                      break;
            case 'L': text += Colors.Text.YELLOW;
                      break;
            case 'O': text += Colors.Text.WHITE;
                      break;
            case 'S': text += Colors.Text.GREEN;
                      break;
            case 'T': text += Colors.Text.MAGENTA;
                      break;
            case 'Z': text += Colors.Text.RED;
                      break;
            default: break;
        }

        text += "██" + Colors.Text.DEFAULT;
        return text;
    }
}
