package org.example;
import org.jsoup.Jsoup;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HttpStatusImageDownloader {
    private static final String catURL = "https://http.cat/";
    private static final String imagePath = System.getProperty("user.dir"); // The path to the current working directory
    public void downloadStatusImage(int code) throws IOException {
        String url = new HttpStatusChecker().getStatusImage(code);
        String fileName = "/"+code+".img";
        byte[]  response = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .execute()
                .bodyAsBytes();
        File file = new File(imagePath+fileName);
        OutputStream os = new FileOutputStream(file);
        os.write(response);
        os.close();
    }
}
