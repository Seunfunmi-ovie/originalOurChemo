package ng.ourChemo.services;

import ng.ourChemo.data.models.Staff;
import ng.ourChemo.data.repositories.StaffRepositoryImpl;
import ng.ourChemo.dtos.requests.LoginRequestDto;
import ng.ourChemo.dtos.requests.LogoutRequestDto;
import ng.ourChemo.dtos.requests.RegisterStaffRequestDto;
import ng.ourChemo.dtos.responses.LoginStaffResponseDto;
import ng.ourChemo.dtos.responses.LogoutStaffResponseDto;
import ng.ourChemo.dtos.responses.RegisterStaffResponseDto;

import java.util.UUID;

public class StaffRegistrationServiceImpl implements StaffRegisterationService{
    StaffRepositoryImpl staffRepository = new StaffRepositoryImpl();



    @Override
    public RegisterStaffResponseDto registerStaff(RegisterStaffRequestDto request) {
        Staff staff = new Staff();
        staff.setUsername(request.getUserName());
        staff.setName(request.getName());
        staff.setEmail(request.getEmail());
        staff.setPassword(request.getPassword());
        String id = UUID.randomUUID().toString();
        id = id.substring(0,8);
        staff.setId(id);

        Staff savedStaff = staffRepository.save(staff);

        RegisterStaffResponseDto response = new RegisterStaffResponseDto();

        response.setMessage("Registration successful");
        response.setUserName(savedStaff.getUsername());
        response.setId(savedStaff.getId());

        return response;



    }

    @Override
    public LoginStaffResponseDto logInStaff(LoginRequestDto request) {
        Staff staff = new Staff();
        staff.setName(request.getName());
        staff.setPassword(request.getPassword());

        Staff loginStaff = staffRepository.save(staff);

        LoginStaffResponseDto responseDto = new LoginStaffResponseDto();

        responseDto.setMessage("Login Successful");
        responseDto.setName(loginStaff.getName());

        return responseDto;
    }

    @Override
    public LogoutStaffResponseDto logOutStaff(LogoutRequestDto request) {
        Staff existingStaff = staffRepository.findById(request.getId());
        if (existingStaff == null) {
            throw new IllegalArgumentException("Staff member not found");
        }

        LogoutStaffResponseDto responseDto = new LogoutStaffResponseDto();
        responseDto.setMessage("Logout Successful");

        return responseDto;
    }
}



