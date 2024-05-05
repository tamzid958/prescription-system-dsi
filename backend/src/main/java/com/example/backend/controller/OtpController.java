package com.example.backend.controller;

import com.example.backend.dto.OtpDto;
import com.example.backend.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/otp")
public class OtpController {
    @Autowired
    private OtpService otpService;
    @GetMapping("/send")
    public Long sendSMS(@RequestParam String email) {
        if(email == null) return null;
        return otpService.createOtp(email);
    }

    @PostMapping("/verify")
    public Boolean verifyOtp(@RequestBody OtpDto otpDto){
        return otpService.validateOtp(otpDto);
    }
}
