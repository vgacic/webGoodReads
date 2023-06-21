package com.tim22.web.service;

import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StavkaPoliceService {
    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    public List<StavkaPolice> findAllByKnjigaId(Long knjigaId) {
        return stavkaPoliceRepository.findAllByKnjigaId(knjigaId);
    }

    public void delete(StavkaPolice stavkaPolice) {
        stavkaPoliceRepository.delete(stavkaPolice);
    }

    public List<StavkaPolice> dobaviStavku(Long id) {
        return null;
    }
}
