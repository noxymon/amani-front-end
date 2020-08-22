package id.akademi.amanifo.course.services.models;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;

@Getter
public class CourseResult
{
    private String    id;
    private String    courseName;
    private String    courseDescription;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
    private LocalTime courseStartTime;
    private LocalTime courseEndTime;
    private boolean   published;
    private String    courseType;
    private String    instructorName;
    private String    instructorDescription;
    private String    webinarLink;
    private Double    latitude;
    private Double    longitude;
    private Integer   capacity;
    private Integer   registeredCount;
    private Long      daysBeforeStartDate;
    private String    meetingId;
    private String    courseOutline;
    private boolean   alreadyJoined;
}