/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
public class Pet extends BaseModel {

    private String attribute;
    private String value;

    @ManyToOne(targetEntity = User.class)
    private User user;
}
