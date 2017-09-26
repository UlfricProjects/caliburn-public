package com.ulfric.caliburn;

import java.util.List;

public class Response extends Bean {

	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
