class Animal {
    void sound() {
        System.out.println("Generic animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal myAnimal = new Cat(); // Upcasting
        myAnimal.sound(); // Calls the overridden method in Cat
    }
}