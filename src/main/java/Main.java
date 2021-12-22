public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        SomeAnimals sa = (new Injector()).inject(new SomeAnimals());
        sa.sound();
    }
}