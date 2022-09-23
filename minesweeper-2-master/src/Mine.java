public class Mine extends Box {

    @Override
    public String[][] openBox(Box[][] checkPoint, String[][] gameOver, int xCo, int yCo, int dim) {
        for (int row = 0; row < checkPoint.length; row++) {
            for (int column = 0; column < checkPoint[row].length; column++) {
                if (checkPoint[row][column] instanceof Mine) {
                    gameOver[row][column] = "*";
                }
            }
        }
        return gameOver;
    }
}
