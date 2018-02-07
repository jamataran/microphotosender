package es.gogroup.controller;

import es.gogroup.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class DefaultController {

    @Autowired
    private IStorageService iStorageService;

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @PostMapping("/gophoto")
    public String goFoto(@RequestParam("file") MultipartFile file,
                         @RequestParam("email") String email,
                         RedirectAttributes redirectAttributes) {

        // Proceso.
        log.debug("Trying to process image {} for {}", file, email);
        iStorageService.store(file);

        // Volvemos a la pagina donde estabamos.
        return "/admin";
    }

}
