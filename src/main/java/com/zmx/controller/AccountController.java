package com.zmx.controller;

import com.google.gson.Gson;
import com.zmx.entity.ApiResult;
import com.zmx.entity.Book;
import com.zmx.entity.SysUser;
import com.zmx.service.IAuthUserService;
import com.zmx.service.IBookService;
import com.zmx.service.ISysUserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired(required=true)
    private IAuthUserService authUserService;

    @Autowired(required=true)
    private  ISysUserService sysUserService;

    @Autowired(required=true)
    private IBookService bookService;
//     @Autowired(required = true)
//     @Qualifier("AccountUtil")
//    private  AccountUtil accountUtil;


    @GetMapping(value="")
    public   ApiResult<List<SysUser>> getList() {
        ApiResult<List<SysUser>> result = new ApiResult<>();
        result.setCode(200);
        List<SysUser> userList = sysUserService.getAll();
        result.setData(userList);
        return result;
    }



    @RequestMapping(value = "/wxlogin", method = RequestMethod.POST)
    public   Object wxlogin(@RequestBody Map<String, String> requestMap) throws IOException {
        String openId = getWxOpenId(requestMap.get("code"));
        String nickName =requestMap.get("nickName");
        String avatarUrl = requestMap.get("avatarUrl");
        if (openId == null || openId.isEmpty()) {
        }
        SysUser user = sysUserService.authUserLoginOrRegist(openId, 1,nickName,avatarUrl);
        return user;
    }

    private   String getWxOpenId(String code) throws IOException {
        String appId="wx02a2ca51087ecc34";
        String secretKey="5cf8a5ebd4a5facad5f598ae2e584dcd";
        String url=String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",appId,secretKey,code);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result=     EntityUtils.toString(entity);
                Gson g = new Gson();
                Map<String,String> map = g.fromJson(result, Map.class);
                return  map.containsKey("openid")?map.get("openid"):"";
            }
        } finally {
            response.close();
        }
        return  "";
    }


    @GetMapping("/{userId}/book")
    public   Object home(@PathVariable(value="userId") int userId) {
        ArrayList<Book> bookList= bookService.getByUserId(userId);
        List<HashMap<String, String>> list= new ArrayList<>();
        for (int i=0;i<bookList.size();i++)
        {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("imageUrl",bookList.get(i).getBookImageUrl());
            hashMap.put("bookName", bookList.get(i).getBookName());
            hashMap.put("createTime",  bookList.get(i).getBookPubdate());
            list.add(hashMap);
        }
        return list;
    }


}
