package id.akademi.amanifo.course.services.models;

import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class CourseResult
{
    private String id;
    private String courseName;
    private String courseDescription;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
    private LocalTime courseStartTime;
    private LocalTime courseEndTime;
    private boolean published;
    private String courseType;
    private String instructorName;
    private String instructorDescription;
    private String webinarLink;
    private Double latitude;
    private Double longitude;
    private Integer capacity;
}
