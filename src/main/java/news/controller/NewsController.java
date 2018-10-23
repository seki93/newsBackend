package news.controller;

import news.model.News;
import news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(path = "/all")
    public Iterable<News> getAll(){
        return newsService.findAll();
    }

    @GetMapping(path = "/add")
    public String addNews(@RequestParam String title,
                        @RequestParam String description,
                        @RequestParam String text,
                        @RequestParam String stringDate,
                        @RequestParam String category,
                        @RequestParam String city,
                          @RequestParam String pathToPicture) {
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);

            News news = new News(title, description, text, date, true, category, city, pathToPicture);

            newsService.save(news);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return "Added new News";
    }

    @GetMapping(path = "/city")
    public Iterable<News> getByCity(@RequestParam String city){
        return newsService.findByCity(city);
    }

    @GetMapping(path = "/delete")
    public String deleteNewsByTitle(@RequestParam String title) {
        News news = newsService.findByTitle(title);
        news.setActive(false);

        return "Wonderful! You are now deleted some news!";
    }

    @GetMapping(path = "/cityAndCategory")
    public Iterable<News> getByCityAndCategory(@RequestParam String city,
                                               @RequestParam String category) {
        return newsService.findByCityAndCategory(city, category);
    }
}
