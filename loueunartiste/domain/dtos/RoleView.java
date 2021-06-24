package fr.formation.loueunartiste.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class RoleView {

    @NotEmpty
    @NotBlank
    private String code;

    public RoleView() {
	//
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

}
