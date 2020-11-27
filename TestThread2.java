package com.multi_thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
// 看到p5
public class TestThread2 extends Thread {
    private String url;
    private String name;
    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载的文件名为： " + name);
    }

    public static void main(String[] args) {
        TestThread2[] ts = new TestThread2[11];
        for(int i=0; i<11; i++) {
            ts[i] = new TestThread2("https://www.baidu.com/img/PCdong_eab05f3d3a8e54ca5a0817f09b39d463.gif", i+".jpg");;
        }
        for (TestThread2 t : ts) {
            t.start();
        }
    }
}

class WebDownloader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
            System.out.println(Thread.currentThread()+"下载完成");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}