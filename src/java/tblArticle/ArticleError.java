/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblArticle;

/**
 *
 * @author lehuuhieu
 */
public class ArticleError {

    private String titleError, shortDescriptionError, contentError;

    public ArticleError() {
    }

    public ArticleError(String titleError, String shortDescriptionError, String contentError) {
        this.titleError = titleError;
        this.shortDescriptionError = shortDescriptionError;
        this.contentError = contentError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getShortDescriptionError() {
        return shortDescriptionError;
    }

    public void setShortDescriptionError(String shortDescriptionError) {
        this.shortDescriptionError = shortDescriptionError;
    }

    public String getContentError() {
        return contentError;
    }

    public void setContentError(String contentError) {
        this.contentError = contentError;
    }

}
