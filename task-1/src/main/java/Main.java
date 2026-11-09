
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentService service = new StudentService();

        for (Student student : service.getAll()) {
            System.out.println(student);
        }

        Student student1 = service.create("Lina", "lina@example.com", 22);
        Student student2 = service.create("Hala", "gala@example.com", 21);

        for (Student student : service.getAll()) {
            System.out.println(student);
        }

        if (student1 != null) {
            System.out.println(service.getById(student1.getId()));

            boolean updated = service.update(student1.getId(), "Lina Ahmad", "lina@example.com", 23);
            System.out.println("Updated: " + updated);

            for (Student student : service.getAll()) {
                System.out.println(student);
            }

            boolean deleted = service.delete(student1.getId());
            System.out.println("Deleted: " + deleted);

            for (Student student : service.getAll()) {
                System.out.println(student);
            }
        }

        Student notFound = service.getById(999999L);

        if (notFound == null) {
            System.out.println("Student not found!");
        }

        boolean deleted = service.delete(999999L);

        if (!deleted) {
            System.out.println("Cannot delete: Student not found!");
        }
    }
}
