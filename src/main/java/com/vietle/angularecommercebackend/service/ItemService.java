package com.vietle.angularecommercebackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.security.JwtTokenProvider;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public Item retrieveItem(int id, int category, HttpServletRequest req) throws EcommerceException {
        try {
            String jsonFile = EcommerceUtil.getJSONFileBasedOnCategory(category);
            File file = ResourceUtils.getFile("classpath:"+jsonFile);
            String content = new String(Files.readAllBytes(file.toPath()));
            List<Item> items = objectMapper.readValue(content, new TypeReference<List<Item>>(){});
            Item itemFound = items.stream()
                    .filter(item -> item.getId() == id && item.getCategory() == category)
                    .findAny().orElseThrow(() -> new EcommerceException("Item not found!", 500));
            return itemFound;
        } catch (IOException fnfe) {
            throw new EcommerceException(fnfe.getMessage(), 500);
        }
    }
}
