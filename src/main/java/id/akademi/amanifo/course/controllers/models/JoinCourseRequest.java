package id.akademi.amanifo.course.controllers.models;

import lombok.Getter;

@Getter
public class JoinCourseRequest
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String memberType;
}

