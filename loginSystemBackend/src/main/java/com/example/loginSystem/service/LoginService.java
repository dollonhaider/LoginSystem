package com.example.loginSystem.service;

import com.example.loginSystem.dto.ResponseDTO;
import com.example.loginSystem.dto.UserCreateDTO;
import com.example.loginSystem.model.User;
import com.example.loginSystem.repository.LoginRepository;
import com.example.loginSystem.utils.AES256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@Transactional
public class LoginService {
    private ResponseDTO output = new ResponseDTO();

    @Autowired
    private LoginRepository loginRepository;

    public ResponseDTO register(UserCreateDTO input) {
        User createUser = loginRepository.findByEmail(input.getEmail());
        if (createUser == null)
        {
            User user = new User();
            boolean result = validate(input.getEmail());
            if (result == true)
            {
                user.setEmail(input.getEmail());
                user.setPassword(AES256.encrypt(input.getPassword()));
                loginRepository.save(user);
                return output.generateSuccessResponse(user,"Successfully Created");
            }
            else {
                return output.generateErrorResponse("This email account is not valid");
            }

        }
        else {
            return output.generateErrorResponse("This mail already exist");
        }
    }

    public ResponseDTO login(UserCreateDTO input) {
        User existingUser = loginRepository.findByEmail(input.getEmail());
        if (existingUser == null)
        {
            return output.generateErrorResponse("Invalid Email Address");
        }
        else {
            if (existingUser.getPassword() == null){
                return output.generateErrorResponse("Invalid user request");
            }
            else {
                String decryptedPassword = AES256.decrypt(existingUser.getPassword());
                if(decryptedPassword.equals(input.getPassword())){
                    System.out.println("Successfully login");
                    return output.generateSuccessResponse(null,"Successfully Login");
                }
                return output.generateErrorResponse("Wrong password ");
            }
        }
    }


    public static boolean validate(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

}
