/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblArticle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class ArticleDAO {

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public boolean create(ArticleDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into Article values (?,?,?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, dto.getTitle());
            pst.setString(2, dto.getShortDescription());
            pst.setString(3, dto.getContent());
            pst.setTimestamp(4, dto.getPostingDate());
            pst.setString(5, dto.getStatus());
            pst.setString(6, dto.getUserEmail());
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
}
