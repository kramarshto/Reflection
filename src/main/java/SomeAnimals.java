class SomeAnimals {
    @AutoInjectable
    private Flyable animal1;
    @AutoInjectable
    private Swimmable animal2;

    public void sound(){
        animal1.voice();
        animal2.voice();
    }
}
