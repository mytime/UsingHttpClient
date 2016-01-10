package com.chebao;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iwan on 16/1/10.
 */
public class HttpClientPost {
    public static void main(String[] args){
        //http://fanyi.youdao.com/openapi.do
        //keyfrom=cheboa-test&key=1383843413&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本

        new Post().start();

    }
}


class Post extends Thread{

    //创建HttpClient对象
    HttpClient client = HttpClients.createDefault();

    @Override
    public void run() {

        //post请求
        HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do");


        try {
//keyfrom=cheboa-test&key=1383843413&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本

            List<BasicNameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("keyfrom","cheboa-test"));
            parameters.add(new BasicNameValuePair("key","1383843413"));
            parameters.add(new BasicNameValuePair("type","data"));
            parameters.add(new BasicNameValuePair("doctype","xml"));
            parameters.add(new BasicNameValuePair("version","1.1"));
            parameters.add(new BasicNameValuePair("q","welcome"));



            post.setEntity(new UrlEncodedFormEntity(parameters));
            //连接
            HttpResponse response = client.execute(post);
            //实体
            HttpEntity entity = response.getEntity();
            //实体工具
            String result = EntityUtils.toString(entity,"UTF-8");

            //输出
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}