package com.wtown.suggest.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SuggestService {

    void submitSuggest(String description, List<MultipartFile> imgs);

    String getSuffix(String fileName);
}
