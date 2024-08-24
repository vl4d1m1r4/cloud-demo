package dev.hili.cloud_demo.controller;

import dev.hili.cloud_demo.mapper.VisitMapper;
import dev.hili.cloud_demo.model.Visit;
import dev.hili.cloud_demo.service.VisitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitsController {

    private final VisitsService visitsService;
    private final VisitMapper visitMapper;

    @GetMapping
    public Page<VisitDto> getVisits(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {

        Page<Visit> visits = visitsService.getVisits(page, size);
        return visits.map(visitMapper::toDto);
    }

    @PostMapping
    public VisitDto addVisit(@RequestBody VisitDto visit, @RequestHeader("User-Agent") String browserAgent) {
        Visit entity = visitMapper.toEntity(visit);
        entity.setBrowserAgent(browserAgent);
        entity.setVisitedAt(ZonedDateTime.now());
        return visitMapper.toDto(visitsService.addVisit(entity));
    }

}
