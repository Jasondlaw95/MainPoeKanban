package mainpoekanban;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//
//We need to  check the username parametres
// That the user registers with the provided un, pw and name
//If there are discrepencies with the registered details we need to throw out an errro.
//If the user does it correc tly  we need to throw out some form of successful message.
//We need to validate the entered un and pw for the login and return the status based on the final prompt when logging in.
public class Login {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName() {
        Pattern pattern = Pattern.compile("^\\w{1,5}_\\w*$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not formatted correctly. Please make sure it contains an underscore and is not longer than 5 characters.";
        } else if (checkPasswordComplexity()) {
            return "Welcome " + firstName + ", " + lastName + "! Registration completed.";
        } else {
            return "Password does not meet the complexity requirements. Please make sure it is not longer than 8 characters in length.";
        }
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Successful login.";
        } else {
            return "Failed login.";
        }
    }

    private boolean checkPasswordComplexity() {
        return password.length() <= 8;
    }
}
