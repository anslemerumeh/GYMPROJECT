package src.com.company.exceptions.packagedoesnotexist;

public class PackageDoesNotExistException extends Exception{

    private static final String MESSAGE = "Package does not exist.";

    public PackageDoesNotExistException(){
        super(MESSAGE);
    }
    public PackageDoesNotExistException(String message){
        super(message);
    }
}
