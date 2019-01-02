package cn.silen_dev;

import cn.silen_dev.http.HttpUtils;
import cn.silen_dev.parse.HtmlParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //System.out.println(HttpUtils.getHtml("https://movie.douban.com/subject/26374197/"));
        HtmlParser.parseMovie(HttpUtils.getHtml("https://movie.douban.com/subject/26374197/"),26374197);
    }
}
