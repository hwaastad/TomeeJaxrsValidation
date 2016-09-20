/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.service;

import java.util.Properties;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.junit.ApplicationComposerRule;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testing.RandomPort;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.tomeejaxrsvalidation.ejb.EbeanInitBean;
import org.waastad.tomeejaxrsvalidation.ejb.UserRepository;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
@Ignore
public class AuthService2Test {

    public AuthService2Test() {
    }

    @RandomPort("http")
    private int port;

    @Rule
    public final ApplicationComposerRule rule = new ApplicationComposerRule(this);

    @Module
    @Classes(value = {AppConfig.class, AuthService.class, UserRepository.class, EbeanInitBean.class}, cdi = true)
    public WebApp jar() {
        return new WebApp().contextRoot("");
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS.LogSql", "true")
                .p("DS.jtaManaged", "true")
                .build();
    }

    /**
     * Test of login method, of class AuthService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
//        LoginModel model = new LoginModel("sadfasdf", "waef");
//        WebTarget target = ClientBuilder.newClient().target("http://localhost:" + port + "/api/auth/simple");
//        Entity<LoginModel> entity = Entity.entity(model, MediaType.APPLICATION_JSON);
//        for (int i = 0; i < 20; i++) {
//            Response response = target.request(MediaType.APPLICATION_JSON)
//                    .accept(MediaType.APPLICATION_JSON)
//                    .post(entity, Response.class
//                    );
//            Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
//        }
    }

}
