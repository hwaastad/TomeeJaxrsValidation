/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class LoginModel implements Serializable {

    private static final long serialVersionUID = -2073027372154171465L;
    @NotNull(message = "username cannot be null")
    private String username;
    @NotNull(message = "password cannot be null")
    @Size(min = 3, max = 6, message = "password must be between 3 and 6 chars")
    private String password;
}
