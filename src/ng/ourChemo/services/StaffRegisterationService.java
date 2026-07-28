package ng.ourChemo.services;

import ng.ourChemo.dtos.requests.LoginRequestDto;
import ng.ourChemo.dtos.requests.LogoutRequestDto;
import ng.ourChemo.dtos.requests.RegisterStaffRequestDto;
import ng.ourChemo.dtos.responses.LoginStaffResponseDto;
import ng.ourChemo.dtos.responses.LogoutStaffResponseDto;
import ng.ourChemo.dtos.responses.RegisterStaffResponseDto;

public interface StaffRegisterationService {

    RegisterStaffResponseDto registerStaff(RegisterStaffRequestDto request);
    LoginStaffResponseDto logInStaff(LoginRequestDto request);
    LogoutStaffResponseDto logOutStaff(LogoutRequestDto request);

}
