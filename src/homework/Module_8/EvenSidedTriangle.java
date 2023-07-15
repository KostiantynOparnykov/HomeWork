package homework.Module_8;

public class EvenSidedTriangle extends Shape implements Scalable, Movable{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public EvenSidedTriangle(double side){
        this.side = side;
    }

    @Override
    public String displayName() {
        return "Even sided Triangle";
    }

    @Override
    public double countArea() {
        return (Math.sqrt(3)/4) * side*side;
    }

    @Override
    public void move() {
        System.out.println("Even sided triangle moved!");
    }

    @Override
    public void scale() {
        System.out.println("Even sided triangle scaled!");
    }
}
