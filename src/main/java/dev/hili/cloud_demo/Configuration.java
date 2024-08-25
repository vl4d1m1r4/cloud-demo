package dev.hili.cloud_demo;

import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@org.springframework.context.annotation.Configuration
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class Configuration {
}
