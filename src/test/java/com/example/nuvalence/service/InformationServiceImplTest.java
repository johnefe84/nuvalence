package com.example.nuvalence.service;

import com.example.nuvalence.dto.InformationDTO;
import com.example.nuvalence.dto.RectangleDTO;
import com.example.nuvalence.service.impl.InformationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.Silent.class)
public class InformationServiceImplTest {

    @InjectMocks
    private InformationServiceImpl informationServiceImpl;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void hasIntersectionTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,2,15,6,25);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are intersected, not contained, not adjacent each other");
    }

    @Test
    public void hasNoIntersectionTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,1,10,21,31);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, not contained, not adjacent , are separated each other");
    }

    @Test
    public void isContainedTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,2,9,6,19);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, contained, not adjacent each other");
    }

    @Test
    public void isNoContainedTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,11,21,6,19);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, not contained, not adjacent , are separated each other");
    }

    @Test
    public void hasAdjacencyTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,10,21,4,19);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, not contained, adjacent each other");
    }

    @Test
    public void hasNoAdjacencyTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,15,11,21,5,15);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, not contained, not adjacent , are separated each other");
    }

    @Test
    public void squaresIntersectedAditionalCase1Test(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,2,20,4,25);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are intersected, not contained, not adjacent each other");
    }

    @Test
    public void squaresIntersectedAditionalCase2Test(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,2,8,4,25);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are intersected, not contained, not adjacent each other");
    }

    @Test
    public void squaresIntersectedAditionalCase3Test(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,2,8,4,15);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are intersected, not contained, not adjacent each other");
    }

    @Test
    public void squaresSeparatedTest(){
        informationServiceImpl = new InformationServiceImpl();

        String message = processtest(1,10,5,20,12,22,25,35);

        assertNotNull(Objects.requireNonNull(message));
        assertEquals(message, "The rectangles are not intersected, not contained, not adjacent , are separated each other");
    }

    private String processtest(Integer rectangleAx1, Integer rectangleAx2, Integer rectangleAy1, Integer rectangleAy2,
                               Integer rectangleBx1, Integer rectangleBx2, Integer rectangleBy1, Integer rectangleBy2){

        informationServiceImpl = new InformationServiceImpl();
        List<RectangleDTO> rectangles = new ArrayList<>();
        RectangleDTO rectangleA = new RectangleDTO(rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2);
        RectangleDTO rectangleB = new RectangleDTO(rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2);
        InformationDTO information = new InformationDTO();

        rectangles.add(rectangleA);
        rectangles.add(rectangleB);
        information.setRectangles(rectangles);

        return informationServiceImpl.analyseRectangles(information);
    }
}
