interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Shape myShape = new Circle();
        myShape.draw();
    }
}