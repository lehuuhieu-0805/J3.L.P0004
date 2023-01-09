/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUser;

/**
 *
 * @author lehuuhieu
 */
public class UserError {

    private String emailError, nameError, passwordError, confirmPasswordError, userError;

    public UserError() {
    }

    public UserError(String emailError, String nameError, String passwordError, String confirmPasswordError, String userError) {
        this.emailError = emailError;
        this.nameError = nameError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.userError = userError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

}
