package com.mkp.dp.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * promotes loose coupling by keeping objects from referring to each other
 * explicitly. Instead, they communicate through a mediator object, making the
 * system easier to maintain and extend.
 */
public class MediatorPatternDemo {
	public static void main(String[] args) {
		ChatMediator mediator = new ChatMediatorImpl();

		User user1 = new UserImpl(mediator, "Alice");
		User user2 = new UserImpl(mediator, "Bob");
		User user3 = new UserImpl(mediator, "Charlie");
		User user4 = new UserImpl(mediator, "Diana");

		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Hello Everyone!");
		user3.send("Hi Alice!");
	}
}

//mediator interface
interface ChatMediator {
	void sendMessage(String msg, User user);

	void addUser(User user);
}

//concrete mediator

class ChatMediatorImpl implements ChatMediator {
	private List<User> users;

	public ChatMediatorImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}

	@Override
	public void sendMessage(String msg, User sender) {
		for (User u : users) {
			// message should not be received by the user sending it
			if (u != sender) {
				u.receive(msg);
			}
		}
	}
}

//Colleague abstract Class
abstract class User {
	protected ChatMediator mediator;
	protected String name;

	public User(ChatMediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}

//Concrete Colleague Class
class UserImpl extends User {
	public UserImpl(ChatMediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + ": Sending Message = " + msg);
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Received Message: " + msg);
	}
}
