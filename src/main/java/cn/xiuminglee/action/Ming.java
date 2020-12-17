package cn.xiuminglee.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Xiuming Lee
 */
public class Ming {
    public static void main(String[] args) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Java 测试GitHub Actions</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Java 测试GitHub Actions :" + date + "</h1>\n" +
                "</body>\n" +
                "</html>";

        File file = new File("dist");
        if (!file.exists()){
            file.mkdir();
        }
        File htmlFile = new File("dist/index.html");
        FileWriter fileWriter = new FileWriter(htmlFile);
        fileWriter.write(html);
        fileWriter.flush();
    }
}
