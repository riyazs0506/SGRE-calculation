package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Scheme;
import net.javaguides.springboot.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schemes")
public class MyRestController {
    @Autowired
    private SchemeService schemeService;

    @PostMapping("/save")
    public Scheme saveScheme(@RequestBody Scheme scheme) {
        return schemeService.saveScheme(scheme);
    }
}
