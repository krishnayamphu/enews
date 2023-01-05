package com.ky;

import com.ky.mail.JavaMail;

public class TestApp {
    public static void main(String[] args) {
        String name="Krishna";
        String subject="Hello world";
        String email="dev@aptechlalitpur.com";
        String message="this simple java mail example text.";

        JavaMail.sendMail(name,email,subject,message);
    }
}
