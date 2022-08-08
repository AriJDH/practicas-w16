package com.profiles.profilesP2PG.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class JavaDevConfig {

    //configuracion cuando arranque el perfil
    @PostConstruct
    public void initialize (){
        System.out.println("---- Iniciando ambiente DEV -----");
    }
}
