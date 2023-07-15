package homework.Module_8;

    public class Circle extends Shape implements Movable, Scalable{
        double radius;
        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public String displayName() {
            return "Circle";
        }

        @Override
        public double countArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public void move() {
            System.out.println("Circle moved!");

        }

        @Override
        public void scale() {
            System.out.println("Circle scaled!");
        }
    }

