package news.repository;

import news.model.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends CrudRepository<News, Integer> {

    @Query(
            value = "SELECT n FROM news n WHERE n.category = :category",
            nativeQuery = true
    )
    List<News> findByCategory(@Param("category") String category);

    @Query(
            value = "SELECT n FROM news n WHERE n.city = :city",
            nativeQuery = true
    )
    List<News> findByCity(@Param("city") String city);
}
