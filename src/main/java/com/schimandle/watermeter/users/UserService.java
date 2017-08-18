package com.schimandle.watermeter.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User findUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    public User createUser(CreateUserDto createUserDto) {
        createUserDto.setPassword(encoder.encode(createUserDto.getPassword()));
        User user = new User(createUserDto);
        return userRepository.save(user);
    }

    public User updateUser(Long userId, UserPatchRequest userPatchRequest) {
        User user = userRepository.findOne(userId);

        userPatchRequest.getUserPatchList().forEach(userPatch -> {
            switch (userPatch.getUserPropertyEnum()) {
                case FIRST_NAME:
                    user.setFirstName((String) userPatch.getValue());
                    break;
                case LAST_NAME:
                    user.setLastName((String) userPatch.getValue());
                    break;
                case EMAIL:
                    user.setEmail((String) userPatch.getValue());
                    break;
                case PASSWORD:
                    user.setPassword(encoder.encode((String) userPatch.getValue()));
                    break;
            }
        });

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }
}
