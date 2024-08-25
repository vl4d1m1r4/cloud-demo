package dev.hili.cloud_demo.mapper;

import dev.hili.cloud_demo.controller.VisitDto;
import dev.hili.cloud_demo.model.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitMapper {
    VisitDto toDto(Visit visit);
    @Mapping(target = "id", ignore = true)
    Visit toEntity(VisitDto visitDto);
}
