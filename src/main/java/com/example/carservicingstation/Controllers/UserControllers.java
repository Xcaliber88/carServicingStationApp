package com.example.carservicingstation.Controllers;

import com.example.carservicingstation.Dtos.UpdateUserDto;
import com.example.carservicingstation.Dtos.UserDto;
import com.example.carservicingstation.Services.UserService;
import com.example.carservicingstation.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserControllers {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtos = userService.getUsers();

        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {

        UserDto optionalUser = userService.getUser(username);


        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {;

        dto.setPassword(encoder.encode(dto.getPassword()));
        String newUsername = userService.createUser(dto);

        userService.addAuthority(newUsername, "ROLE_USER");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping(value = "/mechanic")
    public ResponseEntity<UserDto> createMechanic(@RequestBody UserDto dto) {;

        dto.setPassword(encoder.encode(dto.getPassword()));
        String newUsername = userService.createUser(dto);

        userService.addAuthority(newUsername, "ROLE_MECHANIC");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping(value = "/front_office")
    public ResponseEntity<UserDto> createFrontOffice(@RequestBody UserDto dto) {;

        dto.setPassword(encoder.encode(dto.getPassword()));
        String newUsername = userService.createUser(dto);

        userService.addAuthority(newUsername, "ROLE_FRONTOFFICE");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UpdateUserDto dto) {

        dto.setPassword(encoder.encode(dto.getPassword()));
        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/mechanic/{username}")
    public ResponseEntity<UserDto> updateMechanic(@PathVariable("username") String username, @RequestBody UpdateUserDto dto) {

        dto.setPassword(encoder.encode(dto.getPassword()));
        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/front_office/{username}")
    public ResponseEntity<UserDto> updateFrontOffice(@PathVariable("username") String username, @RequestBody UpdateUserDto dto) {

        dto.setPassword(encoder.encode(dto.getPassword()));
        userService.updateUser(username, dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}
