package com.mkp.dp.behavioral;

/**
 * The Chain of Responsibility allows requests to flow through a chain of
 * handlers until one of them processes the request. Each handler in the chain
 * decides whether to process the request or pass it to the next handler
 */
public class ChainOfResponsibilityPatternDemo {
	public static void main(String[] args) {
		Handler authHandler = new AuthenticationHandler();
		Handler authorizationHandler = new AuthorizationHandler();
		Handler inputValidationHandler = new InputValidationHandler();

		authHandler.setNext(authorizationHandler);
		authorizationHandler.setNext(inputValidationHandler);

		Request request = new Request();
		authHandler.handle(request);
	}

}

//Request
class Request {
	String username = "user";
}

//Handler Interface
interface Handler {
	void setNext(Handler next);

	void handle(Request request);
}

//Concrete Handlers
class AuthenticationHandler implements Handler {
	private Handler next;

	@Override
	public void setNext(Handler next) {
		this.next = next;
	}

	@Override
	public void handle(Request request) {
		if (authenticate(request)) {
			if (next != null)
				next.handle(request);
		}
	}

	private boolean authenticate(Request request) {
		/* Authentication logic */
		System.out.println("Checking Authentication for requested...." + request.username);
		return true;
	}
}

class AuthorizationHandler implements Handler {
	private Handler next;

	@Override
	public void setNext(Handler next) {
		this.next = next;
	}

	@Override
	public void handle(Request request) {
		if (authorize(request)) {
			if (next != null)
				next.handle(request);
		}
	}

	private boolean authorize(Request request) {
		/* Authorization logic */
		System.out.println("Checking Authorization for requested...." + request.username);
		return true;
	}
}

class InputValidationHandler implements Handler {
	private Handler next;

	@Override
	public void setNext(Handler next) {
		this.next = next;
	}

	@Override
	public void handle(Request request) {
		if (validate(request)) {
			if (next != null)
				next.handle(request);
		}
	}

	private boolean validate(Request request) {
		/* Validation logic */
		System.out.println("Validating request...." + request.username);
		return true;
	}
}