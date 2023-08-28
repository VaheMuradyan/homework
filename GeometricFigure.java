import java.util.Scanner;

public class GeometricFigure {
    public static class TRIANGLE{
        int x1, x2, y1, y2, x3, y3;

        public TRIANGLE(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public double returnPerimeter(){
            double ab, bc, ac;
            ab =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
            ac = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

            if(ab + bc < ac){
                throw new ArithmeticException("Not thrue sides try agane");
            }else if(ac + ab < bc){
                throw new ArithmeticException("Not thrue sides try agane");
            }else if(ac + bc < ab){
                throw new ArithmeticException("Not thrue sides try agane");
            }

            return (ab + bc + ac);
        }
    }

    public static class SQUARE{
        int x1, x2, x3, x4, y1, y2, y3, y4;
        SQUARE(int x1, int y1, int x2, int y3){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y3 = y3;
            this.y2 = y1;
            this.x3 = x1;
            this.x4 = x2;
            this.y4 = y3;
        }

        public double returnPerimeter(){
            double ab = y3 - y1;
            double ad = x2 - x1;
            return (2 * ab) + (2 * Math.abs(ad));
        }
    }

    public static class ROUND{
        double radius;
        ROUND(double radius){
            setRadius(radius,new Scanner(System.in));
        }

        private void setRadius(double radius, Scanner scanner){
                if(radius > 0){
                    this.radius = radius;
                }else{
                    System.out.println("Invalid input radius must be bigeer then 0");
                    System.out.println("radius = ");
                    double ra = scanner.nextDouble();
                    setRadius(ra,scanner);
                }
        }

        public double returnPerimeter(){
            return 2 * Math.PI * radius;
        }
    }
}
