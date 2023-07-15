package homework.Module_8;

public class Octagon extends Shape implements Movable, Scalable{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public String displayName(){
        return "Octagon";
    }

    @Override
    public double countArea() {
        return (3 * Math.sqrt(3) * side * side) / 2;
    }

    @Override
    public void move() {
        System.out.println("Octagon moved!");
    }

    @Override
    public void scale() {
        System.out.println("Octagon scaled!");
    }
}