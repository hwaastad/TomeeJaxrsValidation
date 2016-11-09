/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.service;

import java.util.Properties;
import javax.inject.Inject;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.tomeejaxrsvalidation.ejb.EbeanInitBean;
import org.waastad.tomeejaxrsvalidation.ejb.UserRepository;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class UserRepositoryIT {

    public UserRepositoryIT() {
    }

    @Module
    @Classes(value = {UserRepository.class, EbeanInitBean.class}, cdi = true)
    public EjbJar jar() {
        return new EjbJar();
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS.LogSql", "false")
                .p("DS.jtaManaged", "true")
                .p("openejb.log.factory", "slf4j")
                .build();
    }

    @Inject
    private UserRepository userRepository;

    /**
     * Test of login method, of class AuthService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        userRepository.findByRaw();
    }

}
