package com.kulchuri.library.student;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kulchuri.library.db.LibraryDb;
import com.kulchuri.library.utility.LibraryDate;
import com.kulchuri.library.utility.LibraryPassword;
import java.util.Base64;

public class StudentDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public StudentDao() {
        // TODO Auto-generated constructor stub
    }

    public boolean addStudent(StudentDto dto, InputStream photo) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "insert into student_master(status, sname, gender, mno, photo, dob, dor, email, pwd)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println(conn);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, dto.getSname());
            ps.setString(3, dto.getGender());
            ps.setString(4, dto.getMno());
            ps.setBlob(5, photo);
            ps.setString(6, dto.getDob());
            ps.setString(7, LibraryDate.getCurrentDate());
            ps.setString(8, dto.getEmail());
            ps.setString(9, LibraryPassword.encrypt(dto.getPwd()));
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("exception at addStudent" + e);

        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean updateStudent(StudentDto dto) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "update student_master where status=?, sname=?, gender=?, mno=?, photo=?, dob=?, dor=?, email=?, pwd=? where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getStatus());
            ps.setString(2, dto.getSname());
            ps.setString(3, dto.getGender());
            ps.setString(4, dto.getMno());
            ps.setString(5, dto.getPhoto());
            ps.setString(6, dto.getDob());
            ps.setString(7, dto.getDor());
            ps.setString(8, dto.getEmail());
            ps.setString(9, dto.getPwd());
            ps.setInt(10, dto.getSid());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("exception at updateStudent" + e);

        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean deleteStudent(int sid) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "delete  from student_master where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("exception at deletion" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean activeStudent(int sid) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "update student_master set status=? where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, sid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("exception at activeStudent" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public boolean nonActiveStudent(int sid) {
        boolean flag = false;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "update student_master set status=? where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, sid);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            System.out.println("exception at nonActiveStudent" + e);
        } finally {
            ps = null;
            conn = null;
            return flag;
        }
    }

    public ArrayList<StudentDto> getAllStudents() {
        ArrayList<StudentDto> list = new ArrayList<>();
        StudentDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select * from student_master";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setSid(rs.getInt("sid"));
                dto.setSname(rs.getString("sname"));
                dto.setStatus(rs.getInt("status"));
                dto.setMno(rs.getString("mno"));
                dto.setDob(rs.getString("dob"));
                dto.setDor(rs.getString("email"));
                dto.setGender(rs.getString("gender"));
                dto.setPhoto(Base64.getEncoder().encodeToString(rs.getBytes("photo")));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                list.add(dto);
            }

        } catch (Exception e) {
            System.out.println("exception at getallStudents" + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
            return list;
        }
    }

    public ArrayList<StudentDto> getAllNonActiveStudents() {
        ArrayList<StudentDto> list = new ArrayList<>();
        StudentDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select * from student_master where status=0";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setSid(rs.getInt("sid"));
                dto.setSname(rs.getString("sname"));
                dto.setStatus(rs.getInt("status"));
                dto.setMno(rs.getString("mno"));
                dto.setDob(rs.getString("dob"));
                dto.setDor(rs.getString("email"));
                dto.setGender(rs.getString("gender"));
                dto.setPhoto(Base64.getEncoder().encodeToString(rs.getBytes("photo")));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                list.add(dto);
            }

        } catch (Exception e) {
            System.out.println("exception at getAllNonActiveStudents" + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
            return list;
        }
    }

    public ArrayList<StudentDto> getAllActiveStudents() {
        ArrayList<StudentDto> list = new ArrayList<>();
        StudentDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select * from student_master where status=1";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setSid(rs.getInt("sid"));
                dto.setSname(rs.getString("sname"));
                dto.setStatus(rs.getInt("status"));
                dto.setMno(rs.getString("mno"));
                dto.setDob(rs.getString("dob"));
                dto.setDor(rs.getString("email"));
                dto.setGender(rs.getString("gender"));
                dto.setPhoto(Base64.getEncoder().encodeToString(rs.getBytes("photo")));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
                list.add(dto);
            }

        } catch (Exception e) {
            System.out.println("exception at getAllActiveStudents" + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
            return list;
        }
    }

    public StudentDto getStudent(int sid) {
        StudentDto dto = null;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select * from student_master where=" + sid;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                dto = new StudentDto();
                dto.setSid(rs.getInt("sid"));
                dto.setSname(rs.getString("sname"));
                dto.setStatus(rs.getInt("status"));
                dto.setMno(rs.getString("mno"));
                dto.setDob(rs.getString("dob"));
                dto.setDor(rs.getString("email"));
                dto.setGender(rs.getString("gender"));
                dto.setPhoto(rs.getString("photo"));
                dto.setPwd(rs.getString("pwd"));
                dto.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("exception at getStudent" + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
            return dto;
        }
    }

    public int loginStudent(String email, String pwd) {
        int sid = 0;
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select sid from student_master where email=? and pwd=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, LibraryPassword.encrypt(pwd));
            rs = ps.executeQuery();
            if (rs.next()) {
                sid = rs.getInt("sid");
            }
        } catch (Exception e) {
            System.out.println("Exception at loginStudent:" + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
            return sid;
        }
    }

    public void getPwd(String email) {
        if (conn == null) {
            conn = LibraryDb.getLibrariDb();
        }
        String sql = "select pwd from student_master where email=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Pwd = " + LibraryPassword.decrypt(rs.getString("pwd")));
            }
        } catch (Exception e) {
            System.out.println("Exception at getPwd: " + e);
        } finally {
            ps = null;
            rs = null;
            conn = null;
        }
    }
    public static  void main(String args[]){
        new StudentDao().getPwd("aman@gmail.com");
    }
}
