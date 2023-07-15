package homework.Module_8;

public class Quad extends Shape implements Movable, Scalable{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Quad(double side) {
        this.side = side;
    }

    @Override
    public String displayName(){
        return "Quad";
    }

    @Override
    public double countArea() {
        return side * side;
    }

    @Override
    public void move() {
        System.out.println("Quad moved!");

    }

    @Override
    public void scale() {
        System.out.println("Quad scaled!");
    }
}
