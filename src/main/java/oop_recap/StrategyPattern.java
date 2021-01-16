package oop_recap;

interface TheStrategy{
    public int calculate(int a, int b);
}

class Add implements TheStrategy{

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class Minus implements TheStrategy{

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

class Multiply implements TheStrategy{

    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

class Divide implements TheStrategy{

    @Override
    public int calculate(int a, int b) {
        return a / b;
    }
}

class TheCalculator{

    TheStrategy theStrategy;

    public void setTheStrategy(TheStrategy theStrategy) {
        this.theStrategy = theStrategy;
    }

    public int calculate(int a, int b){
        return theStrategy.calculate(a, b);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        TheCalculator calculator = new TheCalculator();
        calculator.setTheStrategy(new Divide());
        System.out.println(calculator.calculate(8,2));
    }
}
