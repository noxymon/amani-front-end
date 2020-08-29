package id.akademi.amanifo.course.services.models;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
    private boolean   openForRegistration;
    private String    floorImage;
    private String    courseDetailImage;
    private boolean   alreadyStart;

    public CourseResult(CourseResult other)
    {
        this.id = other.id;
        this.courseName = other.courseName;
        this.courseDescription = other.courseDescription;
        this.courseStartDate = other.courseStartDate;
        this.courseEndDate = other.courseEndDate;
        this.courseStartTime = other.courseStartTime;
        this.courseEndTime = other.courseEndTime;
        this.published = other.published;
        this.courseType = other.courseType;
        this.instructorName = other.instructorName;
        this.instructorDescription = other.instructorDescription;
        this.webinarLink = other.webinarLink;
        this.latitude = other.latitude;
        this.longitude = other.longitude;
        this.capacity = other.capacity;
        this.registeredCount = other.registeredCount;
        this.daysBeforeStartDate = other.daysBeforeStartDate;
        this.meetingId = other.meetingId;
        this.courseOutline = other.courseOutline;
        this.alreadyJoined = other.alreadyJoined;
        this.openForRegistration = other.openForRegistration;
        this.floorImage = other.floorImage;
        this.courseDetailImage = other.courseDetailImage;
    }
}
