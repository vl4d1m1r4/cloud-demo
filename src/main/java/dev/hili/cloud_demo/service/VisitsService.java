package dev.hili.cloud_demo.service;

import dev.hili.cloud_demo.model.Visit;
import dev.hili.cloud_demo.model.VisitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitsService {

    private final VisitsRepository visitsRepository;

    public Page<Visit> getVisits(int page, int size) {
        return visitsRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Order.desc("visitedAt"))));
    }

    public Visit addVisit(Visit visit) {
        return visitsRepository.save(visit);
    }

}
