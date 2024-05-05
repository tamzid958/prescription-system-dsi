package com.example.backend.service;


import com.example.backend.dto.OtpDto;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    public Long createOtp(String email){

        Optional<User> OptionalUser = userRepository.findByEmail(email);

        User user = OptionalUser.orElseThrow(()->new NoSuchElementException("No user found with this email "+email));

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);
        user.setVerificationCodeSendTime(formattedDateTime);

        Random r = new Random();
        String randomNumber = String.format("%04d", (Object) r.nextInt(1001));
        user.setVerificationCode(randomNumber);
        emailService.sendEmail(email,"Verification Code",user.getVerificationCode());

        return user.getId();

    }

    public boolean validateOtp(OtpDto otpDto){
        Optional<User> OptionalUser = userRepository.findById(otpDto.getId());
        User user = OptionalUser.orElseThrow(()->new NoSuchElementException("No user found with this id "+otpDto.getId()));


            if(Objects.equals(user.getVerificationCode(), otpDto.getValue())){

                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime parsedDateTime = LocalDateTime.parse(user.getVerificationCodeSendTime(), formatter);
                LocalDateTime parsedDateTimePlus5Minutes = parsedDateTime.plusMinutes(5);

                return parsedDateTimePlus5Minutes.isAfter(currentTime);




            }

        return false;

    }
}
