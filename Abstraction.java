abstract class Animal{
    String name = "Animal";

    void eat(){
        System.out.println("Animal is eating");
    }

    abstract void sound();
}

class Dog extends Animal{
    void sound(){
        System.out.println("Dog is barking");
    }
}


public class Abstraction {
    public static void main(String[] args) {
        Dog d = new Dog();

        System.out.println(d.name);

        d.eat();

        d.sound();
    }
}
