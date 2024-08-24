package dev.hili.cloud_demo.controller;

import java.time.ZonedDateTime;

public record VisitDto(String name, String browserAgent, ZonedDateTime visitedAt) {
}
