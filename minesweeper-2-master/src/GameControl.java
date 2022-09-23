import java.util.Scanner;

public class GameControl

{

    private Box box;
    private int mines;
    private int xCoordinate;
    private int yCoordinate;
    private int dimension;
    private boolean mine;
    private boolean loop;
    private String level;
    private String input;
    final Frame f = new Frame();

    public GameControl()
    {
        loop = true;
        Scanner input = new Scanner(System.in);

        System.out.println("Welke moeilijkheid? beginner, gevordend of expert?");
        level = input.nextLine();

        System.out.println("Geef de dimensie in: ");
        dimension = input.nextInt();

        System.out.println("Geef eerste rij: ");
        xCoordinate = input.nextInt() -1;

        System.out.println("Geef eerste kolom: ");
        yCoordinate = input.nextInt() -1;

        while (xCoordinate > dimension -1 || yCoordinate > dimension -1)
        {
            System.out.println("Foute input");

            System.out.println("Geef eerste rij: ");
            xCoordinate = input.nextInt() -1;

            System.out.println("Geef eerste kolom: ");
            yCoordinate = input.nextInt() -1;
        }
        f.makeField(dimension, xCoordinate, yCoordinate, level);
        mines = f.amountOfMines();
    }

    public void turn() {
        while(loop == true) {
            Scanner input = new Scanner(System.in);

            System.out.println("Aantal bommen in het spel = " + mines);

            System.out.println("Welke zet wil je? flag of open?");
            String choise = input.nextLine();


            System.out.println("Geef rij: ");
            xCoordinate = input.nextInt() -1;

            System.out.println("Geef kolom: ");
            yCoordinate = input.nextInt() -1;

                while (xCoordinate > dimension -1 || yCoordinate > dimension -1)
                {
                System.out.println("Foute input");

                System.out.println("Geef rij: ");
                xCoordinate = input.nextInt() -1;

                System.out.println("Geef kolom: ");
                yCoordinate = input.nextInt() -1;
                }

            box = f.location(xCoordinate, yCoordinate);

            if(choise.equals("flag"))
            {
                mines--;
                f.printBoxes = box.flagBox(f.printBoxes, xCoordinate, yCoordinate);
                loop = f.win(f.printBoxes);
            }
            else
            {
                f.printBoxes = box.openBox(f.playField, f.printBoxes, xCoordinate, yCoordinate, dimension);

                if (box instanceof Mine)
                {
                    f.printField();
                    System.out.println("GAME OVER");
                    loop = false;
                }
                else
                {
                    loop = f.win(f.printBoxes);
                }
            }
            f.printField();
        }
    }
}
