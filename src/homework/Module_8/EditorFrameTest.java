package homework.Module_8;

public class EditorFrameTest {
    public static void main(String[] args) {
        Point point = new Point(1, 10);
        point.move();
        System.out.println();

        EvenSidedTriangle eTriangle = new EvenSidedTriangle(20);
        System.out.println(eTriangle.displayName());
        System.out.println(eTriangle.displayName() + "area = " + eTriangle.countArea());
        eTriangle.scale();
        eTriangle.move();
        System.out.println();


        Point startPoint = new Point(0,0);
        Point endPoint = new Point(20,10);
        Line line = new Line(startPoint, endPoint);
        System.out.println("Line length = " + line.getLength(startPoint, endPoint));
        line.move();
        line.scale();
        System.out.println();

        Octagon octagon = new Octagon(20);
        System.out.println(octagon.displayName());
        System.out.println(octagon.displayName() + "area = " + octagon.countArea());
        octagon.move();
        octagon.scale();
        System.out.println();

        Quad quad = new Quad(15);
        System.out.println(quad.displayName());
        System.out.println(quad.displayName() + " area = " + quad.countArea());
        quad.setSide(30);
        System.out.println(quad.displayName() + " new area = " + quad.countArea());
        quad.move();
        quad.scale();
        System.out.println();

        Rectangle rectangle = new Rectangle(30, 10);
        System.out.println(rectangle.displayName());
        System.out.println(rectangle.displayName() + "area = " + rectangle.countArea());
        rectangle.move();
        rectangle.scale();
        System.out.println();

        Circle circle = new Circle(25);
        System.out.println(circle.displayName());
        System.out.println(circle.displayName() + " area = " + circle.countArea());
        circle.scale();
        circle.move();
        System.out.println();

        NamePrinter printer = new NamePrinter();
        printer.printName(circle);
        printer.printName(quad);
    }
}
