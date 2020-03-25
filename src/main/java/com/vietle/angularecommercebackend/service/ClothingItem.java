package com.vietle.angularecommercebackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class ClothingItem implements ViewItem {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Item> retrieveItems() throws EcommerceException {
        try {
            File file = ResourceUtils.getFile("classpath:clothing.items.json");
            String content = new String(Files.readAllBytes(file.toPath()));
            List<Item> clothingItems = objectMapper.readValue(content, new TypeReference<List<Item>>(){});
            return clothingItems;
        } catch (IOException fnfe) {
            throw new EcommerceException(fnfe.getMessage(), 500);
        }
    }
}

