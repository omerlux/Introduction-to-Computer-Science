public class Main {

    public static void main(String[] args) {
        System.out.println("---------------Course---------------");
        try{
            Course course1 = new Course("test+",4, 2 );
            System.out.println("Error 1: Wrong! should be name exception");
        }
        catch(IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception (name)
        }
        try{
            Course course2 = new Course(" ",-4, 2 );
            System.out.println("Error 2: Wrong! should be number exception");
        }
        catch(IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception (number)
        }
        try{
            Course course3 = new Course("",4,  0 );
            System.out.println("Error 3: Wrong! should be credits exception");
        }
        catch(IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());    //exception (credits)
        }
        try{
            Course course3 = new Course("095AazZ ",4,  7 );
        }
        catch(IllegalArgumentException ex){
            System.out.println("Error 4: Wrong! course3 name is ok");
        }
        Course math = new Course("Math", 5, 15);
        Course english = new Course("english1", 4, 3);
        Course biology = new Course("biology", 5, 4);
        if(!math.getName().equals("Math")) System.out.println("Error 5: Wrong! name should be: Math"); //math
        if(math.getCredits() != 15) System.out.println("Error 6: Wrong! credits should be 15");//2
        if(math.getNumber() != 5) System.out.println("Error 7: Wrong! number should be 5"); //5
        System.out.println("check if the parameters are: Math, 5, 15    " + math.toString()); //course name: *, course number: *, number of credits: *
        if(math.isEqualTo(english)) System.out.println("Error 8: Wrong! should be different id");
        if(!math.isEqualTo(biology)) System.out.println("Error 9: Wrong! should be same id");
        System.out.println("------------------Student + StudentInfo---------------");
        try{
            Student student1 = new Student("student%", "", 4);
            System.out.println("Error 10: Wrong! should be firstName exception");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception (firstName)
        }
        try{
            Student student2 = new Student("studentTwo", "-", 4);
            System.out.println("Error 11: Wrong! should be familyName exception");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception (familyName)
        }
        try{
            Student student3 = new Student("studentThree", "studentThree", 0);
            System.out.println("Error 12: Wrong! should be id exception");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception (id)
        }
        try{
            Student student4 = new Student("", "", 5);
            System.out.println("Error 14: Wrong! firstName/familyName cannot be empty!");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception firstName/secondName empty
        }
        Student student = new Student("firstName", "secondName", 111);
        if(!student.getStudentInfo().getFirstName().equals("firstName")) System.out.println("Error 15: Wrong! should be same firstName");
        if(!student.getStudentInfo().getFamilyName().equals("secondName")) System.out.println("Error 16: Wrong! should be the same familyName");
        if(student.getStudentInfo().getIdentityNumber() != 111) System.out.println("Error 17: Wrong! should be the same id");
        if(student.getStudentInfo().getCredit() != 0) System.out.println("Error 18: Wrong! Credit should be 0!");
        student.getStudentInfo().addCredit(math.getCredits());
        if(student.getStudentInfo().getCredit() != 15) System.out.println("Error 19: Wrong! Credit should be 15!");
        if(!student.getStudentInfo().getAddress().equals("")) System.out.println("Error 20: Wrong! address should be empty!");
        if(student.getStudentInfo().getRequiredCredits() != 105) System.out.println("Error 21: Wrong! Required credits should be 105!");
        try{
            student.getStudentInfo().setAddress("");
            System.out.println("Error 22: Wrong! address cannot be empty!");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception address
        }
        try{
            student.getStudentInfo().setAddress(null);
            System.out.println("Error 23: Wrong! address cannot be null!");
        }
        catch (IllegalArgumentException ex){
            System.out.println("Good Job! Exception message: " + ex.getMessage());  //exception null
        }
        Student tester = new Student("tester", "testerFamilyName", 12);
        tester.getStudentInfo().setAddress("bat yam");
        Student testerTwo = new Student("testerTwo", "testerFamilyNameTwo", 111);
        student.getStudentInfo().setAddress("tel aviv");
        if(!student.getStudentInfo().getAddress().equals("tel aviv")) System.out.println("Error 24: Wrong! address should be tel aviv");
        System.out.println("next line parameters: name: firstName, familyName: secondName, Address: tel aviv, Current credits: 15");
        System.out.println(student.getStudentInfo().toString());
        if(student.getStudentInfo().isEqualTo(tester.getStudentInfo())) System.out.println("Error 25: Wrong! id should be different!");
        if(!student.getStudentInfo().isEqualTo(testerTwo.getStudentInfo())) System.out.println("Error 26: Wrong! id should be the same!");
        tester.addCourseGrade(math, 85); //15
        tester.addCourseGrade(english, 90); //3
        tester.addCourseGrade(biology, 95); //4
        if(tester.averageGrade() != 87.5) System.out.println("Error 27: Wrong! average should be 87.5!");
        testerTwo.addCourseGrade(math, 100); //15
        testerTwo.addCourseGrade(english, 90); //3
        testerTwo.addCourseGrade(biology, 60); //4
        if(tester.getStudentInfo().getCredit() != 22) System.out.println("Error 28: Wrong! credits should be 22");
        if(testerTwo.averageGrade() != 91.36363636363636) System.out.println("Error 29: Wrong! average should be 91.36363636363636!");
        if(student.isEqualTo(tester)) System.out.println("Error 30: Wrong! id of students should be different");
        if(!student.isEqualTo(testerTwo)) System.out.println("Error 31: Wrong! id of students should be the same");
        System.out.println("Any administrative string: " + tester.toString());

        System.out.println("-----------------Queens-------------------");
        boolean[][] board1 = {{true, false, false}
                            ,{false, false, true},
                            {false, false, true}};
        if(KQueens.isLegalSolution(board1, 3)) System.out.println("Error 32: Wrong! board1 is not legal");
        boolean[][] board2 = {{true, false, false}
                            ,{false, true, false},
                            {false, false, true}};
        if(KQueens.isLegalSolution(board2, 3)) System.out.println("Error 33: Wrong! board2 is illegal!");
        boolean[][] board3 = {{true, false, false}
                            ,{false, false, true},
                            {false, false, true}};
        if(KQueens.isLegalSolution(board3, 3)) System.out.println("Error 34: Wrong! board3 is illegal!");
        boolean[][] board4 = {{true, false, false, false}
                            ,{false, false, true, false},
                              {false, true, false, true}};
        if(KQueens.isLegalSolution(board4, 4)) System.out.println("Error 35: Wrong! board4 is illegal!");
        boolean[][] board5 = {{true, false, true, true},
                           {false, false, false, false},
                           {false, false, false, false},
                            {false, false, false, false}};
        if(KQueens.isLegalSolution(board5, 3)) System.out.println("Error 36: Wrong! board5 is illegal!");
        boolean[][] board6 = {{false, false, false, true},
                              {false, false, false, true},
                            {false, false, false, false},
                            {false, false, false, true}};
        if(KQueens.isLegalSolution(board6, 3)) System.out.println("Error 37: Wrong! board6 is illegal!");
        boolean[][] board7 = {{false, false, false, true},
                            {false, false, false, false},
                            {false, true, false, false},
                            {true, false, false, false}};
        if(KQueens.isLegalSolution(board7, 3)) System.out.println("Error 38: Wrong! board7 is illegal!");
        boolean[][] board8 = {{true, false, false, false},
                            {false, false, false, false},
                            {false, false, true, false},
                            {true, false, false, false}};
        if(KQueens.isLegalSolution(board8, 3)) System.out.println("Error 39: Wrong! board8 is illegal!");
        boolean[][] board9 = {{true}};
        if(!KQueens.isLegalSolution(board9, 1)) System.out.println("Error 40: Wrong! board9 is legal!");
        boolean[][] board10 = {{true}};
        if(KQueens.isLegalSolution(board10, 0)) System.out.println("Error 41: Wrong! board10 has 1 queen!");
        if(!KQueens.isLegalSolution(KQueens.kQueens(1,1), 1)){
            System.out.println("Error 42: Wrong! there is a solution to this board!");
            KQueens.printBoard(KQueens.kQueens(1, 1));
        }
        if(!KQueens.isLegalSolution(KQueens.kQueens(3,3), 3)){
            System.out.println("Error 43: Wrong! there is a solution to this board!");
            KQueens.printBoard(KQueens.kQueens(3, 3));
        }
        if(!KQueens.isLegalSolution(KQueens.kQueens(6,8), 8)){
            System.out.println("Error 44: Wrong! there is a solution to this board!");
            KQueens.printBoard(KQueens.kQueens(6, 8));
        }
        if(KQueens.isLegalSolution(KQueens.kQueens(3,4), 4)) System.out.println("Error 45: Wrong! there is no solution to this board!");
        if(KQueens.isLegalSolution(KQueens.kQueens(3,3), 2)) System.out.println("Error 46: Wrong! the solution has more than 2 queens!");
    }
}
