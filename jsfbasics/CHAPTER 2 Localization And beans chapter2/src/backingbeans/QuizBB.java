package backingbeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import beans.ProblemBean;

@Named//We dont have to use a name if we dont want to
@SessionScoped
public class QuizBB implements Serializable {

	private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;

	public QuizBB() {
		// Create the problems that the quiz will have
		problems.add(new ProblemBean(new int[] { 3, 1, 4, 1, 5 }, 9));// pi
		problems.add(new ProblemBean(new int[] { 1, 1, 2, 3, 5 }, 8));// fibonacci
		problems.add(new ProblemBean(new int[] { 1, 4, 9, 16, 25 }, 36));// squares
		problems.add(new ProblemBean(new int[] { 2, 3, 5, 7, 11 }, 13));// primes
		problems.add(new ProblemBean(new int[] { 1, 2, 4, 8, 16 }, 32));// powers
																		// of 2
	}

	public void setProblems(ArrayList<ProblemBean> problems) {
		this.problems = problems;
		currentIndex = 0;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}

	public String getAnswer() {
		return "";
	}

	public void setAnswer(String newValue) {
		try {
			int answer = Integer.parseInt(newValue.trim());
			if (getCurrent().getSolution() == answer) {
				score++;
			}
			currentIndex = (currentIndex + 1) % problems.size();
		} catch (NumberFormatException e) {
		}
	}
}
