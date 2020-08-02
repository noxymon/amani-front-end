package id.akademi.amanifo.registration.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberType {
    REGULER("REGULER", "Reguler Type Member"), COMPANY("COMPANY", "Company Type Member");

    private final String memberTypeId;
    private final String description;
}