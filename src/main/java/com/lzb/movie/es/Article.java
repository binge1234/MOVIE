package com.lzb.movie.es;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import java.io.Serializable;

//@Document(indexName = "mv_article",type = "article")
//public class Article implements Serializable {
//
//    @Id
//    private String id;
//    //是否索引，就是看该域是否能被搜索
//    //是否分词，就表示搜索的时候是整体匹配还是单词匹配
//    //是否存储，
//    @Field(index = FieldIndex.analyzed)
//    private String title;
//
//
//    private String content;
//
//    private String status;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getStatus() {
//        return status;
//    }

//    public void setStatus(String status) {
//        this.status = status;
//    }
//}
