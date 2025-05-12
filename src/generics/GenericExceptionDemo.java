package generics;

// Java doesn't support Generic Exception as it gets erased at runtime and we can't handle it based on data types
// But there is a workaround
public class GenericExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new GenericException(123);
        } catch (GenericException e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new GenericException("string");
        } catch (GenericException e) {
            System.out.println(e.getMessage());
        }


    }
}

class GenericException extends  Exception{

    // We can do this because even after eraser, T is replace by Object and all methods will still run properly
    public <T> GenericException(T value){
        super("Exception related to value: " + value.toString() + " of type: " + value.getClass().getName());
    }
}
