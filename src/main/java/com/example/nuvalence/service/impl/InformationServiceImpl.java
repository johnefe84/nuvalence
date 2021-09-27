package com.example.nuvalence.service.impl;

import com.example.nuvalence.dto.InformationDTO;
import com.example.nuvalence.dto.RectangleDTO;
import com.example.nuvalence.service.InformationService;
import org.springframework.stereotype.Component;

@Component
public class InformationServiceImpl implements InformationService {
    
    /**
     * This method takes the rectangles's coordinates and evaluates if their are
     * intersected, contained or adjacent each other
     *
     * @param information Contains the information of the coordinates of both rectangles
     */
    @Override
    public String analyseRectangles(InformationDTO information) {
        String response = "The rectangles are ";
        int coincidence = 0;
        RectangleDTO rectangleA = information.getRectangles().get(0);
        RectangleDTO rectangleB = information.getRectangles().get(1);

        Integer rectangleAx1 = rectangleA.getLeftBorderPosition();
        Integer rectangleAx2 = rectangleA.getRightBorderPosition();
        Integer rectangleAy1 = rectangleA.getDownBorderPosition();
        Integer rectangleAy2 = rectangleA.getUpBorderPosition();

        Integer rectangleBx1 = rectangleB.getLeftBorderPosition();
        Integer rectangleBx2 = rectangleB.getRightBorderPosition();
        Integer rectangleBy1 = rectangleB.getDownBorderPosition();
        Integer rectangleBy2 = rectangleB.getUpBorderPosition();

        Boolean intersected = isIntersected(rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2) ||
                isIntersected(rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2, rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2);

        Boolean contained = isContained(rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2) ||
                isContained(rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2, rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2);

        Boolean adjacent = hasAdjacency(rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2) ||
                isContained(rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2, rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2);

        if(intersected){
            response = response.concat("intersected, ");
            coincidence++;
        }
        else{
            response = response.concat("not intersected, ");
        }

        if(contained){
            response = response.concat("contained, ");
            coincidence++;
        }
        else{
            response = response.concat("not contained, ");
        }

        if(adjacent){
            response = response.concat("adjacent ");
            coincidence++;
        }
        else{
            response = response.concat("not adjacent ");
        }


        if (coincidence == 0){
            response = response.concat(", are separated ");
        }

        return response.concat("each other");
    }

    /**
     *
     *
     * @param rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2
     * each one of the corners of each square
     */
    private Boolean isIntersected(Integer rectangleAx1, Integer rectangleAx2, Integer rectangleAy1, Integer rectangleAy2,
                                    Integer rectangleBx1, Integer rectangleBx2, Integer rectangleBy1, Integer rectangleBy2) {
        Boolean intersected = false;

        if((rectangleAx1 < rectangleBx1 && rectangleAx2 < rectangleBx2 && rectangleAx2 > rectangleBx1 && rectangleAy2 != rectangleBy1 && rectangleAy1 != rectangleBy2) ||
                (rectangleAx1 < rectangleBx1 && rectangleAx2 > rectangleBx2 && rectangleAx2 > rectangleBx1 && ((rectangleBy1 < rectangleAy1 && rectangleBy2 < rectangleBx2) || (rectangleBy1 > rectangleAy1 && rectangleBy2 > rectangleBx2 && rectangleAy2 < rectangleBy2) || (rectangleBy1 < rectangleAy1 && rectangleBy2 > rectangleBx2))) ||
                (rectangleAy1 < rectangleBy1 && rectangleAy2 < rectangleBy2 && rectangleAy2 > rectangleBy1 && rectangleAx2 != rectangleBx1 && rectangleAx1 != rectangleBx2)
        ){
            intersected = true;
        }
        return intersected;
    }

    /**
     *
     *
     * @param rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2
     * each one of the corners of each square
     */
    private Boolean isContained(Integer rectangleAx1, Integer rectangleAx2, Integer rectangleAy1, Integer rectangleAy2,
                                Integer rectangleBx1, Integer rectangleBx2, Integer rectangleBy1, Integer rectangleBy2){
        Boolean contained = false;

        if(rectangleAx1 < rectangleBx1 && rectangleAx2 > rectangleBx2 &&
                rectangleAy2 > rectangleBy2 && rectangleAy1 < rectangleBy1){
            contained = true;
        }
        return contained;
    }

    /**
     *
     *
     * @param rectangleAx1, rectangleAx2, rectangleAy1, rectangleAy2, rectangleBx1, rectangleBx2, rectangleBy1, rectangleBy2
     * each one of the corners of each square
     */
    private Boolean hasAdjacency(Integer rectangleAx1, Integer rectangleAx2, Integer rectangleAy1, Integer rectangleAy2,
                                 Integer rectangleBx1, Integer rectangleBx2, Integer rectangleBy1, Integer rectangleBy2) {
        Boolean adjacented = false;

        if(rectangleAx2 == rectangleBx1 ||
                rectangleAx1 == rectangleBx2 ||
                rectangleAy2 == rectangleBy1 ||
                rectangleAy1 == rectangleBy2){
            adjacented = true;
        }
        return adjacented;
    }
}
