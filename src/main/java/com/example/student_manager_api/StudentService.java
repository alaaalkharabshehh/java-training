
package com.example.student_manager_api;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        return repository.findById(id).map(existing -> {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setAge(student.getAge());
            return repository.save(existing);
        });
    }

    public boolean deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
