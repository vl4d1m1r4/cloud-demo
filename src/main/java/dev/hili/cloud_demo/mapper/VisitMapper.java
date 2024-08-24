package dev.hili.cloud_demo.mapper;

import dev.hili.cloud_demo.controller.VisitDto;
import dev.hili.cloud_demo.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDto toDto(Visit visit);
    Visit toEntity(VisitDto visitDto);
}
