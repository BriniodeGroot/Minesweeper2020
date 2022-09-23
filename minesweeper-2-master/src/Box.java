import java.util.*;

public abstract class Box


{
    public abstract String[][] openBox(Box[][] checkPoint, String[][] printCheck, int xCo, int yCo, int dim);
    /*{

        *//*if(this instanceof EmptyBox)
        {
            String[][] emptyboxArray = ((EmptyBox) this).checkSurroundings(checkPoint, printCheck, xCo, yCo, dim);
            return emptyboxArray;
        }
        else
        {
            String[][] mineArray = ((Mine) this).openMine(checkPoint, printCheck);
            return mineArray;
        }*//*
    }*/

    public String[][] flagBox(String [][] printFlag, int xCo, int yCo)
    {
        if(printFlag[xCo][yCo].equals("|"))
        {
            printFlag[xCo][yCo] = "-";
        }
        else
        {
            printFlag[xCo][yCo] = "|";
        }

        return printFlag;
    }
}
