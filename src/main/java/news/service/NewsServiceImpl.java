package news.service;

import news.model.News;
import news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsServiceImpl implements NewsService{
    @Autowired
    NewsRepository newsRepository;

    @Override
    public Iterable<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(Integer id) {
        return newsRepository.findOne(id);
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }


}
