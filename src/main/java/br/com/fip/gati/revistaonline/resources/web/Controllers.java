package br.com.fip.gati.revistaonline.resources.web;

import java.util.Arrays;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

public class Controllers {

	public static Validator includeValidationError(Validator validator, String categoria, String msg) {
		validator.add(new ValidationMessage(msg, categoria));
		return validator;
	}
	
	public static Result includeError(Result result, String msg) {
		result.include("errors", Arrays.asList(new ValidationMessage(msg, "erro")));
		return result;
	}



	public static Result includeParameterError(Result result, String key, String msg) {
		result.include(key, Arrays.asList(new ValidationMessage(msg, "erro")));
		return result;
	}
	
	public static Result includeSucess(Result result, String msg) {
		result.include("success", Arrays.asList(new ValidationMessage(msg, "ok")));
		return result;
	}
	
}
