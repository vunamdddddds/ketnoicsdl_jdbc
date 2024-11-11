/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.mvstudentmanagement;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

/**
 *
 * @author VUDUYKHUONG
 */
public class StudentDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/quanlysv";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "vtn26112005"; // Thay "password" bằng mật khẩu của bạn

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // Thêm sinh viên
    public void insertStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.executeUpdate();
        }
    }

    // Cập nhật sinh viên
    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET name=?, age=? WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setInt(3, student.getId());
            pstmt.executeUpdate();
        }
    }

    // Xóa sinh viên
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Lấy danh sách sinh viên
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = getConnection();
             java.sql.Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                ));
            }
        }
        return students;
    }
}
