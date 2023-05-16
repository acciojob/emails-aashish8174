package com.driver;

import java.sql.SQLOutput;

public class Email {

    String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
            if (!oldPassword.equals(this.password)){
               // System.out.println("wrong password");
                //return;
            }
            else{
                boolean pass = checkPassword(newPassword);
                if(pass) this.password = newPassword;
            }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
     boolean checkPassword(String passwordIntered){
        if(passwordIntered.length()<8) return false;
        boolean upperCaseLatter = false;
        boolean lowerCaseLetter = false;
        boolean digit = false;
        boolean specialCharacter = false;
        for(int i=0;i<passwordIntered.length();i++){
            char ch = passwordIntered.charAt(i);
            if(ch>=65 && ch<=90) lowerCaseLetter = true;
            if(ch>=97 && ch<=122) upperCaseLatter = true;
            if(ch>=48 && ch<=57) digit = true;
            else specialCharacter = true;
        }
        if(upperCaseLatter && lowerCaseLetter && digit && specialCharacter){
            return true;
        }
        return false;
    }
}
