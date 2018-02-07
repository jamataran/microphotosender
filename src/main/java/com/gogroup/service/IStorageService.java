package com.gogroup.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jose on 6/2/18.
 */
public interface IStorageService {

    void store(MultipartFile file);
}
