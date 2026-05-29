class AnimalClass{
    void eat(){
        System.out.println("This animal eats food.");
    }
}

class DogAnimal extends AnimalClass{
    void bark(){
        System.out.println("The dog barks.");
    }

    // void eat(){
    //     System.out.println("The dog eats dog food.");
    // }
}



public class Inherit {
    public static void main(String[] args) {
        DogAnimal myDog = new DogAnimal();
        
        myDog.eat();
        
        myDog.bark();
    }
}
