package com.example.demo.Services.Implementations;

import com.example.demo.Models.Player;
import com.example.demo.Services.LoginService;
import com.example.demo.Services.PlayerService;
import com.example.demo.dtos.login.Credential;
import com.example.demo.dtos.login.CredentialV2;
import com.example.demo.dtos.login.EmailIdentity;
import com.example.demo.dtos.login.UserNameIdentity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PlayerService playerService;

    @Override
    public Player login(Credential credential) {
        if(credential.getIdentity() instanceof UserNameIdentity)
        {
            return loginWithIdentity((UserNameIdentity) credential.getIdentity(), credential.getPassword());
        }
        else
        {
            return loginWithIdentity((EmailIdentity) credential.getIdentity(), credential.getPassword());
        }
    }

    private Player loginWithIdentity(UserNameIdentity identity, String password) {
        Player player = playerService.getPlayerByUserNameAndPassword(identity.getUserName(), password);
        return updateLastLogin(player);
    }

    private Player loginWithIdentity(EmailIdentity identity, String password) {

        Player player = playerService.getPlayerByEmailAndPassword(identity.getEmail(), password);
        return updateLastLogin(player);
    }

    @Override
    public Player login(CredentialV2 credentialV2) {
        Player player = playerService.getPlayerByEmailOrUsernameAndPassword(credentialV2.getIdentity(), credentialV2.getPassword());

        return updateLastLogin(player);
    }

    private Player updateLastLogin(Player player)
    {
        player.setLastLogin(LocalDateTime.now());
        return playerService.savePlayer(player);
    }

}
