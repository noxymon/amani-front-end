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

    public CourseResult(CourseResult existing)
    {
        this.id = existing.id;
        this.courseName =  existing.courseName;
        this.courseDescription =  existing.courseDescription;
        this.courseStartDate = existing.courseEndDate;
        this.courseEndDate = existing.courseEndDate;
        this.courseStartTime = existing.courseStartTime;
        this.courseEndTime = existing.courseEndTime;
        this.published = existing.published;
        this.courseType =  existing.courseType;
        this.instructorName =  existing.instructorName;
        this.instructorDescription =  existing.instructorDescription;
        this.webinarLink =  existing.webinarLink;
        this.latitude = existing.latitude;
        this.longitude = existing.longitude;
        this.capacity = existing.capacity;
        this.registeredCount =  existing.registeredCount;
        this.daysBeforeStartDate = existing.daysBeforeStartDate;
        this.meetingId =  existing.meetingId;
        this.courseOutline =  existing.courseOutline;
        this.alreadyJoined =  existing.alreadyJoined;
        this.openForRegistration = existing.openForRegistration;
    }

    
}
