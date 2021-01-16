package oop_recap;

class Count{

    private int counter;
    static  Count instance = null;

    private Count(){

    }

    public static Count getInstance(){
        if (instance == null){
            instance = new Count();
        }
        return instance;
    }

    public int nextCount(){
        return ++counter;
    }
}

public class SingletonPattern {

    public static void increment(){
        Count counter = Count.getInstance();
        System.out.println("count => "+counter.nextCount());
        System.out.println("count => "+counter.nextCount());
        System.out.println("count => "+counter.nextCount());
    }

    public static void main(String[] args) {
        increment();
    }
}
