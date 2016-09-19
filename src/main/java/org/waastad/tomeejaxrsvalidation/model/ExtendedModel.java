/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeejaxrsvalidation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author helge
 */
@Data
@NoArgsConstructor
public class ExtendedModel extends LoginModel {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "info cannot be null")
    @Size(min = 3, max = 6, message = "info must be between 3 and 6 chars")
    private String info;

    public ExtendedModel(String username, String password) {
        super(username, password);
    }

    public ExtendedModel(String info, String username, String password) {
        super(username, password);
        this.info = info;
    }

}
