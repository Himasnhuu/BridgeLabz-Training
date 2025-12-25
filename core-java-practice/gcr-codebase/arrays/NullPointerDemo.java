package Week_01.stringarray.level1;

class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateNullPointerException() {
        String text = null;
        int size = text.length();
    }

    // Method to handle NullPointerException using try-catch
    public static void handleNullPointerException() {

        try {
            //calling a method  a method that generates NullPointerException
        	generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Handled Null Pointer Exception");
        }
    }

    public static void main(String[] args) {

        // Call method that handles the exception
        handleNullPointerException();
    }
}
