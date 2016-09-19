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
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testing.RandomPort;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.waastad.tomeejaxrsvalidation.model.ExtendedModel;
import org.waastad.tomeejaxrsvalidation.model.LoginModel;

/**
 *
 * @author helge
 */
@RunWith(ApplicationComposer.class)
@EnableServices(jaxrs = true)
public class AuthServiceTest {

    public AuthServiceTest() {
    }

    @RandomPort("http")
    private int port;

    @Module
    @Classes(value = {AppConfig.class, AuthService.class}, cdi = true)
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
        Response response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));

    }

    /**
     * Test of loginExtrended method, of class AuthService.
     */
    @Test
    public void testLoginExtended() {
        System.out.println("loginExtrended");
        ExtendedModel model = new ExtendedModel("ssd", "user","pass");

        WebTarget target = ClientBuilder.newClient().target("http://localhost:" + port + "/api/auth/extended");
        Entity<ExtendedModel> entity = Entity.entity(model, MediaType.APPLICATION_JSON);
        Response response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(entity, Response.class);
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));
    }

}
