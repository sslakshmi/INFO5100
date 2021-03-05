package edu.northeastern;

public class MyIndexOutOfBoundException extends IndexOutOfBoundsException {
    private int lowerBound;
    private int upperBound;
    private int index;

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    @Override
    public String toString(){
        return "\nError Message: Index: "+ index + ", but Lower bound: "+ lowerBound + ", Upper bound: " + upperBound +
                "\n" + super.toString();
    }

}
