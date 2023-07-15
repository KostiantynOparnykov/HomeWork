package homework.Module_8;

public class Point implements Movable{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        System.out.println("Point moved");
    }
}
