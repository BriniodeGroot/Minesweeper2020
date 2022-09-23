import java.util.Random;

public class Frame

{
    private int dimension;
    private int row;
    private int amountOfMines = 0;
    private int column;
    private int levelNumber;
    Box[][] playField;
    String[][] printBoxes;


    public void makeField(int dimension, int xCoordinate, int yCoordinate, String level)
    {
        if(level.equals("beginner"))
        {
            levelNumber = 80;
        }
        if(level.equals("gevordend"))
        {
            levelNumber = 70;
        }
        if(level.equals("expert"))
        {
            levelNumber = 60;
        }
        playField = new Box[dimension][dimension];
        printBoxes = new String[dimension][dimension];
        for(int row = 0; row < playField.length; row++)
        {
            for(column = 0; column < playField[row].length; column++)
            {
                Random number = new Random();
                int randomNumber = number.nextInt(100);
                printBoxes[row][column] = ("-");
                if(randomNumber < levelNumber)
                {
                    EmptyBox b = new EmptyBox();
                    playField[row][column] = b;
                }
                else
                {
                    Mine m = new Mine();
                    playField[row][column] = m;
                    amountOfMines++;
                }
            }
        }
        EmptyBox empty = new EmptyBox();
        playField[xCoordinate][yCoordinate] = empty;
        for(int row = xCoordinate - 1; row < xCoordinate + 2; row++) {
            for (int column = yCoordinate - 1; column < yCoordinate + 2; column++) {
                if(row > dimension -1 || column > dimension -1 || row < 0 || column < 0)
                {

                }
                else {
                    EmptyBox x = new EmptyBox();
                    playField[row][column] = x;
                }
            }
        }

        for(int row = xCoordinate - 1; row < xCoordinate + 2; row++)
            {
                for(int column = yCoordinate -1; column < yCoordinate + 2; column++)
                {
                    if(row > dimension -1 || column > dimension -1 || row < 0 || column < 0)
                    {

                    }
                    else {
                        printBoxes = playField[row][column].openBox(playField, printBoxes, row, column, dimension);
                    }
                }

        }
        printField();
    }

    public void printField()
    {
        for(int i = 1; i <= printBoxes.length; i++){
            System.out.print("\t" + i + ")");
        }
        System.out.println();


        for(int i = 0; i < printBoxes.length; i++){
            System.out.print(i+1 + ")" + "\t");

            for(column = 0; column < printBoxes[i].length; column++)
            {
                System.out.print(printBoxes[i][column]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    public Box location(int xCo, int yCo)
    {
        return playField[xCo][yCo];
    }

    public boolean win(String[][] checkWin)
    {
        for (int row = 0; row < checkWin.length; row++) {
            for (int column = 0; column < checkWin[row].length; column++) {
                if (checkWin[row][column].equals("-")) {
                    return true;
                }
            }
        }
        System.out.println("GEWONNEN!!!");
        return false;
    }

    public int amountOfMines() {
        return amountOfMines;
    }
}