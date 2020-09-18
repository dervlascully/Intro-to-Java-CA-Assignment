import java.text.DecimalFormat; // import DecimalFormat - used to display marks to 2 decimal places
public class main {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("##.##"); // Want to display the marks to 2 decimal places so construct instance of DecimalFormat, want marks in the form "##.##", eg "17.02

        grade solutionGrade = new grade();
        solutionGrade.runAll(); // run all tests
        System.out.println("Total marks scored: " + df.format( solutionGrade.getTotal() ) ); // display marks (getTotal() ) to 2 decimal places (df.format() )
        System.out.println("Grade: " + solutionGrade.calculateGrade(solutionGrade.getTotal())); // display the grade using calculateGrade and passing in total marks (getTotal)

    }
}
