package com.kulchuri.library.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kulchuri.library.db.LibraryDb;

public class BookDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public boolean addBook(BookDto dto) {
		boolean flag = false;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "insert into book_master(cid, bname, aname, pname, edition, price, quantity) VALUES(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getCid());
			ps.setString(2, dto.getBname());
			ps.setString(3, dto.getAname());
			ps.setString(4, dto.getPname());
			ps.setString(5, dto.getEdition());
			ps.setFloat(6, dto.getPrice());
			ps.setInt(7, dto.getQuantity());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at addBook:" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean updateBook(BookDto dto) {
		boolean flag = false;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "update book_master set cid=?, bname=?, aname=?, pname=?, edition=?, price=?, quantity=? where bid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getCid());
			ps.setString(2, dto.getBname());
			ps.setString(3, dto.getAname());
			ps.setString(4, dto.getPname());
			ps.setString(5, dto.getEdition());
			ps.setFloat(6, dto.getPrice());
			ps.setInt(7, dto.getQuantity());
			ps.setInt(8, dto.getBid());
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at updateBook:" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public boolean deleteBook(int bid) {
		boolean flag = false;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "delete from book_master where bid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			if (ps.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Exception at deleteBook:" + e);
		} finally {
			ps = null;
			conn = null;
			return flag;
		}
	}

	public ArrayList<BookDto> getAllBooks() {
		ArrayList<BookDto> list = new ArrayList<>();
		BookDto dto = null;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "select bm.* , cm.cname from book_master bm, category_master cm where bm.cid=cm.cid";
		try {
			ps = conn.prepareStatement(sql);
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

	public ArrayList<BookDto> getAllBooksByCategory(int cid) {
		ArrayList<BookDto> list = new ArrayList<>();
		BookDto dto = null;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "select *from book_master where cid=" + cid;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				dto = new BookDto();
				dto.setBid(rs.getInt("bid"));
				dto.setCid(rs.getInt("cid"));
				dto.setBname(rs.getString("bname"));
				dto.setAname(rs.getString("aname"));
				dto.setPname(rs.getString("pname"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setPrice(rs.getFloat("price"));
				dto.setEdition(rs.getString("edition"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("Exception at getAllBooksByCategory:" + e);
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

	public BookDto getBook(int bid) {
		BookDto dto = null;
		if (conn == null) {
			conn = LibraryDb.getLibrariDb();
		}
		String sql = "select bm.* , cm.cname from book_master bm, category_master cm where cm.cid=bm.cid and bm.bid="
				+ bid;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BookDto();
				dto.setBid(rs.getInt("bid"));
				dto.setCname(rs.getString("cname"));
				dto.setCid(rs.getInt("cid"));
				dto.setBname(rs.getString("bname"));
				dto.setAname(rs.getString("aname"));
				dto.setPname(rs.getString("pname"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setPrice(rs.getFloat("price"));
				dto.setEdition(rs.getString("edition"));
			}
		} catch (Exception e) {
			System.out.println("Exception at getBook:" + e);
		} finally {
			rs = null;
			ps = null;
			conn = null;
			return dto;
		}
	}
}
