package com.example.backend.service;

import com.example.backend.dto.CreateUserDto;
import com.example.backend.entity.Address;
import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import com.example.backend.repository.AddressRepository;
import com.example.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RoleService roleService;

    public User addNewUser(CreateUserDto createUserDto){
        User user = mapCreateUserDtoToUser(createUserDto);

        return userRepository.save(user);
    }
    public Page<User> getUsers(Pageable pageable){
        Page<User> users= userRepository.findAll(pageable);
        return users;
    }
    public User mapCreateUserDtoToUser(CreateUserDto createUserDto){
        Address address = new Address();
        address.setCountry(createUserDto.getCountry());
        address.setDistrict(createUserDto.getDistrict());
        address.setArea(createUserDto.getArea());
        address.setRoad(createUserDto.getRoad());
        address.setHouse(createUserDto.getHouse());

        //role
        List<Role> roles = new ArrayList<>();
        Role role = roleService.getRoleByName(createUserDto.getRole())
                .orElseThrow(()-> new NoSuchElementException(createUserDto.getRole() + " is not a valid role"));
        roles.add(role);

        //doctor

        //patient

        User user = new User();
        user.setFullName(createUserDto.getFullName());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        user.setEmail(createUserDto.getEmail());
        user.setDateOfBirth(createUserDto.getDateOfBirth());
        user.setGender(createUserDto.getGender());
        user.setMedicalConditions(createUserDto.getMedicalConditions());
        user.setBloodGroup(createUserDto.getBloodGroup());
        user.setSpeciality(createUserDto.getSpeciality());
        user.setBmdcRegNo(createUserDto.getBmdcRegNo());
        user.setVerificationCode(createUserDto.getVerificationCode());
        user.setStatus(createUserDto.getStatus());

        user.setAddress(address);
        user.setRoles(roles);
        address.setUser(user); // Set the user in the address
        List<User> userList = new ArrayList<>();
        userList.add(user);
        role.setUsers(userList);
        return user;
    }
}
