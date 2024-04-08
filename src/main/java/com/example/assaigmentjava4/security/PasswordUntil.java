package com.example.assaigmentjava4.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUntil {

    public static String hashPassword(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hash){
        return BCrypt.checkpw(password,hash);
    }
}
