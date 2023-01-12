/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblArticle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

    public List<ArticleDTO> searchWithPagination(String search, int page) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();

        try {
            String sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, u.Name\n"
                    + "from Article a\n"
                    + "join [User] u\n"
                    + "on u.Email = a.UserEmail\n"
                    + "where a.Status = 'Active' and a.Content like ?\n"
                    + "order by a.PostingDate DESC\n"
                    + "offset ? rows\n"
                    + "fetch next 20 rows only";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, page);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String shortDescription = rs.getString(3);
                Timestamp postingDate = rs.getTimestamp(4);
                String userEmail = rs.getString(5);
                String name = rs.getString(6);
                ArticleDTO dto = new ArticleDTO(id, title, shortDescription, postingDate, userEmail, name);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<ArticleDTO> search(String search) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();

        try {
            String sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, u.Name\n"
                    + "from Article a\n"
                    + "join [User] u\n"
                    + "on u.Email = a.UserEmail\n"
                    + "where a.Status = 'Active' and a.Content like ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String shortDescription = rs.getString(3);
                Timestamp postingDate = rs.getTimestamp(4);
                String userEmail = rs.getString(5);
                String name = rs.getString(6);
                ArticleDTO dto = new ArticleDTO(id, title, shortDescription, postingDate, userEmail, name);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public ArticleDTO findById(int id) throws Exception {
        ArticleDTO dto = null;

        try {
            String sql = "select a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, a.Content, u.Name\n"
                    + "from Article a\n"
                    + "join [User] u\n"
                    + "on u.Email = a.UserEmail\n"
                    + "where a.Id = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                String title = rs.getString(1);
                String shortDescription = rs.getString(2);
                Timestamp postingDate = rs.getTimestamp(3);
                String userEmail = rs.getString(4);
                String content = rs.getString(5);
                String name = rs.getString(6);
                dto = new ArticleDTO(id, title, shortDescription, postingDate, userEmail, name, content);
            }
        } finally {
            closeConnection();
        }

        return dto;
    }

    public List<ArticleDTO> searchByContentAdmin(String contentSearch, String status) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();

        try {
            String sql = "";
            if (status.equals("")) {
                sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, a.Content, a.Status, u.Name\n"
                        + "from Article a\n"
                        + "join [User] u\n"
                        + "on u.Email = a.UserEmail\n"
                        + "where a.Content like ?\n";
            } else {
                sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, a.Content, a.Status, u.Name\n"
                        + "from Article a\n"
                        + "join [User] u\n"
                        + "on u.Email = a.UserEmail\n"
                        + "where a.Status = ? and a.Content like ?\n";
            }
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            if (status.equals("")) {
                pst.setString(1, "%" + contentSearch + "%");
            } else {
                pst.setString(1, status);
                pst.setString(2, "%" + contentSearch + "%");
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String shortDescription = rs.getString(3);
                Timestamp postingDate = rs.getTimestamp(4);
                String userEmail = rs.getString(5);
                String content = rs.getString(6);
                status = rs.getString(7);
                String name = rs.getString(8);
                ArticleDTO dto = new ArticleDTO(id, title, shortDescription, postingDate, userEmail, name, content, status);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<ArticleDTO> searchByContentAdminWithPagination(String contentSearch, String status, int page) throws Exception {
        List<ArticleDTO> list = new ArrayList<>();

        try {
            String sql = "";
            if (status.equals("")) {
                sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, a.Content, a.Status, u.Name\n"
                        + "from Article a\n"
                        + "join [User] u\n"
                        + "on u.Email = a.UserEmail\n"
                        + "where a.Content like ?\n"
                        + "order by a.PostingDate DESC\n"
                        + "offset ? rows\n"
                        + "fetch next 20 rows only";
            } else {
                sql = "select a.Id, a.Title, a.ShortDescription, a.PostingDate, a.UserEmail, a.Content, a.Status, u.Name\n"
                        + "from Article a\n"
                        + "join [User] u\n"
                        + "on u.Email = a.UserEmail\n"
                        + "where a.Status = ? and a.Content like ?\n"
                        + "order by a.PostingDate DESC\n"
                        + "offset ? rows\n"
                        + "fetch next 20 rows only";
            }
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            if (status.equals("")) {
                pst.setString(1, "%" + contentSearch + "%");
                pst.setInt(2, page);
            } else {
                pst.setString(1, status);
                pst.setString(2, "%" + contentSearch + "%");
                pst.setInt(3, page);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String shortDescription = rs.getString(3);
                Timestamp postingDate = rs.getTimestamp(4);
                String userEmail = rs.getString(5);
                String content = rs.getString(6);
                status = rs.getString(7);
                String name = rs.getString(8);
                ArticleDTO dto = new ArticleDTO(id, title, shortDescription, postingDate, userEmail, name, content, status);
                list.add(dto);
            }
        } finally {
            closeConnection();
        }

        return list;
    }

    public boolean approve(int id) throws Exception {
        boolean check = false;

        try {
            String sql = "update Article set Status='Active' where id = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean delete(int id) throws Exception {
        boolean check = false;

        try {
            String sql = "update Article set Status='Deleted' where id = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
}
