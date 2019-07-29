package src.com.company.exceptions.registrationtype;

public class RegistrationTypeRequireException extends Exception {

    private static final String MESSAGE = "Registration type is a required field";

    public RegistrationTypeRequireException(){
        super(MESSAGE);
    }
    public RegistrationTypeRequireException(String message){
        super(message);
    }
}
