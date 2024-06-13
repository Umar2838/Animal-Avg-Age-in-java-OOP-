class Animal{
     String name;
     int age;
     String gender;

    public Animal(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String produceSound(){
        return "";
    }
}

class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }
public String produceSound(){
    return "Bow wow";
}

}

class Frog extends Animal {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    public String produceSound() {
        return "Ribbit";
    }
}

class Cat extends Animal{
    public Cat(String name, int age, String gender){
        super(name, age, gender);
    }
    public String produceSound() {
        return "Meow";
    }
}

class Kitten extends Cat {
    public Kitten(String name, int age) {
        super(name, age, "female");
    }

    public String produceSound() {
        return "Meow";
    }
}

class Tomcat extends Cat {
    public Tomcat(String name, int age) {
        super(name, age, "male");
    }

    public String produceSound() {
        return "Meow";
    }
}

public class AnimalFamil{
 public static void main(String[] args) {
    
    Animal[] animals = {
        new Dog("Buddy", 5, "male"),
        new Frog("Frodo", 2, "male"),
        new Kitten("Kitty", 1),
        new Tomcat("Tom", 3)
    };

    double averageAgeDog = calculateAverageAge(animals, Dog.class);
    double averageAgeFrog = calculateAverageAge(animals, Frog.class);
    double averageAgeKitten = calculateAverageAge(animals, Kitten.class);
    double averageAgeTomcat = calculateAverageAge(animals, Tomcat.class);

    System.out.println("Average age of dogs: " + averageAgeDog);
    System.out.println("Average age of frogs: " + averageAgeFrog);
    System.out.println("Average age of kittens: " + averageAgeKitten);
    System.out.println("Average age of tomcats: " + averageAgeTomcat);

    for (Animal animal : animals) {
        System.out.println(animal.name + " says: " + animal.produceSound());
    }
}

public static double calculateAverageAge(Animal[] animals, Class<?> animalType) {
    int totalAge = 0;
    int count = 0;
    for (Animal animal : animals) {
        if (animalType.isInstance(animal)) {
            totalAge += animal.age;
            count++;
        }
    }
    return count > 0 ? (double) totalAge / count : 0;
}
}