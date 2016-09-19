/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "username cannot be null")
    private String username;

}
