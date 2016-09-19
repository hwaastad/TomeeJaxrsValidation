/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.service;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposerRule;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.ContainerProperties;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testing.RandomPort;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.waastad.tomeejaxrsvalidation.ejb.EbeanInitBean;
import org.waastad.tomeejaxrsvalidation.ejb.UserRepository;
import org.waastad.tomeejaxrsvalidation.model.LoginModel;

/**
 *
 * @author helge
 */
@ContainerProperties({
    @ContainerProperties.Property(name = "DS", value = "new://Resource?type=DataSource"),
    @ContainerProperties.Property(name = "DS.LogSql", value = "false"),
    @ContainerProperties.Property(name = "DS.JdbcDriver", value = "org.hsqldb.jdbcDriver"),
    @ContainerProperties.Property(name = "DS.JdbcUrl", value = "jdbc:hsqldb:mem:Test2"),
    @ContainerProperties.Property(name = "DS.jtaManaged", value = "true")
})
@EnableServices(jaxrs = true)
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

    /**
     * Test of login method, of class AuthService.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        LoginModel model = new LoginModel("sadfasdf", "waef");
        WebTarget target = ClientBuilder.newClient().target("http://localhost:" + port + "/api/auth/simple");
        Entity<LoginModel> entity = Entity.entity(model, MediaType.APPLICATION_JSON);
        for (int i = 0; i < 10; i++) {
        Response response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(entity, Response.class
                );
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
        }
    }

}
