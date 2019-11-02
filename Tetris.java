class Tetris
{
    public static void main (String[] args)
    {
        Playfield playfield = new Playfield();
        TextPlayfield textRender = new TextPlayfield(playfield);

        while (true)
        {
            textRender.render(playfield);

            try
            {
                Thread.sleep(100);
            }
            catch (Exception e) {}

            playfield = playfield.step();
        }
    }
}
