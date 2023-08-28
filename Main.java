import java.util.Scanner;

public class Main {
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1, x2, x3, y1, y2, y3;
        boolean ok = true;

        prompt();
        while(ok) {
            showWays();
            int chois = getUserInput(scanner, 1, 4);
            System.out.println();
            switch (chois) {
                case 1:
                    while (true) {
                        System.out.print("x1 = ");
                        x1 = scanner.nextInt();
                        System.out.print("y1 = ");
                        y1 = scanner.nextInt();
                        System.out.print("x2 = ");
                        x2 = scanner.nextInt();
                        System.out.print("y2 = ");
                        y2 = scanner.nextInt();
                        System.out.print("x3 = ");
                        x3 = scanner.nextInt();
                        System.out.print("y3 = ");
                        y3 = scanner.nextInt();

                        GeometricFigure.TRIANGLE triangle = new GeometricFigure.TRIANGLE(x1, y1, x2, y2, x3, y3);
                        System.out.println();
                        try {
                            System.out.println("Perimeter of trieangle = " + CYAN + triangle.returnPerimeter() + ANSI_RESET);
                            drawTriangle(8);
                            break;
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    System.out.print("x1 = ");
                    x1 = scanner.nextInt();
                    System.out.print("y1 = ");
                    y1 = scanner.nextInt();
                    System.out.print("x2 = ");
                    x2 = scanner.nextInt();
                    System.out.print("y2 = " + y1);
                    System.out.print("\nx3 = " + x1);
                    System.out.print("\ny3 = ");
                    y3 = scanner.nextInt();
                    System.out.print("x4 = " + x2);
                    System.out.print("\ny4 = " + y3);
                    System.out.println("\n");

                    GeometricFigure.SQUARE square = new GeometricFigure.SQUARE(x1, y1, x2, y3);

                    System.out.println("Perimeter of square = " + CYAN + square.returnPerimeter() + ANSI_RESET);
                    drawSquare(6);
                    break;
                case 3:
                    System.out.print("radius = ");
                    int radius = scanner.nextInt();
                    GeometricFigure.ROUND round = new GeometricFigure.ROUND(radius);
                    System.out.println("Perimeter of round = " + CYAN + round.returnPerimeter() + ANSI_RESET);
                    drawCircle(5);
                    break;
                case 4:
                    ok = false;
                    break;
            }
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
        }
    }

    private static void prompt(){
        System.out.println( "   ______   ______   ____     __  ___   ______   ______   ____     __  __");
        System.out.println("  / ____/  / ____/  / __ \\   /  |/  /  / ____/  /_  __/  / __ \\    \\ \\/ /");
        System.out.println(" / / __   / __/    / / / /  / /|_/ /  / __/      / /    / /_/ /     \\  /");
        System.out.println("/ /_/ /  / /___   / /_/ /  / /  / /  / /___     / /    / _, _/      / /");
        System.out.println("\\____/  /_____/   \\____/  /_/  /_/  /_____/    /_/    /_/ |_|      /_/" + ANSI_RESET);


    }

    private static void showWays(){
        System.out.println("\n");
        System.out.println(PURPLE+"["+CYAN+"::"+PURPLE+"]"+ ANSI_RESET +" SELECT AN OBJECT " + PURPLE+"["+CYAN+"::"+PURPLE+"]");
        System.out.println();
        System.out.println(PURPLE+"["+CYAN+"1"+PURPLE+"]"+ANSI_RESET + " TRIANGLE");
        System.out.println(PURPLE+"["+CYAN+"2"+PURPLE+"]"+ANSI_RESET + " SQUARE");
        System.out.println(PURPLE+"["+CYAN+"3"+PURPLE+"]"+ANSI_RESET + " ROUND");
        System.out.println();
        System.out.println(PURPLE+"["+CYAN+"4"+PURPLE+"]"+ANSI_RESET + " EXIT");
        System.out.println();
    }

    public static void drawTriangle(int height) {
        for (int row = 1; row <= height; row++) {
            for (int space = 0; space < height - row; space++) {
                System.out.print("  ");
            }
            for (int col = 0; col < 2 * row - 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawSquare(int sideLength) {
        for (int row = 0; row < sideLength; row++) {
            for (int col = 0; col < sideLength; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void drawCircle(int radius) {
        int diameter = radius * 2;
        int centerX = radius;
        int centerY = radius;

        for (int y = 0; y <= diameter; y++) {
            for (int x = 0; x <= diameter; x++) {
                int distance = (int) Math.round(Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)));
                if (distance == radius) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static int getUserInput(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print(CYAN + "Selection " + ANSI_RESET + "-->>> " );
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Invalid input. Please enter a valid number between " + min + " and " + max);
        }
    }
}