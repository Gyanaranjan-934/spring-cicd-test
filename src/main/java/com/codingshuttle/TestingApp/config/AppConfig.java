package com.codingshuttle.TestingApp.config;

import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from EmployeeDto to Employee (name -> fullName)
        modelMapper.addMappings(new PropertyMap<EmployeeDto, Employee>() {
            @Override
            protected void configure() {
                map().setFullName(source.getName());
            }
        });

        // Mapping from Employee to EmployeeDto (fullName -> name)
        modelMapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setName(source.getFullName());
            }
        });

        return modelMapper;
    }
}
