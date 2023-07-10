package springblog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springblog.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Add custom methods for user-related operations if needed

}

