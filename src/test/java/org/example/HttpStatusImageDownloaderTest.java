package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {

    @Test
    public void testThatImageDownloaderWorkProperly() throws IOException {
        new HttpStatusImageDownloader().downloadStatusImage(300);
        String imagePath = System.getProperty("user.dir")+"/300.img";
        File file = new File(imagePath);
        boolean actual = file.exists();
        boolean expected = true;
        Assertions.assertEquals(expected,actual);

    }

}