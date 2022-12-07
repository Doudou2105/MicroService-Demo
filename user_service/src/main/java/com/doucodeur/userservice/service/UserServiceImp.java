package com.doucodeur.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.doucodeur.userservice.model.User;
import com.doucodeur.userservice.repository.UserRepository;
import com.doucodeur.userservice.vo.Department;
import com.doucodeur.userservice.vo.ResponseTemplateVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp  implements UserService{
    
    private final UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public List<User> getUsers() {
       
        return userRepository.findAll();
    }


    @Override
    public User saveUser(User user) {
       
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
       userRepository.deleteById(userId);
    } 
    
    public ResponseTemplateVo getUserWithDepartment(Long userId){
        
        ResponseTemplateVo vo = new ResponseTemplateVo();

        User user = userRepository.findById(userId).orElseThrow();

        Department department = 
                    restTemplate.getForObject("http://localhost:8700/api/department/" + user.getDepartmentId(), Department.class);

                    vo.setUser(user);
                    vo.setDepartment(department);
     return vo;

    }

}