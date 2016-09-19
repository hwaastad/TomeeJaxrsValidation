/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.ejb;

import javax.ejb.Stateless;
import org.waastad.tomeejaxrsvalidation.domain.User;

/**
 *
 * @author helge
 */
@Stateless
public class UserRepository {

    public void findByName(String name) {
        User.find.byName(name);
    }
}
