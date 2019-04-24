package com.kulchuri.library.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kulchuri.library.db.LibraryDb;

public class CategoryDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public CategoryDao() {
    }

    public boolean addCategory(CategoryDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {
            String sql = "insert into category_master(cname) values(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getCname());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at addCategory:" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean updateCategory(CategoryDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {
            String sql = "update category_master set cname=? where cid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getCname());
            ps.setInt(2, dto.getCid());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at updateCategory:" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean deleteCategory(int cid) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {
            String sql = "delete from category_master where cid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at deleteCategory:" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<CategoryDto> getAllCategories() {
        ArrayList<CategoryDto> list = new ArrayList();
        CategoryDto dto;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {

            String sql = "select *from category_master";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new CategoryDto();
                dto.setCid(rs.getInt("cid"));
                dto.setCname(rs.getString("cname"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllCategories:" + e);

        } finally {
            if (list.isEmpty()) {
                list = null;
            }
            rs = null;
            ps = null;
            conn = null;
            return list;
        }
    }

    public CategoryDto getCategory(int cid) {
        CategoryDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {

            String sql = "select *from category_master where cid=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            if (rs.next()) {
                dto = new CategoryDto();
                dto.setCid(rs.getInt("cid"));
                dto.setCname(rs.getString("cname"));
            }

        } catch (Exception e) {
            System.out.println("Exception at getCategory:" + e);
        } finally {

            rs = null;
            ps = null;
            conn = null;
            return dto;
        }
    }
}
