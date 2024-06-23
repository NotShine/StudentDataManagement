import java.util.ArrayList;
import java.io.BufferedReader; //read file
import java.io.BufferedWriter;
import java.io.FileReader; //read file
import java.io.FileWriter;
import java.io.IOException; //catch exceptions
import java.util.Scanner;

public class StudentData {

        //print all students.
    public static void  PrintAllStudents(ArrayList<String>LastName, ArrayList<String>FirstNameInitial, ArrayList<String>ID, ArrayList<Integer>YearOfBirth, ArrayList<Double>GPA){
        System.out.println("All Students");
        System.out.println("LastName" + " InitialFirstName " + "ID "+ "YearBirth "+ "GPA");
        
        for (int i = 0; i <LastName.size(); i++){
            System.out.println(LastName.get(i) + " " + FirstNameInitial.get(i) +
            " " + ID.get(i) + " " + YearOfBirth.get(i) + " "
            + GPA.get(i));
        }

    }

        //print students with last name initial + age.
        public static void PrintStudenstWithLastNameInitialAge(ArrayList<String>LastName, ArrayList<String>FirstNameInitial, ArrayList<String>ID, ArrayList<Integer>YearOfBirth, ArrayList<Double>GPA, int Age){
            System.out.println("LastName" +"LastNameInitial"+  " InitialFirstName " + "ID "+ "YearBirth "+" Age "+ "GPA");

            for (int i = 0; i <LastName.size(); i++){
                System.out.println(LastName.get(i) + LastName.get(i).charAt(0)+" " + FirstNameInitial.get(i) +
                " " + ID.get(i) + " " + YearOfBirth.get(i) + Age 
                + GPA.get(i));
            }

        }

        //calculate age
        public int calculateAge( ArrayList<Integer>YearOfBirth){

            int age = 0;
            for (int  i = 0; i < YearOfBirth.size(); i++){

             age = 2024 - YearOfBirth.get(i);
            }
            return age;
            
        }

       //print list sorted by GPA

       public static void SortAscendingByGPA(ArrayList<Double> GPA, ArrayList<String> LastName, ArrayList<String> FirstNameInitial, ArrayList<String> ID, ArrayList<Integer> YearOfBirth) {
        System.out.println("LastName\tInitialFirstName\tID\tYearOfBirth\tGPA");

        int n = GPA.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (GPA.get(i - 1) > GPA.get(i)) {
                    // Swap GPA
                    double tempGPA = GPA.get(i - 1);
                    GPA.set(i - 1, GPA.get(i));
                    GPA.set(i, tempGPA);

                    // Swap LastName
                    String tempLastName = LastName.get(i - 1);
                    LastName.set(i - 1, LastName.get(i));
                    LastName.set(i, tempLastName);

                    // Swap FirstNameInitial
                    String tempFirstNameInitial = FirstNameInitial.get(i - 1);
                    FirstNameInitial.set(i - 1, FirstNameInitial.get(i));
                    FirstNameInitial.set(i, tempFirstNameInitial);

                    // Swap ID
                    String tempID = ID.get(i - 1);
                    ID.set(i - 1, ID.get(i));
                    ID.set(i, tempID);

                    // Swap YearOfBirth
                    int tempYearOfBirth = YearOfBirth.get(i - 1);
                    YearOfBirth.set(i - 1, YearOfBirth.get(i));
                    YearOfBirth.set(i, tempYearOfBirth);

                    swapped = true;
                }
            }
            n--; // Reduce the range for the next pass
        } while (swapped);

        // Print sorted lists
        for (int i = 0; i < GPA.size(); i++) {
            System.out.println(LastName.get(i) + "\t" + FirstNameInitial.get(i) + "\t" + ID.get(i) + "\t" + YearOfBirth.get(i) + "\t" + GPA.get(i));
        }
    }
       //Print class list of students which match a given lastname initial 

       public static void PrintListWithChosenInitial(ArrayList<Double>GPA, ArrayList<String>LastName,ArrayList<String>FirstNameInitial, ArrayList<String>ID, ArrayList<Integer>YearOfBirth, String Input){
        System.out.println("LastName" +"LastNameInitial"+  " InitialFirstName " + "ID "+ "YearBirth "+" Age "+ "GPA");

        for (int i = 0; i <LastName.size(); i++){
            if(LastName.get(i).startsWith(Input)){
            System.out.println(LastName.get(i) +" " + FirstNameInitial.get(i) +
            " " + ID.get(i) + " " + YearOfBirth.get(i) 
            + GPA.get(i));
            }
         }

       }

       //Calculate and display the corresponding degree classification as per GPA as provided

       public static void DisplayDegree (ArrayList<Double>GPA, ArrayList<String>LastName,ArrayList<String>FirstNameInitial, ArrayList<String>ID, ArrayList<Integer>YearOfBirth){
            System.out.println("LastName LastNameInitial InitialFirstName ID YearBirth GPA DegreeClassification");

            for(int i = 0; i < LastName.size(); i++){
                String DegreeClassification = GetDegreeClassification(GPA.get(i));
                System.out.println(LastName.get(i)  + " " + FirstNameInitial.get(i) + " " + ID.get(i) + " " + YearOfBirth.get(i) + " " + GPA.get(i) + " " + DegreeClassification);
            }  
       }

       private static String GetDegreeClassification (double gpa){
                 
                if (gpa == 4.0) {
                    return "First-class honours";
                } else if (gpa >= 3.3) {
                    return "Upper second-class honours";
                } else if (gpa >= 2.7) {
                    return "Lower second-class honours";
                } else if (gpa >= 2.0) {
                    return "Third class honours";
                } else {
                    return "Ordinary degree (no honours)";
                }
            }

            public static void WriteToFile(ArrayList<Double> GPA, ArrayList<String> LastName, ArrayList<String> FirstNameInitial, ArrayList<String> ID, ArrayList<Integer> YearOfBirth) {
                
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Enrollments.txt"))) {
            writer.write("LastName\tLastNameInitial\tFirstNameInitial\tID\tAge\tGPA\tDegreeClassification\n");

            int currentYear = java.time.Year.now().getValue();
            for (int i = 0; i < GPA.size(); i++) {
                int age = currentYear - YearOfBirth.get(i);
                String degreeClassification = GetDegreeClassification(GPA.get(i));

                writer.write(LastName.get(i) + "\t" + LastName.get(i).charAt(0) + "\t" + FirstNameInitial.get(i) + "\t" + ID.get(i) + "\t" + age + "\t" + GPA.get(i) + "\t" + degreeClassification + "\n");
            }

            System.out.println("File Enrollments.txt has been created.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        

        //create array
        ArrayList<String> FirstNameInitial = new ArrayList<>();
        ArrayList<String> ID = new ArrayList<>();
        ArrayList<Integer> YearOfBirth = new ArrayList<>();
        ArrayList<Double> GPA = new ArrayList<>();
        ArrayList<String> LastName = new ArrayList<>();

        BufferedReader bufferedReader = null;

        try {
            
            String filePath = "StudentRec.txt";
            bufferedReader = new BufferedReader (new FileReader(filePath));

            String Line;

            while ((Line = bufferedReader.readLine())!= null){
                String[] parts = Line.split(","); //file has csv format.

                if (parts.length == 5){ //check if line has 5 parts
                    LastName.add(parts[0].trim());
                    FirstNameInitial.add(parts[1].trim());
                    ID.add(parts[2].trim());
                    YearOfBirth.add(Integer.parseInt(parts[3].trim()));
                    GPA.add(Double.parseDouble(parts[4].trim()));
                }
              
            }
        } catch(IOException e){
            System.err.println("I/O error: "+ e.getMessage());

        } finally{
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch(IOException e){
                    System.err.println("Error closing file: "+ e.getMessage());
                }
            }

        }

int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Print the entire list as per read file.");
            System.out.println("2. Print the entire list with inclusion of last name initial and age.");
            System.out.println("3. Print list sorted by GPA.");
            System.out.println("4. Print list of students which match a given lastname initial.");
            System.out.println("5. Calculate and display the corresponding degree classification (according to GPA).");
            System.out.println("6. Produce a file called Enrollments.txt with all the details.");
            System.out.println("7. Exit program.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    PrintAllStudents(LastName, FirstNameInitial, ID, YearOfBirth, GPA);
                    break;
                case 2:
                    PrintStudenstWithLastNameInitialAge(LastName, FirstNameInitial, ID, YearOfBirth, GPA, choice);
                    break;
                case 3: //needs some work.
                     SortAscendingByGPA(GPA, LastName, FirstNameInitial, ID, YearOfBirth);
                    break;
                case 4:
                    System.out.print("Enter the last name initial to filter by: ");
                    String input = scanner.nextLine();
                   PrintListWithChosenInitial(GPA, LastName, FirstNameInitial, ID, YearOfBirth, input);
                    break;
                case 5:
                  DisplayDegree(GPA, LastName, FirstNameInitial, ID, YearOfBirth);
                    break;
                case 6:
                   WriteToFile(GPA, LastName, FirstNameInitial, ID, YearOfBirth);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    


        
    }
}