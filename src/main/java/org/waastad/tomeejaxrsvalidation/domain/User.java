/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.domain;

import org.waastad.tomeejaxrsvalidation.domain.finder.UserFinder;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel implements Serializable {

  public static final UserFinder find = new UserFinder();

    private static final long serialVersionUID = -7447306316470330863L;

    private String name;

}
