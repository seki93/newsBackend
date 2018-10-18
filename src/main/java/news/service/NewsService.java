package news.service;

import news.model.News;

import java.util.List;

public interface NewsService {

    Iterable<News> findAll();

    public News findById(Integer id);

    void save(News news);

    public List<News> findByCategory(String category);

    public List<News> findByCity(String city);
}
