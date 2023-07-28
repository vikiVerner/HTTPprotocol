package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter HTTP status code");
             String inputValue = scanner.nextLine();
             try{
                 int code = Integer.parseInt(inputValue);
                 System.out.println(("Valid number entered:" + inputValue));
                 try{
                     new HttpStatusImageDownloader().downloadStatusImage(code);
                     System.out.println("Your image downloaded!");
                 }catch(IllegalArgumentException ex){
                     System.out.println("There is not image for HTTP status: "+code);
                 }

             }catch(IllegalArgumentException ex) {
                 System.out.println("Please enter valid number!");

             }
        }
    }

}
