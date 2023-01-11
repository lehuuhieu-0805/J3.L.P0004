/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblComment;

import java.io.Serializable;

/**
 *
 * @author lehuuhieu
 */
public class CommentDTO implements Serializable {

    private int id, articleId;
    private String description, userEmail, userName;

    public CommentDTO() {
    }

    public CommentDTO(int id, int articleId, String description, String userEmail, String userName) {
        this.id = id;
        this.articleId = articleId;
        this.description = description;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public CommentDTO(int articleId, String description, String userEmail) {
        this.articleId = articleId;
        this.description = description;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
