package com.chebao;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * HttpClient进行Get通信
 * 下载:http://hc.apache.org/  -> Download  -> HttpClient 4.5.1
 */
public class Main {


    public static void main(String[] args) {

        new Get().start();
    }
}


//
class Get extends Thread{

    //创建HttpClient对象
    HttpClient client = HttpClients.createDefault();

    @Override
    public void run() {

        //get对象
        HttpGet get = new HttpGet("http://www.baidu.com");

        try {

            //连接
            HttpResponse response = client.execute(get);
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