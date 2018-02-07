package es.gogroup.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by jose on 6/2/18.
 */
@Slf4j
@Service
public class StorageServiceImpl implements IStorageService {
    @Override
    public void store(MultipartFile file) {
        log.trace("{}", file);
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Files.copy(file.getInputStream(), Paths.get("/Users/jose/PROYECTOS/@Autowired/FORMACIÓN Y PoC/spring-boot-spring-security-thymeleaf").resolve("imagen.jpg"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
