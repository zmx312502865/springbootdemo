package com.zmx.controller;

import com.zmx.entity.ApiResult;
import com.zmx.entity.Book;
import com.zmx.entity.BookUser;
import com.zmx.service.IBookService;
import com.zmx.service.IBookUserService;
import com.zmx.util.MyConfig;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired(required=true)
    private IBookService bookService;

    @Autowired(required=true)
    private IBookUserService bookUserService;

    @Autowired
    private MyConfig myConfig;

    @PostMapping("")
    public ApiResult<String> Add(@RequestBody Book book,@RequestHeader(value="UserId") int userId) {
        ApiResult<String> apiResult=new ApiResult<>();
        addBook(book,userId);
        apiResult.code= bookService.Insert(book)>0? 200:500;
        return  apiResult;
    }

    private  void  addBook(Book book,int userId){
        bookService.Insert(book);
        BookUser bu=new BookUser();
        bu.bookId=book.bookId;
        bu.userId=userId;
        bookUserService.Insert(bu);
    }

    @PostMapping("/{bookId}")
    public   Object Get(int bookId) {

        return 1111;
    }

    @GetMapping("/mylist")
    public   Object home(@RequestHeader(value="UserId") int userId) {
        ArrayList<Book> bookList= bookService.getByUserId(userId);
        List<HashMap<String, String>> list= new ArrayList<>();
        for (int i=0;i<bookList.size();i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("imageUrl",bookList.get(i).bookImageUrl);
            hashMap.put("bookName", bookList.get(i).bookName);
            hashMap.put("createTime",  bookList.get(i).bookPubdate);
            list.add(hashMap);
        }
        return list;
    }

    @GetMapping("/isbn/{code}")
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

    @PostMapping("/image/upload") // //new annotation since 4.3
    public ApiResult<String> singleFileUpload(@RequestParam("file") MultipartFile file) {
        ApiResult<String> apiResult=new ApiResult<>();
        apiResult.code=200;
        try {
            String newName = UUID.randomUUID().toString();  //+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path path = Paths.get( myConfig.imageSavePath+ newName);
            Files.write(path, bytes);
            apiResult.data=  myConfig.imageResourseDomin+ "/book/image/"+newName  ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return   apiResult;
    }
    @GetMapping(value = "/image/{fileName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable String fileName) throws IOException {

        String path=myConfig.imageSavePath+fileName;
        InputStream in = new FileInputStream(new File(path));
        return IOUtils.toByteArray(in);
    }
}