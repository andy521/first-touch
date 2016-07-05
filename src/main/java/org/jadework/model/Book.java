package org.jadework.model;

import java.io.Serializable;
import java.util.Date;
import java.util.IdentityHashMap;

/**
 * Book 实体类
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/4/9
 */

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookName;
    private String bookAuthor;
    /**
     * http://www.lingoes.cn/zh/translator/langcode.htm
     */
    private String bookLanguage;
    private Integer bookVersion;
    /**
     * 折旧度
     */
    private Integer bookDepreciation;
    private Float bookPrice;
    /** 库存 */
    private Integer bookStock;
    private String bookTags;
    private String bookImageUrl;
    private String bookDescription;
    private Date bookCreateTime;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public Integer getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(Integer bookVersion) {
        this.bookVersion = bookVersion;
    }

    public Integer getBookDepreciation() {
        return bookDepreciation;
    }

    public void setBookDepreciation(Integer bookDepreciation) {
        this.bookDepreciation = bookDepreciation;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookTags() {
        return bookTags;
    }

    public void setBookTags(String bookTags) {
        this.bookTags = bookTags;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Date getBookCreateTime() {
        return bookCreateTime;
    }

    public void setBookCreateTime(Date bookCreateTime) {
        this.bookCreateTime = bookCreateTime;
    }
}
