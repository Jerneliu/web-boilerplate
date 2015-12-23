package github.yukinami.webboilerplate.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author snowblink on 15/11/3.
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
