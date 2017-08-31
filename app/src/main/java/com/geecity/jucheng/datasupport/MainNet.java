package com.geecity.jucheng.datasupport;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.geecity.jucheng.datasupport.bean.Pictures;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainNet {

    private final Thread thread;

    public MainNet(Handler handler, String path) {
        NetThread netThread = new NetThread(handler, path);
        thread = new Thread(netThread);
    }

    public void netStart() {
        if (thread == null) return;
        thread.start();
    }

    public void netDestroy() {
        thread.destroy();
    }

    public void getPhoto(Handler mHandler, String path) {

        List<Pictures> al = new ArrayList<>();
        try {
            Document document = Jsoup.connect(path).get();
            Log.d("document" , document.data());
            Elements elements = document.select("ul.pic2").select(".vvi").select(".fix");
            for (int k = 0; k < elements.size(); k++) {
                Elements eImg;
                eImg = elements.get(k).select("img[src]");
                if (k == 1) {
                    eImg = elements.get(k).select("img[loadsrc]");
                }
                Elements eNum = elements.get(k).select("li");
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i = 0; i < eImg.size(); i++) {
                    Pictures pictures = new Pictures();
                    String imgSrc;
                    if (k == 1) {
                        imgSrc = eImg.get(i).attr("loadsrc");
                    } else {
                        imgSrc = eImg.get(i).attr("src");
                    }
                    String numText = eNum.get(i).text();
                    pictures.setpTitle(numText);
                    pictures.setpDate("2017-08-29 16:03");
                    pictures.setpImg(imgSrc);
                    pictures.setpHref(imgSrc);
                    al.add(pictures);
                }
            }
            Message message = new Message();
            message.what = 0;
            message.obj = al;
            mHandler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class NetThread implements Runnable {

        Handler handler;
        String path;

        NetThread(Handler handler, String path) {
            this.handler = handler;
            this.path = path;
        }

        @Override
        public void run() {
            getPhoto(handler, path);
        }
    }
}
