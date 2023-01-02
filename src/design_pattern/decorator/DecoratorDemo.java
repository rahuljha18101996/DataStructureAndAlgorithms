package design_pattern.decorator;

/*
* Decorator Design Pattern
* Structural Design Pattern : Improve the structure of code
* Used when we want to modify functionality of an Object at runtime & it should not change individual Object functionality.
* i.e., Adding different functionalities in Dress
*
* */
interface Dress {
    void assemble();
}

class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

class DressDecorator implements Dress {
        protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

class CasualDecorator extends DressDecorator {
    public CasualDecorator(Dress d) {
        super(d);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Feature.");
    }
}

class SportyDress extends DressDecorator {

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Feature.");
    }
}

class FancyDress extends DressDecorator {

    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Feature.");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        //Dress sp
    }
}
