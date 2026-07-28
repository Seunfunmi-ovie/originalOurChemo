package ng.ourChemo.services;

import ng.ourChemo.data.repositories.StaffRepository;
import ng.ourChemo.data.repositories.StaffRepositoryImpl;
import ng.ourChemo.dtos.requests.LoginRequestDto;
import ng.ourChemo.dtos.requests.LogoutRequestDto;
import ng.ourChemo.dtos.requests.RegisterStaffRequestDto;
import ng.ourChemo.dtos.responses.LoginStaffResponseDto;
import ng.ourChemo.dtos.responses.LogoutStaffResponseDto;
import ng.ourChemo.dtos.responses.RegisterStaffResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffRegisterationServiceTest {

    private final StaffRepository staffRepository = new StaffRepositoryImpl();
    private final StaffRegisterationService staffRegistrationService = new StaffRegistrationServiceImpl();

    @BeforeEach
    void setUp() {
        staffRepository.deleteAll();
    }

    @Test
    public void testThatFunctionCanRegisterStaff() {
        RegisterStaffRequestDto request = new RegisterStaffRequestDto();
        request.setName("Seunfunmi");
        request.setUserName("Seunfunmi");
        request.setPassword("Olasunkanmi");
        request.setEmail("oluwaseunpu@gmail.com");

        RegisterStaffResponseDto responseDto = staffRegistrationService.registerStaff(request);

        assertEquals(request.getName(), responseDto.getUserName());
        assertEquals("Registration successful", responseDto.getMessage());
        assertEquals(1, staffRepository.count());
    }

    @Test
    public void testThatFunctionCanRegisterMultipleStaff() {
        RegisterStaffRequestDto request1 = new RegisterStaffRequestDto();
        request1.setName("Seunfunmi");
        request1.setUserName("Seunfunmi");
        request1.setPassword("Olasunkanmi");
        request1.setEmail("oluwaseunpu@gmail.com");

        RegisterStaffRequestDto request2 = new RegisterStaffRequestDto();
        request2.setName("Olasunkanmi");
        request2.setUserName("Olasunkanmi");
        request2.setPassword("Olasunkanmi1*");
        request2.setEmail("olu@gmail.com");

        RegisterStaffResponseDto responseDto1 = staffRegistrationService.registerStaff(request1);
        RegisterStaffResponseDto responseDto2 = staffRegistrationService.registerStaff(request2);

        assertEquals(request1.getName(), responseDto1.getUserName());
        assertEquals("Registration successful", responseDto1.getMessage());

        assertEquals(request2.getName(), responseDto2.getUserName());
        assertEquals("Registration successful", responseDto2.getMessage());

        assertEquals(2, staffRepository.count());
    }

    @Test
    public void testThatStaffCanLogin() {
        RegisterStaffRequestDto registerRequest = new RegisterStaffRequestDto();
        registerRequest.setName("Seunfunmi");
        registerRequest.setUserName("Seunfunmi");
        registerRequest.setPassword("Olasunkanmi");
        registerRequest.setEmail("oluwaseunpu@gmail.com");
        RegisterStaffResponseDto registerResponse = staffRegistrationService.registerStaff(registerRequest);

        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setId(registerResponse.getId());
        requestDto.setPassword("Olasunkanmi");

        LoginStaffResponseDto responseDto = staffRegistrationService.logInStaff(requestDto);

        assertEquals("Login Successful", responseDto.getMessage());
    }

    @Test
    public void testThatStaffCanRegisterAndLogin() {
        RegisterStaffRequestDto request = new RegisterStaffRequestDto();
        request.setName("Seunfunmi");
        request.setUserName("Seunfunmi");
        request.setPassword("Olasunkanmi");
        request.setEmail("oluwaseunpu@gmail.com");

        RegisterStaffResponseDto responseDto = staffRegistrationService.registerStaff(request);

        assertEquals(request.getName(), responseDto.getUserName());
        assertEquals("Registration successful", responseDto.getMessage());

        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setId(responseDto.getId());
        requestDto.setPassword("Olasunkanmi");

        LoginStaffResponseDto responseDto1 = staffRegistrationService.logInStaff(requestDto);

        assertEquals("Login Successful", responseDto1.getMessage());
    }

    @Test
    public void testThatStaffCanLoggOut() {
        RegisterStaffRequestDto registerRequest = new RegisterStaffRequestDto();
        registerRequest.setName("Seunfunmi");
        registerRequest.setUserName("Seunfunmi");
        registerRequest.setPassword("Olasunkanmi");
        registerRequest.setEmail("oluwaseunpu@gmail.com");
        RegisterStaffResponseDto registerResponse = staffRegistrationService.registerStaff(registerRequest);

        LogoutRequestDto requestDto = new LogoutRequestDto();
        requestDto.setId(registerResponse.getId());

        LogoutStaffResponseDto responseDto = staffRegistrationService.logOutStaff(requestDto);

        assertNotNull(responseDto);
        assertEquals("Logout Successful", responseDto.getMessage());
    }
}
