/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.ConnectDB;

/**
 *
 * @author lehuuhieu
 */
public class UserDAO {

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

    public boolean create(String email, String name, String password, String role, String status, String code) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into [User] values (?,?,?,?,?,?)";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, name);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setString(5, status);
            pst.setString(6, code);
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean checkLogin(String email, String password) throws Exception {
        boolean check = false;
        try {
            String sql = "select Role\n"
                    + "from [User]\n"
                    + "where Email = ? and Password = ? and Status = 'New'";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public UserDTO findUserByEmail(String email) throws Exception {
        UserDTO dto = null;
        try {
            String sql = "select Name, Role, Status\n"
                    + "from [User]\n"
                    + "where Email = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String role = rs.getString(2);
                String status = rs.getString(3);
                dto = new UserDTO(email, name, null, role, status, null);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean checkCode(String email, String code) throws Exception {
        boolean check = false;

        try {
            String sql = "select Name\n"
                    + "from [User]\n"
                    + "where Email = ? and Code = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, code);
            rs = pst.executeQuery();
            while (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean updateStatus(String email, String status) throws Exception {
        boolean check = false;

        try {
            String sql = "update [User] set Status = 'New' where Email = ?";
            con = ConnectDB.makeConnnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
}
