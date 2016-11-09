/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.ejb;

import java.util.Properties;
import java.util.UUID;
import javax.inject.Inject;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.tomeejaxrsvalidation.domain.User;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
public class UserRepositoryTest {

    public UserRepositoryTest() {
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
                .p("DS.jtaManaged", "false")
                .p("openejb.log.factory", "slf4j")
                .build();
    }

    @Inject
    private UserRepository userRepository;

    @Test
    public void testSomeMethod() {
        String name = UUID.randomUUID().toString();
        User user = new User(name);
        //userRepository.save(user);
        for (int i = 0; i < 30; i++) {
            User.db().beginTransaction();
            User.find.byName(name);
            User.db().commitTransaction();
          //  userRepository.findByName(name);
        }
    }

}
