/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreviewcodeforpartc;

/**
 *
 * @author Jaspreet
 */
/**
 * PasswordValidator class encapsulates password validation logic.
 * This follows the Open/Closed Principle of OOD, which means the class is
 * open for extension (you can add new validation rules) but closed for modification
 * (you don't have to change existing code to add new rules).
 * 
 * Future password validation rules can be added by extending the validate method
 * without modifying existing functionality.
 */

public class PasswordValidator {
     public boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        int specialCharCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                specialCharCount++;
            }
        }

        return specialCharCount > 0;
}
}