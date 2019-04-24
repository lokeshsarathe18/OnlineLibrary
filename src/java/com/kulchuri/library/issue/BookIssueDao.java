package com.kulchuri.library.issue;

import com.kulchuri.library.book.BookDto;
import com.kulchuri.library.db.LibraryDb;
import com.kulchuri.library.utility.LibraryDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookIssueDao {

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public BookIssueDao() {
    }

    public boolean issueBook(BookIssueBean bib) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "insert into issue_master( bid, sid, status, idate, fine, day) values(?,?,?,?,?,?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bib.getBid());
            ps.setInt(2, bib.getSid());
            ps.setInt(3, 1);
            ps.setString(4, LibraryDate.getCurrentDate());
            ps.setFloat(5, 0.0f);
            ps.setInt(6, 0);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Exception at issueBook:" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public int getTotalIssueBooks(int bid) {
        int total = 0;
        String sql = "SELECT count(bid) as total FROM issue_master where bid=? and status=1";
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bid);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            System.out.println("");
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return total;
        }
    }

    public boolean bookReturn(BookIssueBean bean) {
        boolean flag = false;
        String sql = "update issue_master set status=0,day=?,fine=?,rdate=? where biid=? and sid=?";
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bean.getDay());
            ps.setFloat(2, bean.getFine());
            ps.setString(3, bean.getRdate());
            ps.setInt(4, bean.getBiid());
            ps.setInt(5, bean.getSid());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("Execption at bookReturn:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<BookDto> getAllIssuedBooks(int sid) {
        ArrayList<BookDto> list = new ArrayList<>();
        BookDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select bm.* ,im.idate, cm.cname from book_master bm, issue_master im, category_master cm where bm.cid=cm.cid and im.bid=bm.bid and im.sid=? and im.status=1";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new BookDto();
                dto.setBid(rs.getInt("bid"));
                dto.setCid(rs.getInt("cid"));
                dto.setCname(rs.getString("cname"));
                dto.setBname(rs.getString("bname"));
                dto.setAname(rs.getString("aname"));
                dto.setPname(rs.getString("pname"));
                dto.setQuantity(rs.getInt("quantity"));
                dto.setPrice(rs.getFloat("price"));
                dto.setEdition(rs.getString("edition"));
                dto.setIdate(rs.getString("idate"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllBooks:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
    }

    public ArrayList<BookDto> getHistory(int sid) {
        ArrayList<BookDto> list = new ArrayList<>();
        BookDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select bm.* ,im.idate,im.rdate, cm.cname from book_master bm, issue_master im, category_master cm where bm.cid=cm.cid and im.bid=bm.bid and im.sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new BookDto();
                dto.setBid(rs.getInt("bid"));
                dto.setCid(rs.getInt("cid"));
                dto.setRdate(rs.getString("rdate"));
                dto.setCname(rs.getString("cname"));
                dto.setBname(rs.getString("bname"));
                dto.setAname(rs.getString("aname"));
                dto.setPname(rs.getString("pname"));
                dto.setQuantity(rs.getInt("quantity"));
                dto.setPrice(rs.getFloat("price"));
                dto.setEdition(rs.getString("edition"));
                dto.setIdate(rs.getString("idate"));
                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("Exception at getAllBooks:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            if (list.isEmpty()) {
                list = null;
            }
            return list;
        }
    }

    public String getIssuedBooks(BookIssueBean bean) {
        String idate = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select idate from issue_master where  sid=? and biid=? and bid=? and status=1";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bean.getSid());
            ps.setInt(2, bean.getBiid());
            ps.setInt(3, bean.getBid());
            rs = ps.executeQuery();
            if (rs.next()) {
                idate = rs.getString("idate");
            }
        } catch (SQLException e) {
            System.out.println("Exception at getIssuedBooks:" + e);
        } finally {
            rs = null;
            ps = null;
            conn = null;
            return idate;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BookIssueDao().getTotalIssueBooks(21));
    }
}
