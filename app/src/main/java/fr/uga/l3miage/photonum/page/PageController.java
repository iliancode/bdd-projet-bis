package fr.uga.l3miage.photonum.page;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.service.PageService;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PageController {

    private final PageService pageService;
    private final PageMapper pageMapper;

    @Autowired
    public PageController(PageService pageService, PageMapper pageMapper) {
        this.pageService = pageService;
        this.pageMapper = pageMapper;
    }

    @GetMapping("/pages")
    public Collection<PageDTO> getAllPages() {
        Collection<Page> pages = pageService.list();

        return pages.stream()
                .map(pageMapper::entityToDTO)
                .toList();
    }

    @PostMapping("/pages")
    @ResponseStatus(HttpStatus.CREATED)
    public PageDTO createPage(@RequestBody PageDTO page){

        var saved = pageService.save(pageMapper.dtoToEntity(page));
        return pageMapper.entityToDTO(saved);
    }

}
