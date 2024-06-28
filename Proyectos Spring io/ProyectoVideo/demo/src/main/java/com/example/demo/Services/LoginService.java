package com.example.demo.Services;

import com.example.demo.Models.Player;
import com.example.demo.dtos.login.Credential;
import com.example.demo.dtos.login.CredentialV2;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    Player login(Credential credential);
    Player login(CredentialV2 credentialV2);
}
