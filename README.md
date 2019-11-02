# java-tetris
An unfinished project where I wanted to make a Tetris game playable in the
terminal. The game is rendered by printing ANSI codes and Unicode characters to
standard output.

The project was put on hold when I realized that handling keyboard input,
without halting the game, was much harder than I had thought initially.

In any case, if you want to run the program, compile with Java 8 or later.

```bash
javac Tetris.java
```
Then run `java Tetris` and the pieces should start falling.

## Requirements
* Java 8 or later
* Terminal with Unicode and ANSI code support
