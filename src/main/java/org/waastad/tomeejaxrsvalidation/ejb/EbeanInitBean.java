/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.ejb;

import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import org.waastad.tomeejaxrsvalidation.domain.User;

/**
 *
 * @author helge
 */
@Singleton
@Startup
public class EbeanInitBean {
    
    @Resource(name = "DS")
    private DataSource ds;

    @PostConstruct
    public void init() {
        ServerConfig config = new ServerConfig();
        config.loadFromProperties();
        config.setDataSource(ds);
        config.setName("TestServer");
        config.setUseJtaTransactionManager(true);
        config.setAutoCommitMode(true);
        config.setDatabasePlatform(new HsqldbPlatform());
        config.setRegister(true);
        config.setDefaultServer(true);

        config.addPackage(User.class.getPackage().getName());
        EbeanServerFactory.create(config);
    }
    
    @PreDestroy
    public void destroy(){
        EbeanServerFactory.shutdown();
    }
}
