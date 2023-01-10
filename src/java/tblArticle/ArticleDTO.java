/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblArticle;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author lehuuhieu
 */
public class ArticleDTO implements Serializable {

    private int id;
    private String title, shortDescription, content, status, userEmail;
    private Timestamp postingDate;

    public ArticleDTO() {
    }

    public ArticleDTO(int id, String title, String shortDescription, String content, String status, String userEmail, Timestamp postingDate) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.content = content;
        this.status = status;
        this.userEmail = userEmail;
        this.postingDate = postingDate;
    }

    public ArticleDTO(String title, String shortDescription, String content, String status, String userEmail, Timestamp postingDate) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.content = content;
        this.status = status;
        this.userEmail = userEmail;
        this.postingDate = postingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Timestamp getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Timestamp postingDate) {
        this.postingDate = postingDate;
    }

}
