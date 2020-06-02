package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import javax.management.relation.Role;

public class SpringSecurityJdbcDataSource {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJdbcDataSource.class, args);
    }
        @Bean
        public CommandLineRunner run(UserRepository userRepository,
            RoleRepository roleRepository) throws Exception {
            return (String[] args) -> {
                User user = new User("bart", "bart@domain.com", "bart",
                        "Bart", "Simpson", true);
                Role userRole = new Role("bart", "ROLE_USER");

                userRepository.save(user);
                roleRepository.save(userRole);

                User admin = new User("super", "super@domain.com", "super ",
                        "Super", "Man", true);
                Role adminRole = new Role("super", "ROLE_ADMIN");

                userRepository.save(admin);
                roleRepository.save(adminRole);
            };
        }     }
