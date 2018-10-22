package news.service;

import news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsService {

    Iterable<News> findAll();

    News findById(Integer id);

    void save(News news);

    List<News> findByCategory(String category);

    List<News> findByCity(String city);

    News findByTitle(String title);

    List<News> findByCityAndCategory(String city, String category);
}
