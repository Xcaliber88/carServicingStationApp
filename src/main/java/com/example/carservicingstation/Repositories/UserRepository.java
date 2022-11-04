package com.example.carservicingstation.Repositories;

import com.example.carservicingstation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
