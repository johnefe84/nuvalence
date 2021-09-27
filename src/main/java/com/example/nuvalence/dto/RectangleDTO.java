package com.example.nuvalence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RectangleDTO {
    private Integer leftBorderPosition;
    private Integer rightBorderPosition;
    private Integer downBorderPosition;
    private Integer upBorderPosition;
}
