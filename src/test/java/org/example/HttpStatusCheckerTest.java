package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HttpStatusCheckerTest {

    @Test
    public void testThatStatus1000Handled() {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        Assertions.assertThrows(IllegalArgumentException.class,()->{

            httpStatusChecker.getStatusImage(1000);
        });
    }

    @Test
    public void testThatStatus200Handled() throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String actual = httpStatusChecker.getStatusImage(200);
        String expected = "https://http.cat/200";
        Assertions.assertEquals(expected,actual);
    }
}