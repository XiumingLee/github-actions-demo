package cn.xiuminglee.action;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Xiuming Lee
 */
public class Ming {
    public static void main(String[] args) throws IOException {

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        ClassLoader classLoader = Ming.class.getClassLoader();
        URL url = classLoader.getResource("static");
        File src = new File(url.getFile());
        File dest = new File("dist");

        FileUtil.copyContent(src,dest,true);

        // 修改data.js
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("name","lisi");
        jsonObject.set("age",22);
        jsonObject.set("date",date);

        String data = "let data = " + jsonObject.toString();

        File dataFile = new File("dist/js/data.js");
        FileUtil.writeString(data,dataFile,"UTF-8");
    }


}
