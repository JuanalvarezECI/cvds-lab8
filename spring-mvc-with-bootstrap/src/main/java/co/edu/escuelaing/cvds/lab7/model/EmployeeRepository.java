package co.edu.escuelaing.cvds.lab7.model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<User, Long> {
}

