package com.bihu.xinwen.entrty;

/**
 * Created by luo on 2016/9/8.
 */
public class NewsEntrty {
    //标题
    private String title;
    //产生时间
    private long date;
    //新闻来源
    private String source;

    public NewsEntrty() {
    }

    public NewsEntrty(String title, long date, String source) {
        this.title = title;
        this.date = date;
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
