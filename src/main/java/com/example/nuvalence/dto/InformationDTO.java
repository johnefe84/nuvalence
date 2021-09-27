package com.example.nuvalence.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InformationDTO {
    private List<RectangleDTO> rectangles;
}
