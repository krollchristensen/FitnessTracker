import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfDays = 7;
        int totalSteps = 0;
        int totalCalories = 0;
        int highestSteps = 0;
        int highestCalories = 0;
        String topDaySteps = "";
        String topDayCalories = "";

        for (int day = 1; day <= numberOfDays; day++) {
            String dayName = "";
            switch (day) {
                case 1: dayName = "Monday"; break;
                case 2: dayName = "Tuesday"; break;
                case 3: dayName = "Wednesday"; break;
                case 4: dayName = "Thursday"; break;
                case 5: dayName = "Friday"; break;
                case 6: dayName = "Saturday"; break;
                case 7: dayName = "Sunday"; break;
            }

            System.out.print("Enter steps for " + dayName + ": ");
            int steps = input.nextInt();

            System.out.print("Enter calories burned for " + dayName + ": ");
            int calories = input.nextInt();

            // Validate input
            if (steps < 0 || steps > 100000) {
                System.out.println("Invalid steps, must be between 0 and 100,000. Try again.");
                day--; // Retry the same day
                continue;
            }

            if (calories < 0 || calories > 10000) {
                System.out.println("Invalid calories, must be between 0 and 10,000. Try again.");
                day--; // Retry the same day
                continue;
            }

            // Update totals and highest values
            totalSteps += steps;
            totalCalories += calories;

            if (steps > highestSteps) {
                highestSteps = steps;
                topDaySteps = dayName;
            }

            if (calories > highestCalories) {
                highestCalories = calories;
                topDayCalories = dayName;
            }

            // Categorize and give feedback
            String stepCategory;
            if (steps >= 10000) {
                stepCategory = "Excellent";
            } else if (steps >= 5000) {
                stepCategory = "Good";
            } else {
                stepCategory = "Poor";
            }

            String calorieCategory;
            if (calories >= 500) {
                calorieCategory = "Excellent";
            } else if (calories >= 200) {
                calorieCategory = "Good";
            } else {
                calorieCategory = "Poor";
            }

            // Feedback
            System.out.println(dayName + " - Steps: " + stepCategory + ", Calories: " + calorieCategory);

            // Bonus feedback
            boolean bonus = (steps >= 10000 && calories >= 500);
            String bonusFeedback = bonus ? "Great job, you hit both targets!" : "Keep it up, you can do it!";
            System.out.println(bonusFeedback);
        }

        // Calculate averages
        double averageSteps = (double) totalSteps / numberOfDays;
        double averageCalories = (double) totalCalories / numberOfDays;

        // Print overall report
        System.out.println("\n--- Weekly Report ---");
        System.out.println("Total steps: " + totalSteps);
        System.out.println("Total calories burned: " + totalCalories);
        System.out.println("Highest steps in a day: " + highestSteps + " (on " + topDaySteps + ")");
        System.out.println("Highest calories burned in a day: " + highestCalories + " (on " + topDayCalories + ")");
        System.out.println("Average daily steps: " + averageSteps);
        System.out.println("Average daily calories burned: " + averageCalories);
    }
}
