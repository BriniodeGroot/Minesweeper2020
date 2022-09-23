public class EmptyBox extends Box
{
    int amountOfMines;

    public String[][] openBox(Box [][] checkPoint, String[][] printCheck, int xCo, int yCo, int dim)
    {
        amountOfMines = 0;
        for(int row = xCo - 1; row < xCo + 2; row++)
        {
            for(int column = yCo -1; column < yCo + 2; column++)
            {
                if(row > dim -1 || column > dim -1 || row < 0 || column < 0)
                {

                }
                else
                {
                    if(checkPoint[row][column] instanceof Mine)
                    {
                        amountOfMines++;
                    }
                }
            }
        }
        printCheck[xCo][yCo] = String.valueOf(amountOfMines);

        if(amountOfMines == 0)
        {
            printCheck = checkSurroundings0(checkPoint, printCheck, xCo, yCo, dim);
        }

        return printCheck;
    }

    public String[][] checkSurroundings0(Box [][] checkPoint, String[][] printCheck, int xCo, int yCo, int dim)
    {
        for(int row = xCo - 1; row < xCo + 2; row++)
        {
            for(int column = yCo -1; column < yCo + 2; column++)
            {
                if(row > dim -1 || column > dim -1 || row < 0 || column < 0) {
                }
                else {

                    if (printCheck[row][column].equals("-")) {
                        printCheck = openBox(checkPoint, printCheck, row, column, dim);
                    }
                }
            }
        }
        return printCheck;
    }
}
