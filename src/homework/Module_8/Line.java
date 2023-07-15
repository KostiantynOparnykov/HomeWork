package homework.Module_8;

public class Line implements Movable, Scalable{
    Point point1;
    Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getLength(Point point1, Point point2){
        return Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2));
    }

    @Override
    public void move() {
        System.out.println("Line moved!");

    }

    @Override
    public void scale() {
        System.out.println("Line scaled!");
    }
}
