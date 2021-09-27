package com.example.nuvalence.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SatellitePositionDTO {
    private RectangleDTO satellite;
    private PositionDTO position;
}
