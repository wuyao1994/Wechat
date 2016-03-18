package com.siping.wechat.bean.message.kefu;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PicTextMessage extends KeFuMessage {
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        JSONObject news = new JSONObject();
        JSONArray jsonArray =  new JSONArray();
        for(Article article:articles) {
            JSONObject articleJson = article.generateJsonObject();
            jsonArray.put(articleJson);
        }
        news.put("articles", jsonArray);
        jsonObject.put("news", news);
        return jsonObject;
    }
}
