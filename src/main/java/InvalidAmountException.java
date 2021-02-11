public class InvalidAmountException extends Exception {
    public void printErrorMessage() {
        System.out.println("Cannot deposit negative amounts");
    }
}
