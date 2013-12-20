package beans;

import java.io.Serializable;

public class Questions implements Serializable {
	private static final long serialVersionUID = -7148843668107920897L;

	private String question;
	private Question[] questions = {
			new Question("Which planet is closest to the sun? ", new String[] {
					"Mercury", "Mars", "Earth", "Jupiter" }, "Mercury"),
			new Question(
					"How many holes are there in a ten pin bowling ball? ",
					new String[] { "One", "three", "five", "nine" }, "three"),
			new Question(" In which country is the Louvre Museum? ",
					new String[] { "Italy", "Montenegro", "France", "Brazil" },
					"France"),
			new Question(
					"Cats were once sacred animals in what ancient culture?",
					new String[] { "Greek", "Egyptian", "Teutonic",
							"Internet Community" }, "Egyptian"),
			new Question("True or False: All polar bears are left-handed? ",
					new String[] { "true", "false" }, "true") };

	public int size() {
		return questions.length;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Question[] getQuestions() {
		return questions;
	}
}