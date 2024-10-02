

import java.util.Scanner;
import midtermreviewcodeforpartc.PasswordValidator;
import midtermreviewcodeforpartc.User;

/**
 * The signIn page for UnoOnline.
 * Takes in a user name and password and then
 * validates the password using the PasswordValidator class
 * before creating a new user in the list of possible users.
 * This code follows OOD principles to ensure easy modification and extension
 * of password validation rules.
 * 
 * @author dancye, 2019
 */
public class UnoOnline 
{
    private User users[] = new User[100]; // Room for 100 online players!
    private PasswordValidator passwordValidator = new PasswordValidator(); // PasswordValidator instance
    
    public static void main(String[] args) 
    {
        UnoOnline newPortal = new UnoOnline();
        newPortal.run();
    }

    /**
     * Method that takes in the User's name and chosen password
     * and then continues prompting until the password is valid based on the rules.
     */
    private void run()
    {
        int userCount = 0; // Keep track of number of users for array
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your desired user name:");
        String userName = sc.nextLine();
        
        boolean validPassword = false;
        String password = "";
        
        // Continue prompting the user for a valid password
        while (!validPassword) {
            System.out.println("Passwords must have at least 8 characters.");
            System.out.println("Passwords must have at least one special character.");
            System.out.println("Please enter your desired password:");
            
            password = sc.nextLine();
            
            // Use PasswordValidator to check if the password is valid
            validPassword = passwordValidator.validate(password);
            if (!validPassword) {
                System.out.println("Invalid password. Please try again.");
            }
        }
        
        // Password is valid, create the user
        User newUser = new User(userName, password);
        users[userCount] = newUser; // Add the new user to the user list
        userCount++;
        
        System.out.println("New User Added");
        System.out.println("UserName: " + userName);
        System.out.println("Password: just kidding, can't show password");
    }
}
