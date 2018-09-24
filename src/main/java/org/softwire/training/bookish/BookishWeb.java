package org.softwire.training.bookish;

//everything we need to import//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//entry to bookish//
@SpringBootApplication
public class BookishWeb {
    //this starts and runs the website//
    public static void main(String[] args) {
        SpringApplication.run(BookishWeb.class, args);
    }


}
