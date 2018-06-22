package com.zmx.controller;

import com.zmx.entity.Student;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class DefaultController {

    @RequestMapping("/mylist")
    public   Object home() {
        List<HashMap<String, String>> list= new ArrayList<>();
        for (int i=0;i<20;i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("imageUrl", "http://cdn2.kcomber.com:8195/upload//Plant/violet/0719A03D-7832-4C96-A4D8-544309E31B7D.jpg");
            hashMap.put("bookName", "少年张三丰"+i);
            hashMap.put("createTime", "2015-12-12");
            list.add(hashMap);
        }
        return list;
    }

    @RequestMapping("/isbn/{code}")
    public   Object home(@PathVariable String code) throws IOException {
        if(code==null||code.equals(""))
        {
            return null;
        }
        String url=String.format("%s%s","https://api.douban.com/v2/book/isbn/:",code);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result=     EntityUtils.toString(entity);
                return  result;
            }
        } finally {
            response.close();
        }
        return  null;
    }

    @RequestMapping("/hello/{myName}")
    public String index(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            String uuid = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            Path path = Paths.get("F:\\IISWeb\\Images\\" + uuid);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }
    @GetMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage() throws IOException {

        String path="F:\\IISWeb\\Images\\bg.png";
        InputStream in = new FileInputStream(new File(path));
        return IOUtils.toByteArray(in);
    }
}