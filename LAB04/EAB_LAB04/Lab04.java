import java.util.Scanner;

/**
 * Lab04.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 04
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 02/12/2015
 *
 * This program has a nested class structure.
 * The outer class instantiates a MustangQuestions object, which itself instantiates and holds several QuestionAndAnswer objects.
 * The MustangObject#askQuestion method is then used to perform all the work.
 */

class Lab04 {
	public static void main(String[] args) {
		/* * * * *
		 *  Q1. Main method asking user questions.
		 * * * * */

		// Create a new MustangQuestions instance.
		MustangQuestions mustangQuestions = new MustangQuestions();
		Scanner scanner = new Scanner(System.in); // Make a scanner for reuse throughout the lifetime of this program.
		boolean doContinue; // Boolean while true, ask questions, false, escape.
		
		// The do-while pattern is used to ensure at least one question gets asked.
		do { 
			// Call the work methods of the MustangQuestions object.
			mustangQuestions.askQuestion(scanner);

			// Get user input to see if they want to continue and get another question.
			System.out.print("Ask a question? (y)es: ");
			doContinue = doContinue(scanner.next());
		} while (doContinue);
	}


	/**
	 * This helper method evaluates the user input to the Continue query and returns if the user has entered an acceptable indication to continue.
	 */
	private static boolean doContinue(String input) {
		/* * * * *
		 *  Q5. Demonstration of ternary operator.
		 * * * * */
		boolean doContinue = input.equalsIgnoreCase("n") ? false : input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("c") || input.equalsIgnoreCase("continue");
		return doContinue;
	}

	/**
	 * This class encapsulates the Question/Answer and work methods necessary for this program.
	 * It's nested here for modularity - other XxxxQuestions classes could be created (using the same public askQuestion() method) and called from the parent.
	 */
	private static class MustangQuestions {
		// This array will be filled with QuestionAndAnswer objects.
		private QuestionAndAnswer[] questionsAndAnswers;

		// Array of questions with numeric answers.
		private static final String[] QUESTIONS_NUM = {
			"Enter a model year for a \'Foxbody\' Mustang.",
			"What model year could be referred to as an \'SN95\'?",
			"What model year could be referred to as an \'Fox4\'?",
			"What model year is the \'S550\'?",
			"In which year did the original Mustang debut?",
			"What decade would a \'Classic\' Mustang be from?",
			"Enter a model year for a \'Mustang II\'"
		};

		// The numeric answers to the above questions.
		private static final double[][] ANSWERS_NUM_RANGES = {
			{1979, 1993},
			{1994, 2004},
			{1994, 2004},
			{2015, 2015},
			{1964, 1965},
			{1960, 1972},
			{1973, 1978}
		};


		// Array of questions with String answers.
		private static final String[] QUESTION_STR = {
			"In 1964, Ford introduced the first pony car, named a...?",
			"The Ford 5.0L motor is colloquially called named...?",
			"The Mustang has historically competed with what car from Chevrolet?",
			"Which prominent racer has his name on the performance editions of the Mustang?"
		};

		// The String answers to the above questinos.
		private static final String[] ANSWERS_STR = {
			"Mustang",
			"Windsor",
			"Camaro",
			"Shelby",
		};

		// This constructor fills the QuestionAndAnswers array with the data from the Questions and Answers arrays above.
		MustangQuestions() {
			questionsAndAnswers = new QuestionAndAnswer[QUESTIONS_NUM.length + QUESTION_STR.length];
			for (int i = 0; i < QUESTIONS_NUM.length; i++) {
				questionsAndAnswers[i] = new QuestionAndAnswer(
					QUESTIONS_NUM[i],
					ANSWERS_NUM_RANGES[i]);
			}
			for (int i = QUESTIONS_NUM.length; i < questionsAndAnswers.length; i++) {
				questionsAndAnswers[i] = new QuestionAndAnswer(
					QUESTION_STR[i - QUESTIONS_NUM.length],
					ANSWERS_STR[i - QUESTIONS_NUM.length]);
			}
		}

		// This method handles asking the question and interpreting the user's answer.
		public void askQuestion(Scanner scanner) {
			// Randomly select a question from the Q&A array.
			double randDouble = Math.random();
			int index = (int) (randDouble * (questionsAndAnswers.length));

			QuestionAndAnswer questionAndAnswer = questionsAndAnswers[index];
			String question = questionAndAnswer.getQuestion();

			System.out.print(question + " >");

			if (index >= QUESTIONS_NUM.length) {
				String answer = "";
				// This try catch block just suppresses the exception.
				// It doesn't prevent the program from exiting.
				try {
					answer = scanner.next();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Input of wrong type, wanted String.");
					return;
				}
				String correctAnswer = questionAndAnswer.getAnswerString();

				/* * * * *
				 *  Q3. Conditional testing String user input.
				 *  Q4. An if-else that prints different messages.
				 * * * * */
				if (answer.equalsIgnoreCase(correctAnswer)) {
					System.out.println("Correct!");
				} else {
					System.out.println("Sorry, the correct answer is: " + correctAnswer);
				}

			} else {
				double answer = 0;
				// This try catch block just suppresses the exception.
				// It doesn't prevent the program from exiting.
				try {
					answer = scanner.nextDouble();
				} catch (java.util.InputMismatchException e) {
					System.out.println("Input of wrong type, wanted numeric.");
					return;
				}
				double answerLower = questionAndAnswer.getAnswerNumeric()[0];
				double answerUpper = questionAndAnswer.getAnswerNumeric()[1];

				/* * * * *
				 *  Q2. Conditional testing numeric user input.
				 *  Q4. An if-else that prints different messages.
				 * * * * */
				if (answer >= answerLower && answer <= answerUpper) {
					System.out.println("Correct!");
				} else {
					System.out.println("Sorry, the correct answer is in the range: " + answerLower + "-" + answerUpper);
				}
			}
		}
		

		/**
		 * This class simply holds a Question, an Answer, and methods for getting those and the type (String or numeric) (which isn't actually used anywhere).
		 */
		private static class QuestionAndAnswer {
			private String QUESTION;
			private String ANSWER_STR;
			private double[] ANSWER_NUM_RANGE;
			private boolean IS_NUMERIC;

			QuestionAndAnswer(String question, String answer) {
				this.IS_NUMERIC = false;
				this.QUESTION = question;
				this.ANSWER_STR = answer;
			}

			QuestionAndAnswer(String question, double[] answerRange) {
				this.IS_NUMERIC = true;
				this.QUESTION = question;
				this.ANSWER_NUM_RANGE = answerRange;
			}

			String getQuestion() {
				return QUESTION;
			}

			boolean isNumeric() {
				return IS_NUMERIC;
			}

			String getAnswerString() {
				if (IS_NUMERIC) {
					System.out.println("Error: requested String answer of numeric Q&A");
					return "";
				} else {
					return ANSWER_STR;
				}
			}

			double[] getAnswerNumeric() {
				if (!IS_NUMERIC) {
					System.out.println("Error: requested numeric answer of String Q&A");
					return new double[] {0, 0};
				} else {
					return ANSWER_NUM_RANGE;
				}
			}
		}
	}
}