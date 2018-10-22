package news.service;

import news.model.News;
import news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
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

    @Override
    public List<News> findByCategory(String category) {
        return newsRepository.findByCategory(category);
    }

    @Override
    public List<News> findByCity(String city) {
        return newsRepository.findByCity(city);
    }

    @Override
    public News findByTitle(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public List<News> findByCityAndCategory(String city, String category) {
        return newsRepository.findByCityAndCategory(city, category);
    }
}
