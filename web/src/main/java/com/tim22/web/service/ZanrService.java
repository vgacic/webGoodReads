package com.tim22.web.service;

import com.tim22.web.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;
}
