package backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import beans.Problem;

@Named
@SessionScoped
public class QuizBackingBean implements Serializable {

	private static final long serialVersionUID = 2075666540697330285L;
	private int currentProblem;
	private int tries;
	private int score;
	private String response = "";

	// This is just an example, but this values should come from a database
	private ArrayList<Problem> problems = new ArrayList<Problem>(
			Arrays.asList(
					new Problem(
							"What is the java slogan that made it famous? Write once...",
							"run anywhere"),
					new Problem("How many primive types are there in java?",
							"8"),
					new Problem("What edition of the JDK just came out?", "7"),
					new Problem(
							"what type of applications do you make with swing?",
							"desktop")));

	public String answerAction() {
		tries++;
		Problem tmpProblem = null;
		if (currentProblem < 4) {
			tmpProblem = problems.get(currentProblem);
		}
		if (tmpProblem != null) {
			if (tmpProblem.isCorrect(response)) {
				score++;
				currentProblem++;
				return "index?faces-redirect=true";
			}
		} else {
			if (score > 1) {
				return "success?faces-redirect=true";
			} else {
				return "failure?faces-redirect=true";
			}
		}
		return "";
	}

	public String getCurrentQuestion() {
		if (currentProblem < 4) {
			Problem tmp = problems.get(currentProblem);
			return tmp.getQuestion();
		}
		return "";
	}

	// Get & Set methods
	public int getCurrentProblem() {
		return currentProblem;
	}

	public void setCurrentProblem(int currentProblem) {
		this.currentProblem = currentProblem;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ArrayList<Problem> getProblems() {
		return problems;
	}

	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}
}
