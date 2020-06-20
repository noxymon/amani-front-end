package id.akademi.amanifo.login.services;

import id.akademi.amanifo.login.services.models.MemberLoginParameter;
import id.akademi.amanifo.login.services.models.MemberLoginResult;

public interface IMemberLogin {
    MemberLoginResult login(MemberLoginParameter memberLoginParameter);
}