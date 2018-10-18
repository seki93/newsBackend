package news.service;

import news.model.News;

public interface NewsService {

    Iterable<News> findAll();

    public News findById(Integer id);

    void save(News news);
}
