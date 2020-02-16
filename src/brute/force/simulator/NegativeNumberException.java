package brute.force.simulator;

public class NegativeNumberException extends Exception {
    @Override
    public String getMessage(){
        return "Please enter positive integers only.";
    }
}
