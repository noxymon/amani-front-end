package id.akademi.amanifo.course.controllers.models;

import id.akademi.amanifo.course.services.models.JoinCourseApiResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseResponse
{
    private Double amount;
    private Double amountFinal;
    private String transactionStatus;

    private final String transcationId;

    public static JoinCourseResponse from(JoinCourseApiResponse apiResponse)
    {
        return JoinCourseResponse
          .builder()
          .amount(apiResponse.getAmount())
          .amountFinal(apiResponse.getAmountFinal())
          .transcationId(apiResponse.getTranscationId())
          .transactionStatus(apiResponse.getTransactionStatus())
          .build();
    }
}
