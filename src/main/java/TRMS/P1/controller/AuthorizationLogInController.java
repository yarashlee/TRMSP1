package TRMS.P1.controller;

import java.io.IOException;


import javax.servlet.ServletException;

import TRMS.P1.service.AuthorizationService;
import TRMS.P1.service.AuthorizationServiceFS;
import io.javalin.http.Context;

public class AuthorizationLogInController {

	AuthorizationService autorizationService = new AuthorizationServiceFS();

	public void logIn(Context ctx) throws ServletException, IOException {

		String username = ctx.formParam("username");

		String password = ctx.formParam("password");

		int authenticated = autorizationService.authenticatedUser(username, password);

		if (authenticated != 0) {
			ctx.html("here");

			ctx.cookieStore("id", authenticated);

			if (authenticated < 200) {
				ctx.redirect("regularemployeeHomePage.html");
			}
			if (authenticated >= 200 && authenticated < 300) {
				ctx.redirect("directSupervisorHomePage.html");
			}
			if (authenticated >= 300 && authenticated < 400) {
				ctx.redirect("departmentHomePage.html");
			}
			if (authenticated >= 400) {
				ctx.redirect("benCoHomePage.html");

			}

		}

		else {
			ctx.redirect("logIn.html");
		}

	}

	public void checkUser(Context ctx) {
		ctx.html(autorizationService.validateToken(ctx.cookieStore("security")));
	}

}
