package com.mkp.dp.behavioral;

import java.util.Stack;

/**
 * A behavioral design pattern that allows you to save and restore an object's
 * internal state without exposing its internal details. It is commonly used for
 * implementing undo functionality.
 */
public class MementoPatternDemo {
	public static void main(String[] args) {
		Editor editor = new Editor();
		History history = new History();

		// Set content and save state
		editor.setContent("Version 1");
		history.save(editor);

		// Change content
		editor.setContent("Version 2");
		history.save(editor);

		// Change content again
		editor.setContent("Version 3");

		// Undo to previous state
		editor.restore(history.undo()); // Restores to "Version 2"

		// Undo to initial state
		editor.restore(history.undo()); // Restores to "Version 1"
	}
}

//Originator
class Editor {
	private String content;

	public void setContent(String content) {
		this.content = content;
		System.out.println("Content set to: " + content);
	}

	public String getContent() {
		return content;
	}

	// Creates a memento containing current state
	public EditorMemento save() {
		return new EditorMemento(content);
	}

	// Restores content from a memento
	public void restore(EditorMemento memento) {
		this.content = memento.getContent();
		System.out.println("Content restored to: " + content);
	}
}

//Memento 
final class EditorMemento {
	private final String content;

	public EditorMemento(String content) {
		this.content = content; // Immutable state
	}

	public String getContent() {
		return content;
	}
}

//Caretaker 

class History {
	private Stack<EditorMemento> states = new Stack<>();

	public void save(Editor editor) {
		states.push(editor.save());
	}

	public EditorMemento undo() {
		return states.pop();
	}
}
