package id.akademi.amanifo.registration.services;

import id.akademi.amanifo.registration.services.models.MemberRegisterParam;
import id.akademi.amanifo.registration.services.models.MemberRegisterResult;

public interface IMemberRegister {
    MemberRegisterResult register(MemberRegisterParam memberRegisterParam);
}