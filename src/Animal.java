/*
*1. Using inheritance, one class can acquire the properties of others. Consider the following Animal class.*
*2. This class has only one method, walk. Next, we want to create a Bird class that also has a fly method.*
*3. Finally, we can create a Bird object that can both fly and walk. This code should print:*
_I am walking_
_I am flying_
*This means that a Bird object has all the properties that an Animal object has, as well as some additional unique properties.*
*The initial code is provided for you. You must add a sing method to the Bird class, then modify the main method accordingly so that the code prints the following lines:*
_I am walking_
_I am flying_
_I am singing_
 */

public class Animal {
    public void walk() {
        System.out.println("I am walking");
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
    }
}

class Bird extends Animal {
    public void fly() {
        System.out.println("I am flying");
    }

    public void sing() {
        System.out.println("I am singing");
    }
}

