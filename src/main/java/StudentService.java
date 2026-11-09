
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public Student create(String name, String email, int age) throws SQLException {
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, age);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getLong("id"), name, email, age);
                }
            }
        }
        return null;
    }
    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age")
                ));
            }
        }
        return students;
    }

    public Student getById(Long id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getLong("id"), rs.getString("name"), rs.getString("email"),
                            rs.getInt("age")
                    );
                }
            }
        }
        return null;
    }

    public boolean update(Long id, String name, String email, int age) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {stmt.setString(1, name);stmt.setString(2, email);stmt.setInt(3, age);
            stmt.setLong(4, id);

            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(Long id) throws SQLException {String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {stmt.setLong(1, id);

            return stmt.executeUpdate() > 0;
        }
    }
}
