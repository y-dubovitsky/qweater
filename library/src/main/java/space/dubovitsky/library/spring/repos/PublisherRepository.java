package space.dubovitsky.library.spring.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.library.domain.Publisher;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Page<Publisher> findByNameContainingIgnoreCaseOrderByName(PageRequest pageRequest, Sort sort, String... name);

    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String... name);

}
