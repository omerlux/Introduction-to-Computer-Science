import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class YuvalsTester {
    static int counter=0;
    public static void main(String[] args) {
        boolean throwErrors=false;
        System.out.println("intro:");
        System.out.println("hey, this is yuval zilber, i wrote this tester for 1 reason, to help you");
        System.out.println("if you have any question about this assignment or in the further assignments - contact me.");
        System.out.println("if you need help in anything, logic, calculus, algebra, infi, bdida - contact me");
        System.out.println("i'm available in whatsapp - 0504840490");
        System.out.println("i'm available in facebook - Yuval Zilber");
        System.out.println("i'm here to help you people.");

        System.out.println("---------     START: OVERALL     --------- ");
        System.out.println("   ------     START:  PART 1     ------");
        System.out.println("      ---  START:  Class Course  ---");
        int errcounter_Class=0,
                errcounter_Part1=0,
                errcounter_Overall=0;
        Course algebra1 = new Course("Algebra1", 100,1);
        Course algebra2 = new Course("Algebra2", 101,2);
        Course algebra3 = new Course("Algebra3", 102,3);
        Course algebra4 = new Course("Algebra4", 103,4);
        Course algebra5 = new Course("Algebra5", 99,5);
        Course calculus1 = new Course("Calculus1", 105, 1);
        Course calculus2 = new Course("Calculus2", 106, 2);
        Course calculus3 = new Course("Calculus3", 107, 3);
        Course calculus4 = new Course("Calculus4", 98, 4);
        Course logic = new Course("Logic", 97, 6);
        Course matrixs = new Course("Matrixs", 96, 6);
        algebra2.addPreliminaryCourse(algebra1);
        algebra3.addPreliminaryCourse(algebra2);
        algebra4.addPreliminaryCourse(algebra3);
        algebra5.addPreliminaryCourse(algebra4);
        algebra5.addPreliminaryCourse(calculus4);
        List<Course> singltone=new LinkedList<>();
        try{
            algebra2.addPreliminaryCourses(singltone);
        }
        catch (Exception e){
            if(throwErrors)
                throw e;
            String excepType=e.getClass().getCanonicalName();
            String yuvalsNote="";
            if(e instanceof NullPointerException)
                yuvalsNote="most likly the exception is not from addPreliminaryCourses().\nmaybe it was thrown from other function that you call to in addPreliminaryCourses()";
            if(e instanceof IndexOutOfBoundsException)
                yuvalsNote="check that you don't try to get the list's first position without checking its length";
            if(e instanceof IllegalArgumentException)
                yuvalsNote="check again the assignment! list with zero length is valid";
            errcounter_Class++;
            errcounter_Part1++;
            errcounter_Overall++;
            printError(100,"Course","addPreliminaryCourses",singltone.toString(),"","you threw "+e.getClass().getSimpleName()+" in the function: "+e.getStackTrace()[0].getMethodName()+"in line "+e.getStackTrace()[0].getLineNumber(),yuvalsNote);
        }
        singltone.add(matrixs);

        algebra2.addPreliminaryCourses(singltone);
        if(!algebra2.getPreliminaryCourses().contains(matrixs))
            printError(101,"Course","addPreliminaryCourses",singltone.toString(),"","","you don't add the courses in the list");

        calculus2.addPreliminaryCourse(calculus1);
        calculus3.addPreliminaryCourse(calculus2);
        calculus4.addPreliminaryCourse(calculus3);
        calculus4.addPreliminaryCourse(algebra3);
        calculus2.addPreliminaryCourse(logic);

        if(!matrixs.isPreliminaryCourse(calculus4)){
            errcounter_Class++;
            errcounter_Part1++;
            errcounter_Overall++;
            String yuvalsNote="well, it is 5 level of depth of preliminary...";
            if(calculus3.isPreliminaryCourse(calculus4))
                yuvalsNote="most likely you ask only for 1st level of preliminary courses.\nyou have a function, getAllPreliminaryCourses() - use it here.";
            printError(102, "Course", "isPreliminaryCourse", "is matrix a pre-course of calculus4?", "true", "false", yuvalsNote);
        }

        List<Course> courses = new LinkedList<>();
        algebra5.addPreliminaryCourses(algebra5.getAllPreliminaryCourses());
        courses.addAll(algebra5.getAllPreliminaryCourses());
        if(courses.size() == 10&isSorted(courses)){
        }
        else{
            List<Course> tmp1=new LinkedList<>();
            tmp1.add(calculus1);
            tmp1.add(calculus2);
            tmp1.add(calculus3);
            tmp1.add(calculus4);
            tmp1.add(algebra1);
            tmp1.add(algebra2);
            tmp1.add(algebra3);
            tmp1.add(algebra4);
            tmp1.add(logic);
            tmp1.add(matrixs);
            Sorter.bSort(tmp1);
            Sorter.bSort(tmp1);
            String yuvalsNote="";
            String youCourses=getNamesCourses(courses).toString();
            String myourses=getNamesCourses(tmp1).toString();
            if(courses.size()<10){
                yuvalsNote = "you added too few courses. check if you check deep inside. check maybe do you add the level 1 preliminary courses?";
                errcounter_Class++;
                errcounter_Part1++;
                errcounter_Overall++;
                printError(103, "Course", "getAllPreliminaryCourses,addAll,add", "<algebra1, algebra2, algebra3, algebra4, calculus4>", myourses, youCourses, yuvalsNote);
            }
            else if(courses.size()>10){
                yuvalsNote = "you added duplicated courses.\ncheck if you eccidently added things twice or didn't check.\ncuz i did inserted duplicated courses, check that you dont let it in\n";
                errcounter_Class++;
                errcounter_Part1++;
                errcounter_Overall++;
                printError(104, "Course", "getAllPreliminaryCourses,addAll,add", "<algebra1, algebra2, algebra3, algebra4, calculus4>", myourses, youCourses, yuvalsNote);
            }
            if(!isSorted(courses)){
                yuvalsNote = "you don't sort the list, check the assignment aggain, any method that returns List<Course> should return it sorted.\nplease use Sorter.bSort([your_list]) before returns lists";
                errcounter_Class++;
                errcounter_Part1++;
                errcounter_Overall++;
                printError(105, "Course", "getAllPreliminaryCourses,addAll,add", "<algebra1, algebra2, algebra3, algebra4, calculus4>", myourses, youCourses, yuvalsNote);
            }
        }
        if(errcounter_Class==0)
            System.out.println("Good Job! no problems found!");
        else
            System.out.println("failed... Course check did not throw any exception, but "+errcounter_Class+" problems found, please fix it");
        System.out.println("      ---  END:  Class Course  ---");

        System.out.println("      ---  START:  Class Degree  ---");
        System.out.print("check constructor: ");
        int innerChecker=0;
        Degree d1=new ValidationDegree("intergalactic science",7,30);
        if(((d1.getDegreeName()==null)||(!d1.getDegreeName().equals("intergalactic science")))|d1.getDegreeCode()!=7|d1.getRequiredCredits()!=30|d1.getMandatoryCourses()==null|d1.getElectiveCourses()==null)
        {
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(106, "Degree", "constructor", "\"intergalactic science\",7,30", "new Degree with initialized fields", "you didn't initialized all fields", "recheck if you initialize all fields in degree constructor");

        }
        else if (d1.getMandatoryCredits() != 0){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(107, "Degree", "getMandatoryCredits", "\"intergalactic science\",7,30", "0", d1.getMandatoryCredits()+"", "recheck if you initialize all fields in degree constructor");

        }
        if(innerChecker==0)
            System.out.println("PASS");
        else{
            System.out.println("constructors faild, errors found:" + innerChecker);
            return;
        }
        innerChecker=0;
        System.out.println("#check addCourse()#");
        d1.addCourse(algebra3,true);
        if(d1.getRequiredCredits()!=30){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(108, "Degree", "addCourse", "algebra 3", 35+"", d1.getRequiredCredits()+"", "in function 'addCourse()' you change the required credits.\nit does not supposed to be changed!");

        }
        if(!d1.getElectiveCourses().isEmpty()){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(109, "Degree", "addCourse", "", "an empty list", getNamesCourses(d1.getElectiveCourses()).toString(), "i added only mandatory courses and you added part(or all) of them to the Elective Courses List");

        }
        if(d1.getMandatoryCourses().size() != algebra3.getAllPreliminaryCourses().size()+1){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            List<Course> crs=algebra3.getAllPreliminaryCourses();
            crs.add(algebra3);
            printError(110, "Degree", "addCourse", "", getNamesCourses(crs).toString(), getNamesCourses(d1.getElectiveCourses()).toString(), "check if you add all preliminary courses of the course you add and the course itself");
        }
        if(d1.getMandatoryCredits()!=12){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(111, "Degree", "getMandatoryCredits", "", "12", getNamesCourses(d1.getElectiveCourses()).toString()+"", "");
        }
        Course fun1=new Course("fun",301,6);
        Course fun2=new Course("funForFun",302,6);
        Course fun3=new Course("fun3",303,6);
        Course fun4=new Course("fun4",304,6);
        Course fun5=new Course("fun5",305,6);
        Course fun6=new Course("fun6",306,6);
        fun6.addPreliminaryCourse(fun5);
        fun5.addPreliminaryCourse(fun4);
        fun4.addPreliminaryCourse(fun3);
        fun3.addPreliminaryCourse(fun2);
        fun2.addPreliminaryCourse(fun1);
        boolean added6=d1.addCourse(fun6,false);
        if(d1.getElectiveCourses().size()>1){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(112, "Degree", "addCourse", "1 course with 5 preliminary courses", "list with 1 variable", getNamesCourses(d1.getElectiveCourses()).toString(), "while adding elective course it shouldn't add it's preliminary");
        }
        if(d1.getMandatoryCredits()!=12){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(1, "Degree", "getMandatoryCredits", "", "12", d1.getMandatoryCredits()+"", "you count the elective courses as well");
        }
        if(!added6){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(113, "Degree", "addCourse", "1 course with 5 preliminary courses", "true", "false", "");

        }
        if(d1.addCourse(fun6,false)&added6)
        {
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(190, "Degree", "addCourse", "an elective course that is already exist in elective courses", "false", "true", "you added a course that is already exist in the list");
        }
        added6 &= d1.addCourse(fun1,false);
        added6 &= d1.addCourse(fun2,false);
        added6 &= d1.addCourse(fun3,false);
        added6 &= d1.addCourse(fun4,false);
        added6 &= d1.addCourse(fun5,false);
        if(!added6){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            printError(114, "Degree", "addCourse", "some elective courses", "true", "false", "dont block courses to be added");
        }
        boolean b4=d1.addCourse(algebra4,true);
        if(!b4){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="dont count double credits";
            printError(115, "Degree", "addCourse", "algebra4", "true", "false", yuvalsNote);
        }else if(!d1.getMandatoryCourses().contains(algebra4)|d1.getElectiveCourses().contains(algebra4)){

            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="you didn't added a course even though you returned true";
            printError(115, "Degree", "addCourse", "algebra4", "true", "true", yuvalsNote);

        }
        boolean b5=d1.addCourse(calculus4,true);
        if(b5){
            innerChecker++;
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="don't count just what i add, count everything\ndoes it sounds fine to you that all of the mendatory courses in the degree will demand more than the degree does?";
            printError(116, "Degree", "addCourse", "calculus4", "false", "true", yuvalsNote);
        }
        else if(d1.getMandatoryCourses().contains(calculus4)|d1.getMandatoryCourses().contains(logic)|d1.getElectiveCourses().contains(calculus4)|d1.getElectiveCourses().contains(logic)){
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote = "you add course or one of its preliminary even though you found out you returned false(supposed to return false)";

            printError(1162, "Degree", "addCourse", "calculus4", "false", "false", yuvalsNote);
        }

        if(innerChecker==0)
            System.out.println("Good Job! you rule! keep on!");
        else
            System.out.println("failed(for now) mistakes found:"+innerChecker);
        innerChecker=0;
        if(errcounter_Class==0)
            System.out.println("Good Job! the hole class is perfect!! you do really good.\n" +
                    "Keep like that and you will become a really good programmer!");
        else{
            System.out.println("failed, only " + errcounter_Class + " remains");
            return;
        }
        System.out.println("      ---  START:  Class BachelorDegree  ---");
        BachelorDegree bachelorDegree = new BachelorDegree("making people happy",320);
        if(!bachelorDegree.getDegreeName().equals("making people happy")){
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="update degree name field in BachelorDegree constructor";
            printError(117, "BachelorDegree", "constructor", "\"making people happy\",320", "", "", yuvalsNote);
        }
        if(bachelorDegree.getRequiredCredits()!=20){
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="update degree REQUIRED_CREDITS field in BachelorDegree constructor";
            printError(118, "BachelorDegree", "constructor", "\"making people happy\",320", "", "", yuvalsNote);
        }
        if(bachelorDegree.getDegreeCode()!=320){
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="update degree code field in BachelorDegree constructor";
            printError(119, "BachelorDegree", "constructor", "\"making people happy\",320", "", "", yuvalsNote);
        }
        if(errcounter_Class==0){
            System.out.println("Good Job!");
        }
        else {
            System.out.println("failed, only " + errcounter_Class + " remains");
            return;
        }
        System.out.println("      ---  START:  Class MasterDegree  ---");
        MasterDegree masterDegree1 = new MasterDegree("psychology",98248,true);
        MasterDegree masterDegree2 = new MasterDegree("personality engineering",31468,false);
        if((!masterDegree1.getWithResearch())||masterDegree2.getWithResearch()){
            errcounter_Class++;
            errcounter_Overall++;
            errcounter_Part1++;
            String yuvalsNote="there are 2 options\n" +
                    "1) you not initialize the field that is supposed to represent if this degree is 'with teza' or not.\n" +
                    "2) you do not return it in getWithResearch() function, please do.\n" +
                    "**you need to add here a new private boolean field that will save this data.";
            printError(120, "MasterDegree", "getWithResearch()", "", "", "", yuvalsNote);
        }
        if((!masterDegree1.getDegreeName().equals("psychology"))|masterDegree1.getDegreeCode()!=98248){
            String yuvalsNote="you need write super(name,degreeCode,REQUIRED_CREDITS); in constructor";
            printError(121, "MasterDegree", "getWithResearch()", "", "", "", yuvalsNote);
        }
        if(errcounter_Class==0)
            System.out.println("Good Job!");
        else{
            System.out.println("failed, only " + errcounter_Class);
            return;
        }
        System.out.println("Good Job! You are amazing! you PASSED all part 1 tests!");
        System.out.println("   ------     START: PART 2     ------");
        System.out.println("      ---  START: Class Grade  ---");
        System.out.println("check constructor:");
        try{
            Grade g1=new Grade(algebra1,100);
            if(g1.getGrade()!=100){
                printError(122, "Grade", "constructor", "argebra1, 100", "Grade with 100", g1.getGrade()+"", "you throw an exception when grade is 100\nmaybe you demand a grade <100 and not <=100");
                errcounter_Class++;
            }
        }catch (Exception e){
            printError(123,"Grade","constructor","argebra1, 100","an instance of Grade class",e.getClass().getSimpleName(),"you throw an exception when grade is 100\nmaybe you demand a grade <100 and not <=100");
            errcounter_Class++;
        }

        try{
            Grade g2=new Grade(algebra2,0);
        }
        catch (Exception e){
            errcounter_Class++;
            printError(124,"Grade","constructor","argebra1, 0","an instance of Grade class",e.getClass().getSimpleName(),"you throw an exception when grade is 0\nmaybe you demand a grade <=0 and not <0");
        }
        try{
            Grade g3 = new Grade(null,50);
            printError(125,"Grade","constructor","null,50","IllegalArgumentException","didn't throw an exception","");
        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException){
                System.out.println("Good Job! throws IllegalArgumentException as needed for course null");
            }
            else{
                errcounter_Class++;
                printError(126, "Grade", "constructor", "null,50", "IllegalArgumentException", e.getClass().getSimpleName(), "");

            }
        }
        try{
            Grade g4 = new Grade(algebra2,-1);
            errcounter_Class++;
            printError(127,"Grade","constructor","algebra2,-1","IllegalArgumentException","didn't throw an exception","");
        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException){
                System.out.println("Good Job! throws IllegalArgumentException as needed for course null");
            }
            else{
                errcounter_Class++;
                printError(128,"Grade","constructor","algebra2,-1","IllegalArgumentException",e.getClass().getSimpleName(),"");
            }
        }
        try{
            Grade g5 = new Grade(algebra2,101);
            errcounter_Class++;
            printError(129,"Grade","constructor","null,101","IllegalArgumentException","didn't throw an exception","");

        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException){
                System.out.println("Good Job! throws IllegalArgumentException as needed for course null");
            }
            else{
                errcounter_Class++;
                printError(129, "Grade", "constructor", "null,101", "IllegalArgumentException", e.getClass().getSimpleName(), "");

            }
        }
        System.out.print("check setGrade(): ");
        Grade g6=new Grade(algebra4,97);
        g6.setGrade(80);
        if(g6.getGrade()!=80){
            errcounter_Class++;
            printError(130, "Grade", "setGrade", "8", "80", g6.getGrade()+"", "");
        }
        if(errcounter_Class==0)
            System.out.println(" PASS Good Job! You rock! keep it on, just like that and you done!");
        else{
            System.out.println("just a little more. only "+errcounter_Class+" mistakes to fix");
            return;
        }
        System.out.println("      ---  START: Class Student  ---");
        Degree myDegree=new BachelorDegree("CSAndMath",12412);
        StudentInfo myInfo=new StudentInfo("yuval", "zilber", 313564282, "brenfeld 1 beer seva");
        Student s1=new Student(myInfo,myDegree);
        System.out.print("increase year:");
        s1.increaseYear();
        if(s1.getCurrentYear()!=2){
            errcounter_Class++;
            printError(131,"Student","increaseYear","","2",s1.getCurrentYear()+"","");
        }else
            System.out.println(" PASS");
        System.out.print("closeDegree:");
        s1.closeDegree(2021);
        if(s1.getFinishYear()!=2021){
            errcounter_Class++;
            printError(132,"Student","getFinishYear","2021","2021",s1.getFinishYear()+"","you don't enter value to finishAt field");
        }
        if(s1.getCurrentYear()!=0){
            errcounter_Class++;
            printError(133,"Student","closeDegree","2021","0",s1.getCurrentYear()+"","you don't nullify the year of student");
        }
        if(errcounter_Class==0)
            System.out.println(" PASS");
        System.out.print("registerTo(), isRegisteredTo(): ");
        Student s2=new Student(myInfo,myDegree);

        boolean flag=true;
        flag &= s2.registerTo(algebra4);
        flag &= s2.registerTo(algebra3);
        flag &= s2.registerTo(algebra2);
        flag &= s2.registerTo(algebra1);
        if(!flag){
            errcounter_Class++;
            printError(134,"Student","registerTo","course","true","false","");
        }
        if(s2.registerTo(algebra2)){
            printError(135,"Student","registerTo","algebra2","false","true","");
            errcounter_Class++;
        }
        flag=true;
        flag &= s2.isRegisteredTo(algebra4);
        flag &= s2.isRegisteredTo(algebra3);
        flag &= s2.isRegisteredTo(algebra2);
        flag &= s2.isRegisteredTo(algebra1);
        if(!flag){
            printError(136,"Student","isRegisteredTo","some courses that the student is registered to","true","false","");
            errcounter_Class++;
        }
        if(errcounter_Class==0)
            System.out.println("PASS");
        else{
            System.out.println("failed, only "+ errcounter_Class+" left to fix");
            return;
        }
        System.out.print("addGrade(),isCompleted():       ");
        s2.addGrade(algebra1,60);
        s2.addGrade(algebra2,100);
        s2.addGrade(algebra3,90);
        if(s2.addGrade(calculus4,60)){
            String yuvalsNote="don't return true while adding a grade of course that the student is not registered to";
            printError(137,"Student","addGrade","illegal course","","",yuvalsNote);

        }
        if(s2.getCourseGrade(algebra1)==null|s2.getCourseGrade(algebra2)==null|s2.getCourseGrade(algebra3)==null){
            String yuvalsNote="you didn't actually added the course to grades";
            printError(138,"Student","addGrade","some courses","","",yuvalsNote);
        }
        else if(s2.getCourseGrade(algebra1).getGrade()!=60|s2.getCourseGrade(algebra2).getGrade()!=100|s2.getCourseGrade(algebra3).getGrade()!=90){
            String yuvalsNote="you didn't actually added the number of grade to grades";
            printError(139,"Student","addGrade","some courses","","",yuvalsNote);
        }
        else{
            if (!s2.isCompleted(algebra1, 60)){
                errcounter_Class++;
                String yuvalsNote = "ther is 2 options:\n" +
                        "1) you don't even add the grade\n" +
                        "2) you check whether grade>passGrade and not grade>=";
                printError(140, "Student", "isCompleted", "algebra1", "true", "false", yuvalsNote);
            }
            if (s2.isCompleted(algebra1, 61)){
                errcounter_Class++;
                String yuvalsNote = "ther is 2 options:\n" +
                        "1) you always return tru\n" +
                        "2) you dont check if the grade is bigger then somthing";
                printError(141, "Student", "isCompleted", "algebra1", "true", "false", yuvalsNote);
            }
        }
        if(errcounter_Class==0)
            System.out.println("PASS");
        else
            System.out.println("failed, only "+errcounter_Class+" problems to fix");
        System.out.print("check averageGrade():           ");
        double myAnsd=(double)530/(double)6;
        if(s2.averageGrade()==myAnsd)
            System.out.println("PASS");
        else{
            System.out.println("failed - wrong answer - expected to:"+myAnsd);
            errcounter_Class++;
        }
        System.out.print("check setGrade():               ");
        s2.setGrade(algebra1,97);
        if(s2.getCourseGrade(algebra1).getGrade()==97)
            System.out.println("PASS");
        else{
            System.out.println("failed, only " + errcounter_Class + " problems to fix");
            errcounter_Class++;
        }
        Student s3=new Student(new StudentInfo("koren","gershony",413564282,"brnfeld 1 beer seva"),new BachelorDegree("spirit sience",9856));
        s3.registerTo(algebra1);
        s3.registerTo(algebra2);
        s3.registerTo(algebra3);
        s3.registerTo(algebra4);
        s3.addGrade(algebra1,90);
        s3.addGrade(algebra2,100);
        s3.addGrade(algebra3,91);
        s3.addGrade(algebra4,95);
        innerChecker=0;
        System.out.print("complareTo():                   ");
        //s2 - averageGrade(): 94.5 - id: 313564282
        //s3 - averageGrade(): 94.3 - id: 413564282
        if(s2.compareTo(s3)<=0){
            innerChecker++;
            errcounter_Class++;
            String yuvalsNote="you dont compare grades well";
            printError(138, "Student", "compareTo", "student with id:413564282 average:"+s3.averageGrade(), "positive number", "non-positive number", yuvalsNote);
        }
        s3.setGrade(algebra1,92);

        //s2 - averageGrade(): 94.5 - id: 313564282
        //s3 - averageGrade(): 94.5 - id: 413564282
        if(s2.compareTo(s3)>=0){
            innerChecker++;
            String yuvalsNote="you dont compare ids well";
            printError(142, "Student", "compareTo", "student with id:413564282 average:"+s3.averageGrade(), "negative", "non-negative number", yuvalsNote);
        }
        if(innerChecker==0)
            System.out.println("PASS");
        if(errcounter_Class==0)
            System.out.println("##Wow! you are the best! you are awesome! just a little more and you are there! i trust you!##");
        else
            System.out.println("failed. only "+errcounter_Class+" mistakes to fix");
        System.out.println("      ---  START: Class StudentManagementSystem  ---");
        StudentManagementSystem sms1=new StudentManagementSystem(56);
        System.out.print("constructor: ");
        if(sms1.getCourses()==null|sms1.getDegrees()==null|sms1.getStudents()==null|sms1.getFailTreshold()!=56){
            errcounter_Class++;
            String yuvalsNote="in constructor you need to initialize all fields";
            printError(143,"StudentManagementSystem","constructor","56","","",yuvalsNote);
        }
        if(errcounter_Class==0)
            System.out.println("PASS");
        else
            System.out.println("failed only "+errcounter_Class+" to fix");
        System.out.print("addStudent(), addDegree(), addCourse():");

        if(sms1.addStudent(s2)){
            errcounter_Class++;
            String yuvalsNote="don't add student who registered to a degree that doesn't exist in Student-Management-System";
            printError(144,"StudentManagementSystem","addStudent","student","false","true",yuvalsNote);
        }
        if(sms1.addDegree(d1)){
            errcounter_Class++;
            String yuvalsNote="don't add degree who have courses that doesn't exist in the Student-Management-System";
            printError(145,"StudentManagementSystem","addDegree","degree","false","true",yuvalsNote);
        }
        if(!sms1.addCourse(algebra1)){
            errcounter_Class++;
            String yuvalsNote="";
            printError(146,"StudentManagementSystem","addCourse","a course without preliminary","true","false",yuvalsNote);
        }
        if(sms1.addCourse(algebra2)){
            errcounter_Class++;
            String yuvalsNote="the course i added have 2 preliminary courses, algebra1 and matrix, matrix is not in the degree.";
            printError(147,"StudentManagementSystem","addCourse","a course 2 preliminary courses","false","true",yuvalsNote);
        }
        flag=true;
        flag&=sms1.addCourse(matrixs);
        flag&=sms1.addCourse(logic);
        flag&=sms1.addCourse(algebra2);
        flag&=sms1.addCourse(algebra3);
        flag&=sms1.addCourse(algebra4);
        flag&=sms1.addCourse(calculus1);
        flag&=sms1.addCourse(calculus2);
        flag&=sms1.addCourse(calculus3);
        flag&=sms1.addCourse(calculus4);
        if(!flag){
            errcounter_Class++;
            String yuvalsNote = "the courses i have tried to add supposed to be added, all his preliminary are in.";
            printError(148, "StudentManagementSystem", "addCourse", "some courses", "false", "true", yuvalsNote);
        }
        if(sms1.addDegree(d1)){
            errcounter_Class++;
            String yuvalsNote="don't add degree who have elective courses that doesn't exist in the Student-Management-System";
            printError(149,"StudentManagementSystem","addDegree","degree","false","true",yuvalsNote);
        }
        flag&=sms1.addCourse(fun1);
        flag&=sms1.addCourse(fun2);
        flag&=sms1.addCourse(fun3);
        flag&=sms1.addCourse(fun4);
        flag&=sms1.addCourse(fun5);
        flag&=sms1.addCourse(fun6);
        if(!sms1.addDegree(d1)){
            errcounter_Class++;
            String yuvalsNote="the degree i tried to add supposed to be added, all its courses are in";
            printError(150,"StudentManagementSystem","addDegree","degree","true","false",yuvalsNote);
        }
        if(!sms1.addDegree(myDegree)){
            errcounter_Class++;
            String yuvalsNote="the degree i tried to add supposed to be added, it have no courses.";
            printError(151,"StudentManagementSystem","addDegree","degree","true","false",yuvalsNote);
        }
        if(!sms1.addStudent(s2)){
            errcounter_Class++;
            String yuvalsNote="the students supposed to be added but";
            printError(152,"StudentManagementSystem","addStudent","students","true","false",yuvalsNote);
        }
        if(sms1.addStudent(s3)){
            errcounter_Class++;
            String yuvalsNote="the students NOT supposed to be added but";
            printError(1521,"StudentManagementSystem","addStudent","students","false","true",yuvalsNote);

        }
        sms1.addDegree(s3.getDegree());
        sms1.addStudent(s3);
        if(errcounter_Class==0)
            System.out.println("PASS");
        Course algebra6=new Course("algebra 6",1000,5);
        Course algebra7=new Course("algebra 7",1001,5);
        Course algebra8=new Course("algebra 8",1002,5);
        algebra6.addPreliminaryCourse(algebra5);
        algebra7.addPreliminaryCourse(algebra6);
        algebra8.addPreliminaryCourse(algebra7);
        System.out.print("getMissingPreCourses():                ");
        List<Course> lst1=sms1.getMissingPreCourses(algebra4,s2.getStudentInfo().getIdentityNumber());
        if(!(lst1.size()==1&&lst1.get(0).equals(matrixs))){
            errcounter_Class++;
            String yuvalsNote="that the student registered to a course that required matrixes doesn't mean he done matrixes";
            printError(153,"StudentManagementSystem","getMissingPreCourses","",singltone.toString(),getNamesCourses(lst1).toString(),yuvalsNote);
        }
        s2.registerTo(matrixs);
        s2.addGrade(matrixs,40);
        lst1=sms1.getMissingPreCourses(algebra4,s2.getStudentInfo().getIdentityNumber());
        if(!(lst1.size()==1&&lst1.get(0).equals(matrixs))){
            errcounter_Class++;
            String yuvalsNote="the student really did all courses but failed at 1 of them";
            printError(154,"StudentManagementSystem","getMissingPreCourses","",singltone.toString(),getNamesCourses(lst1).toString(),yuvalsNote);
        }
        s2.setGrade(matrixs,87);
        lst1=sms1.getMissingPreCourses(algebra4,s2.getStudentInfo().getIdentityNumber());
        if(!lst1.isEmpty()) {
            errcounter_Class++;
            String yuvalsNote="the student complited every course that is preliminary to algebra4";
            printError(155,"StudentManagementSystem","getMissingPreCourses","",singltone.toString(),getNamesCourses(lst1).toString(),yuvalsNote);
        }
        List<Course> bog=calculus4.getAllPreliminaryCourses();
        bog.add(calculus4);
        bog.removeAll(algebra3.getAllPreliminaryCourses());
        bog.remove(algebra3);
        bog.add(algebra4);
        List<Course> dudu=sms1.getMissingPreCourses(algebra5,s2.getStudentInfo().getIdentityNumber());
        if(!isListsEqualsAsSets(bog,dudu)){
            errcounter_Class++;
            String yuvalsNote="";
            if(bog.containsAll(dudu)){
                yuvalsNote="you missing courses, you don't count all of them";
            }else if(dudu.containsAll(bog))
                yuvalsNote="you count too much missing courses";
            else
                yuvalsNote="you missing courses, you don't count all of them AND you count too much missing courses";
            printError(156,"StudentManagementSystem","getMissingPreCourses","algebra5",getNamesCourses(bog).toString(),getNamesCourses(dudu).toString(),yuvalsNote);
        }
        if(!isSorted(dudu)){
            errcounter_Class++;
            String yuvalsNote="your output is not sorted";
            printError(180,"StudentManagementSystem","getMissingPreCourses","algebra5",getNamesCourses(bog).toString(),getNamesCourses(dudu).toString(),yuvalsNote);
        }
        if(errcounter_Class==0)
            System.out.println("PASS");
        else
            System.out.println("only "+errcounter_Class+" mistakes to fix");
        System.out.print("part1) register(), addGrade():         ");
        int id=s2.getStudentInfo().getIdentityNumber();
        flag= sms1.register(id,logic);
        if(flag){
            String yuvalsNote="you add course that is no exist in the grade";
            printError(157,"StudentManagementSystem","register","matrixes","","",yuvalsNote);
        }
        Degree d2=new ValidationDegree("pieace and love",1203,50);
        d2.addCourse(algebra7,true);
        d2.addCourse(fun1,false);
        d2.addCourse(fun2,false);
        d2.addCourse(fun3,false);
        Student s4=new Student(new StudentInfo("stiv","jobs",100000000,"america"),d2);
        d2.getMandatoryCourses().remove(algebra5);
        d2.getMandatoryCourses().remove(algebra6);
        d2.getMandatoryCourses().remove(algebra7);
        List<Course> lst2=new LinkedList<>();
        lst2.addAll(d2.getMandatoryCourses());
        lst2.addAll(d2.getElectiveCourses());
        lst2.removeAll(sms1.getCourses());

        sms1.getDegrees().add(d2);
        sms1.addStudent(s4);
        int id4=s4.getStudentInfo().getIdentityNumber();
        flag=true;

        flag &= sms1.register(id4,logic);
        Course fun7=new Course("fun7",307,6);
        s4.registerTo(fun6);
        s4.registerTo(fun7);
        if(sms1.addGrade(logic,id4+2,20)){
            errcounter_Class++;
            String yuvalsNote="you add grade to non-exist student";
            printError(158,"StudentManagementSystem","addGrade","logic,"+id4+2+",20","false","true",yuvalsNote);
        }
        if(sms1.addGrade(fun7,id4,20)){
            errcounter_Class++;
            String yuvalsNote="you add grade to non-exist course";
            printError(159,"StudentManagementSystem","addGrade","fun7,"+((int)id4+2)+",20","false","true",yuvalsNote);
        }
        if(sms1.addGrade(calculus1,id4,20)){
            errcounter_Class++;
            String yuvalsNote="you add grade to course that the student is not registered to";
            printError(160,"StudentManagementSystem","addGrade","calculus1,"+((int)id4+2)+",20","false","true",yuvalsNote);
        }
        if(!sms1.addGrade(logic,id4,20)){
            errcounter_Class++;
            String yuvalsNote="you dont add a valid grade";
            printError(161,"StudentManagementSystem","addGrade","logic,"+id4+",20","true","false",yuvalsNote);
        }
        if(!sms1.register(id4,logic)){
            errcounter_Class++;
            String yuvalsNote="you don't register a student that failed at that course";
            printError(162,"StudentManagementSystem","register","id4,logic","true","false",yuvalsNote);
        }
        if(!sms1.register(id4,calculus1)){
            errcounter_Class++;
            String yuvalsNote="you didn't added the course that have no preliminary courses";
            printError(163,"StudentManagementSystem","register","matrixes","","",yuvalsNote);
        }
        if(!sms1.addGrade(logic,id4,93)){
            errcounter_Class++;
            String yuvalsNote="you didn't added a grade that just the student failed before";
            printError(164,"StudentManagementSystem","addGrade","logic,"+id4+",93","true","false",yuvalsNote);
        }
        sms1.addGrade(calculus1,id4,37);
        if(sms1.register(id4,calculus2)){
            errcounter_Class++;
            String yuvalsNote="you registered a student to course that he failed in 1 of its preliminary courses";
            printError(165,"StudentManagementSystem","register","id4,calculus2","false","true",yuvalsNote);
        }
        if(sms1.addGrade(logic,id4,99)){
            errcounter_Class++;
            String yuvalsNote="you added a grade in course that the student already passed";
            printError(166,"StudentManagementSystem","addGrade","logic,"+id4+",99","false","true",yuvalsNote);
        }
        if(errcounter_Class==0)
            System.out.println("PASS");
        else
            System.out.println("only "+errcounter_Class+" to go");
        List<Pair<Integer,Integer>> pairs=new LinkedList<>();
        List<Student> arr=new LinkedList<>();
        List<Student> arr2=new LinkedList<>();
        for (int i = 0; i < 10; i++){
            Student student = new Student(new StudentInfo(""+((char)('a'+i)),""+((char)('a'+i)),id4+1+i,""+((char)('a'+i))),d2);
            arr.add(student);
            if(i<4)
                arr2.add(arr.get(i));
            sms1.addStudent(student);
            sms1.register(id4+1+i,calculus1);
        }
        for (int i = 0; i < 10; i++){
            Pair<Integer,Integer> pair=new Pair<>(arr.get(i).getStudentInfo().getIdentityNumber(),Math.min(i*14,100));
            pairs.add(pair);
        }
        List<Student> lstS=sms1.closeCourse(calculus1,pairs);
        if(!isListsEqualsAsSets(lstS,arr2)){
            errcounter_Class++;
            String yuvalsNote="you dont count fails good";
            printError(167,"StudentManagementSystem","closeCourse","calculus1,"+pairs.toString(),Arrays.toString(getNamesStudents(arr2)),Arrays.toString(getNamesStudents(lstS)),yuvalsNote);
        }
        List<Student> arr3=new LinkedList<>();
        for (int i = 0; i < 10; i++){
            if(!arr.get(i).isCompleted(calculus1,sms1.getFailTreshold()))
                arr3.add(arr.get(i));

        }
        if(!isListsEqualsAsSets(arr3,arr2)){
            errcounter_Class++;
            String yuvalsNote="you dont update student grades in closing";
            printError(168,"StudentManagementSystem","closeCourse","calculus1,"+pairs.toString(),Arrays.toString(getNamesStudents(arr2)),Arrays.toString(getNamesStudents(lstS)),yuvalsNote);
        }
        sms1.register(id4,calculus1);
        sms1.addGrade(calculus1,id4,70);
        flag=true;
        flag&=sms1.addCourse(algebra5);
        flag&=sms1.addCourse(algebra6);
        flag&=sms1.addCourse(algebra7);
        flag&=sms1.addCourse(algebra8);
        flag&=d2.addCourse(algebra5,true);
        flag&=d2.addCourse(algebra6,true);
        flag&=d2.addCourse(algebra7,true);
        //now the sum of all mandatory courses credits supposed to be 47
        d2.addCourse(algebra8,true);

        System.out.print("part2) register(), addGrade():         ");
        flag &= sms1.register(id4,calculus2);
        flag &= sms1.addGrade(calculus2,id4,78);
        flag &= sms1.register(id4,calculus3);
        flag &= sms1.addGrade(calculus3,id4,59);
        flag &= sms1.register(id4, matrixs);
        flag &= sms1.addGrade(matrixs,id4,98);
        flag &= sms1.register(id4, algebra1);
        flag &= sms1.addGrade(algebra1,id4,93);
        flag &= sms1.register(id4, algebra2);
        flag &= sms1.addGrade(algebra2,id4,93);
        flag &= sms1.register(id4, algebra3);
        flag &= sms1.addGrade(algebra3,id4,93);
        flag &= sms1.register(id4, algebra4);
        flag &= sms1.addGrade(algebra4,id4,93);
        flag &= sms1.register(id4, calculus4);
        flag &= sms1.addGrade(calculus4,id4,93);
        flag &= sms1.register(id4, algebra5);
        flag &= sms1.addGrade(algebra5,id4,93);
        flag &= sms1.register(id4, algebra6);
        flag &= sms1.addGrade(algebra6,id4,93);
        flag &= sms1.register(id4, algebra7);
        flag &= sms1.addGrade(algebra7,id4,93);
        if(flag)
            System.out.println("PASS");
        else{
            System.out.println("failed - supposed to add and register all of the above");
            return;
        }
        System.out.print("closeDegree():                         ");
        if(sms1.closeDegree(id4, 2017)){
            errcounter_Class++;
            String yuvalsNote="you have 2 more open elective courses, check it too, he is steal registered to it";
            printError(169,"StudentManagementSystem","closeDegree",id4+","+2017,"false","true",yuvalsNote);
        }
        s4.getDegree().addCourse(fun7,false);
        sms1.addGrade(fun6,id4,60);
        sms1.addCourse(fun7);
        sms1.addGrade(fun7,id4,10);
        if(sms1.closeDegree(id4, 2017)){
            errcounter_Class++;
            String yuvalsNote="this degree should NOT be closed, the student lacks credits.\n" +
                    "you probably count fun6 credits but it is not a course in his grade";
            printError(170,"StudentManagementSystem","closeDegree",id4+","+2017,"false","true",yuvalsNote);
        }
        s4.getDegree().addCourse(fun6,false);
        if(!sms1.closeDegree(id4, 2017)){
            errcounter_Class++;
            String yuvalsNote="this degree should be closed, i dont care if he failed an elective course, he got all credits needed";
            printError(1701,"StudentManagementSystem","closeDegree",id4+","+2017,"true","false",yuvalsNote);
        }
        if(errcounter_Class==0)
            System.out.println("PASS\n##you really passed it! it is really impressive! i am happy for you! this is the end of part 2!##\ncelebrate for it!");
        else{
            System.out.println("failed only "+errcounter_Class+" to fix");
            return;
        }
        System.out.println("   ------     START:  PART 3     ------");

        StudentManagementSystem sms2=new StudentManagementSystem(50);

        calculus1 = new Course("Calculus1", 105, 6);
        algebra1 = new Course("Algebra1", 100,6);
        logic = new Course("Logic", 97, 6);
        matrixs = new Course("Matrixs", 96, 6);
        sms2.addCourse(matrixs);
        sms2.addCourse(logic);
        sms2.addCourse(calculus1);
        sms2.addCourse(algebra1);
        Degree easyD=new MasterDegree("easyD",9341353,false);
        easyD.addCourse(matrixs,false);
        easyD.addCourse(logic,false);
        easyD.addCourse(calculus1,false);
        easyD.addCourse(algebra1,false);
        sms2.addDegree(easyD);
        clearListForReuse(lstS);

        for (int i = 0; i < 100; i++){
            String string = (numToStr(i));
            int cid=id4+1+i;
            Student student = new Student(new StudentInfo(string,string,cid,string),easyD);
            lstS.add(student);

            int g1=(((i+1)*940817)%1019)%100;
            int g2=(((i+1)*941513)%3889)%100;
            int g3=(((i+1)*969257)%2797)%100;
            int g4=(((i+1)*994769)%3307)%100;
            sms2.addStudent(student);
            sms2.register(cid,logic);
            sms2.register(cid,matrixs);
            sms2.register(cid,calculus1);
            sms2.register(cid,algebra1);
            sms2.addGrade(logic,cid,g1);
            sms2.addGrade(matrixs,cid,g2);
            sms2.addGrade(calculus1,cid,g3);
            sms2.addGrade(algebra1,cid,g4);

            boolean g=sms2.closeDegree(cid,2018);
        }

        // Trol Student - finish yeat doesn't feat

        String stringDufuk = (numToStr(100));
        int cidDafuk=id4+101;
        Student studentDafuk = new Student(new StudentInfo(stringDufuk,stringDufuk,cidDafuk,stringDufuk),easyD);
        lstS.add(studentDafuk);
        //this is cheater
        int g1Dafuk=100;
        int g2Dafuk=100;
        int g3Dafuk=100;
        int g4Dafuk=100;
        sms2.addStudent(studentDafuk);
        sms2.register(cidDafuk,logic);
        sms2.register(cidDafuk,matrixs);
        sms2.register(cidDafuk,calculus1);
        sms2.register(cidDafuk,algebra1);
        sms2.addGrade(logic,cidDafuk,g1Dafuk);
        sms2.addGrade(matrixs,cidDafuk,g2Dafuk);
        sms2.addGrade(calculus1,cidDafuk,g3Dafuk);
        sms2.addGrade(algebra1,cidDafuk,g4Dafuk);

        if(!sms2.closeDegree(cidDafuk,2001)){
            System.out.println("this one supposed to be add");
        }


        System.out.print("getFirstKStudents test1(exceptions): ");
        String yuvalsTmpNote="";
        int goodnesscounter=0;
        try{
            List<Student> tmplst=sms2.getFirstKStudents(null,2017,12);
            yuvalsTmpNote="didn't threw exception";
        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException)
                goodnesscounter++;
            else
                yuvalsTmpNote="didn't threw proper exception on *null* input";
        }
        try{
            sms2.getFirstKStudents(easyD,-1,12);
            yuvalsTmpNote="didn't threw proper exception on *negative* input";
        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException)
                goodnesscounter++;
            else
                yuvalsTmpNote="didn't threw proper exception on *negative* input";
        }
        try{
            sms2.getFirstKStudents(easyD,2017,-1);

        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException)
                goodnesscounter++;
            else
                yuvalsTmpNote="didn't threw proper exception on *negative* input";
        }
        try{
            sms2.getFirstKStudents(easyD,0,0);
            goodnesscounter++;
        }
        catch (Exception e){
            yuvalsTmpNote="zero values are ok";
            if(e instanceof IllegalArgumentException)
                goodnesscounter--;
        }
        if(goodnesscounter==4)
            System.out.println("PASS");
        else{
            System.out.println("failed. "+yuvalsTmpNote);
            errcounter_Class++;
        }
        System.out.print("getFirstKStudents test2:             ");
        String[] realNames12Students={"rb", "tc", "y", "vd", "kc", "nd", "q", "i", "od", "lc", "a", "rd"};
        String[] yourNames12Students=getNamesStudents(sms2.getFirstKStudents(easyD,2018,12));
        if(arrayEquals(realNames12Students,yourNames12Students))
            System.out.println("PASS");
        else{
            System.out.println("failed");
            errcounter_Class++;
        }
        System.out.print("getFirstKStudents test3:             ");
        String[] sec=getNamesStudents(sms2.getFirstKStudents(easyD,2018,102));
        if(sec.length==68)
            System.out.println("PASS");
        else if(sec.length==69) {
            System.out.println("dont let studentDafuk to enter, he closed his grade on 2001 not 2018");
        }
        else{
                System.out.println("failed");
                errcounter_Class++;
            }


        System.out.print("getFailStudents():                   ");

        String[] realNamesFailedLogic={"c", "d", "g", "h", "k", "l", "o", "p", "s", "t", "v", "w", "x", "z", "ab", "bb", "db", "eb", "fb", "hb", "ib", "jb", "mb", "nb", "qb", "ub", "yb", "cc", "gc", "jc", "kc", "nc", "oc", "rc", "sc", "vc", "wc", "xc", "zc", "ad", "bd", "dd", "ed", "hd", "id", "ld", "md", "pd", "qd", "td", "ud"};
        String[] realNamesFailedLogicSorted={"id", "ad", "x", "p", "h", "ab", "s", "bb", "t", "ed", "k", "wc", "qd", "xc", "l", "hd", "yb", "d", "nb", "zc", "rc", "w", "jc", "o", "fb", "sc", "td", "ud", "md", "bd", "qb", "z", "ld", "dd", "ib", "g", "cc", "jb", "vc", "nc", "db", "oc", "ub", "mb", "eb", "pd", "gc", "v", "c", "hb", "kc"};
        String[] yourNamesFailed=getNamesStudents(sms2.getFailStudents(logic));
        String tmpstrtoprint="\n*they didn't asked for sorting, but if you prefer one way or another i inform you.\n";
        if(arrayEquals(yourNamesFailed,realNamesFailedLogic))
            System.out.println("PASS - and not sorted");
        else if(arrayEquals(yourNamesFailed,realNamesFailedLogicSorted))
            System.out.println("PASS - and sorted");
        else{
            //System.out.println(namesToNamesArrayFormat(arrayToList(getNamesStudents(sms2.getFailStudents(logic))).toString()));
            System.out.println("failed");
            errcounter_Class++;
            tmpstrtoprint="";
        }
        System.out.print(tmpstrtoprint);


        Course kindness = new Course("Kindness", 1001, 5);
        Course forgiveness = new Course("Forgiveness", 1002,5);
        Course generosity = new Course("Generosity", 1003, 5);
        Course integrity = new Course("Integrity", 1004, 5);
        forgiveness.addPreliminaryCourse(kindness);
        generosity.addPreliminaryCourse(forgiveness);
        integrity.addPreliminaryCourse(generosity);
        sms2.addCourse(kindness);
        sms2.addCourse(forgiveness);
        sms2.addCourse(generosity);
        sms2.addCourse(integrity);
        Degree beingGood=new BachelorDegree("beingGood",9341353);
        beingGood.addCourse(kindness,true);
        beingGood.addCourse(forgiveness,true);
        beingGood.addCourse(generosity,true);
        beingGood.addCourse(integrity,true);

        sms2.addDegree(beingGood);
        clearListForReuse(lstS);

        for (int i = 0; i < 100; i++){
            String string = (numToStr(i));
            int cid=id4+1001+i;
            Student student = new Student(new StudentInfo(string,string,cid,string),beingGood);
            lstS.add(student);
            sms2.addStudent(student);

            int g1=(((i+1)*1278527)%1019);
            int g2=(((i+1)*1291967)%3889);
            int g3=(((i+1)*1295653)%2797);
            int g4=(((i+1)*1299827)%3307);
            int cut=10;
            if(g1%cut<cut-1){
                sms2.register(cid, kindness);
                if(g1%cut<(cut/2))
                    sms2.addGrade(kindness, cid, g1 % 50 + 50);
            }
            if(g2%cut<cut-1){
                sms2.register(cid, forgiveness);
                if(g2%cut<(cut/2))
                    sms2.addGrade(forgiveness, cid, g2 % 50 + 50);
            }
            if(g3%cut<cut-1){
                sms2.register(cid, generosity);
                if(g3%cut<(cut/2))
                    sms2.addGrade(generosity, cid, g3 % 50 + 50);
            }
            if(g4%cut<cut-1){
                sms2.register(cid, integrity);
                if(g4%cut<(cut/2))
                    sms2.addGrade(integrity, cid, g4 % 50 + 50);
            }
            boolean g=sms2.closeDegree(cid,2018);
        }
        String[] yuvalsAns1={"c", "d", "e", "i", "j", "k", "o", "p", "q", "u", "v", "w", "ab", "bb", "cb", "gb", "hb", "mb", "nb", "sb", "tb", "yb", "zb", "ec", "fc", "kc", "lc", "qc", "rc", "wc", "xc", "bd", "cd", "dd", "hd", "id", "jd", "nd", "od", "pd", "td", "ud", "vd"};
        String[] yuvalsAns2={"b", "f", "n", "r", "s", "db", "eb", "pb", "qb", "rb", "bc", "cc", "dc", "nc", "oc", "pc", "zc", "ad", "ld", "md", "qd"};
        String[] yuvalsAns3={"g", "y", "fb", "jb", "kb", "jc", "vc", "fd", "gd", "rd"};
        String[] yuvalsAns4={"x", "xb", "ic", "uc", "sd"};
        String[] yuvalAns2Sorted={"db", "bc", "cc", "ad", "pb", "qd", "nc", "md", "zc", "s", "rb", "f", "ld", "eb", "b", "dc", "r", "qb", "n", "oc", "pc"};
        String[] yuvalAns3Sorted={"y", "fd", "jc", "gd", "fb", "jb", "kb", "vc", "g", "rd"};
        String[] yuvalAns4Sorted={"uc", "xb", "x", "ic", "sd"};

        List<Student> lstS1=sms2.getRegisteredStudents(kindness);
        List<Student> lstS2=sms2.getRegisteredStudents(forgiveness);
        List<Student> lstS3=sms2.getRegisteredStudents(generosity);
        List<Student> lstS4=sms2.getRegisteredStudents(integrity);
        System.out.print("getRegisteredStudents() 1: ");
        try{
            sms2.getRegisteredStudents(null);
            errcounter_Class++;
            String yuvalsNote="you didn't throw a exception while needed\nand if it is not written that you can assume its not null - you can't assume";
            printError(171,"StudentManagementSystem","getRegisteredStudents","null","throw IllegalArgumentException","your function threw (probably unhandled) NullPointerException",yuvalsNote);
        }
        catch (Exception e){
            if(e instanceof IllegalArgumentException)
                System.out.println("PASS");
            else{
                errcounter_Class++;
                String yuvalsNote="there are 2 options:\n" +
                        "1) you didn't throw a exception.\n" +
                        "2) you threw exception but it is not 'IllegalArgumentException' as required.\n" +
                        "**pay attention:if it is not written that you can assume its not null - you can't assume";
                printError(172,"StudentManagementSystem","getRegisteredStudents","null","throw IllegalArgumentException","your function threw (probably unhandled) NullPointerException",yuvalsNote);
            }
        }
        System.out.print("getRegisteredStudents() 2: ");
        if(arrayEquals(getNamesStudents(lstS1),yuvalsAns1))
            System.out.println("PASS");
        else{
            System.out.println("failed");
            errcounter_Class++;
        }
        System.out.print("getRegisteredStudents() 3: ");
        if(arrayEquals(getNamesStudents(lstS2),yuvalsAns2))
            System.out.println("PASS - not sorted");
        else if(arrayEquals(getNamesStudents(lstS2),yuvalAns2Sorted)){
            System.out.println("PASS - sorted");
        }
        else{
                System.out.println("failed");
                System.out.println(namesToNamesArrayFormat(arrayToList(getNamesStudents(lstS2)).toString()));
                errcounter_Class++;
            }

        System.out.print("getRegisteredStudents() 4: ");
        if(arrayEquals(getNamesStudents(lstS3),yuvalsAns3))
            System.out.println("almost - just sort your list");
        else if(arrayEquals(getNamesStudents(lstS2),yuvalAns2Sorted)){
            System.out.println("PASS");
        }
        else{
            System.out.println("failed");
            System.out.println(namesToNamesArrayFormat(arrayToList(getNamesStudents(lstS3)).toString()));
            errcounter_Class++;
        }
        System.out.print("getRegisteredStudents() 5: ");
        if(arrayEquals(getNamesStudents(lstS4),yuvalsAns4))
            System.out.println("almost - just sort your list");
        else if(arrayEquals(getNamesStudents(lstS2),yuvalAns2Sorted)){
            System.out.println("PASS");
        }
        else{
            System.out.println("failed");
            System.out.println(namesToNamesArrayFormat(arrayToList(getNamesStudents(lstS4)).toString()));
            errcounter_Class++;
        }
        List<List<String>> lstOfYourAns=new LinkedList<>();
        for (Student student:lstS){
            int curid=student.getStudentInfo().getIdentityNumber();
            List<Course> lst=sms2.nextAvailableCourses(curid);
            if(lst.size()>1)
                lst=sms2.nextAvailableCourses(curid);
            List<String> curstrlst=courseNameToFirstLetters(getNamesCourses(lst));
            lstOfYourAns.add(curstrlst);
        }
        System.out.print("nextAvailableCourses():    ");

        String myAns="<<F>, <F>, <K>, <K>, <K>, <F>, <G>, <G>, <K>, <K>, <K>, <>, <F>, <F>, <K>, <K>, <K>, <F>, <F>, <>, <K>, <K>, <K>, <I>, <G>, <F>, <K>, <K>, <K>, <F>, <F>, <G>, <K>, <K>, <K>, <G>, <G>, <>, <K>, <K>, <K>, <F>, <F>, <F>, <K>, <K>, <K>, <G>, <>, <I>, <K>, <K>, <K>, <F>, <F>, <F>, <K>, <K>, <K>, <G>, <I>, <G>, <K>, <K>, <K>, <F>, <F>, <F>, <K>, <K>, <K>, <>, <I>, <G>, <K>, <K>, <K>, <F>, <F>, <K>, <K>, <K>, <>, <G>, <G>, <K>, <K>, <K>, <F>, <F>, <F>, <K>, <K>, <K>, <F>, <G>, <I>, <K>, <K>, <K>>";
        if(lstOfYourAns.toString().equals(myAns))
            System.out.println("PASS");
        else{
            System.out.println("failed");
            errcounter_Class++;
        }
        System.out.print("getMissingCourses():       ");
        myAns="<<F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <G, I>, <G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <I>, <G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <G, I>, <G, I>, <>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <G, I>, <>, <I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <G, I>, <I>, <G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <>, <I>, <G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <>, <G, I>, <G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <F, G, I>, <F, G, I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>, <F, G, I>, <G, I>, <I>, <K, F, G, I>, <K, F, G, I>, <K, F, G, I>>";
        clearListForReuse(lstOfYourAns);
        for (Student student:lstS){
            int curid=student.getStudentInfo().getIdentityNumber();
            List<Course> lst=sms2.getMissingCourses(curid);
            List<String> curstrlst=courseNameToFirstLetters(getNamesCourses(lst));
            lstOfYourAns.add(curstrlst);
        }
        if(lstOfYourAns.toString().equals(myAns))
            System.out.println("PASS");
        else{
            System.out.println("failed");
            errcounter_Class++;
        }
        if(errcounter_Class!=0){
            System.out.println("failed, only "+errcounter_Class+" problems to fix");
            return;
        }

        System.out.println("null tests:");


        Exception e1=null;
        try{
            forgiveness.isPreliminaryCourse(null);
        }
        catch (Exception e){
            e1=e;
        }
        if(!printNullTest(e1,"isPreliminaryCourse").contains("PASS"))
            errcounter_Class++;


        Exception e2=null;
        try{
            forgiveness.compareTo(null);
        }
        catch (Exception e){
            e2=e;
        }
        if(!printNullTest(e2,"compareTo").contains("PASS"))
            errcounter_Class++;


        Exception e3=null;
        try{
            forgiveness.addPreliminaryCourse(null);
        }
        catch (Exception e){
            e3=e;
        }
        if(!printNullTest(e3,"addPreliminaryCourse").contains("PASS"))
            errcounter_Class++;


        Exception e4=null;
        try{
            forgiveness.addPreliminaryCourses(null);
        }
        catch (Exception e){
            e4=e;
        }
        if(!printNullTest(e4,"addPreliminaryCourses").contains("PASS"))
            errcounter_Class++;


        Exception e6=null;
        try{
            List<Course> lst=new LinkedList<>();
            lst.add(forgiveness);
            lst.set(0,null);
            forgiveness.addPreliminaryCourses(lst);
        }
        catch (Exception e){
            e6=e;
        }
        if(!printNullTest(e6,"addPreliminaryCourses").contains("PASS"))
            errcounter_Class++;


        Exception e7=null;
        try{
            d2.addCourse(null,true);
        }
        catch (Exception e){
            e7=e;
        }
        if(!printNullTest(e7,"addCourse").contains("PASS"))
            errcounter_Class++;


        Exception e8=null;
        try{
            s1.compareTo(null);
        }
        catch (Exception e){
            e8=e;
        }
        if(!printNullTest(e8,"compareTo").contains("PASS"))
            errcounter_Class++;


        Exception e9=null;
        try{
            sms1.addGrade(null,id4,80);
        }
        catch (Exception e){
            e9=e;
        }
        if(!printNullTest(e9,"addGrade").contains("PASS"))
            errcounter_Class++;


        Exception e10=null;
        try{
            sms2.closeCourse(null,pairs);
        }
        catch (Exception e){
            e10=e;
        }
        if(!printNullTest(e10,"closeCourse").contains("PASS"))
            errcounter_Class++;


        Exception e11=null;
        try{
            sms2.closeCourse(kindness,null);
        }
        catch (Exception e){
            e11=e;
        }
        if(!printNullTest(e11,"closeCourse").contains("PASS"))
            errcounter_Class++;


        Exception e12=null;
        try{
            sms2.getFailStudents(null);
        }
        catch (Exception e){
            e12=e;
        }
        if(!printNullTest(e12,"getFailStudents").contains("PASS"))
            errcounter_Class++;



        Exception e13=null;
        try{
            sms2.getRegisteredStudents(null);
        }
        catch (Exception e){
            e13=e;
        }
        if(!printNullTest(e13,"getRegisteredStudents").contains("PASS"))
            errcounter_Class++;

        System.out.print("extra chack1:");
        if(sms2.addCourse(kindness)){
            errcounter_Class++;
            System.out.println("don't add this course , it is already exist.");
        }
        else
            System.out.println("PASS");
        System.out.print("extra chack2:");
        if(sms2.addStudent(studentDafuk)){
            errcounter_Class++;
            System.out.println("don't add this student, it is already exist.");
        }
        else
            System.out.println("PASS");
        System.out.print("extra chack3:");
        if(sms2.addDegree(easyD)){
            errcounter_Class++;
            System.out.println("don't add this degree, it is already exist.");
        }
        else
            System.out.println("PASS");

        System.out.print("overall: ");
        if(errcounter_Class!=0)
            System.out.println("failed. only "+errcounter_Class+" mistakes remain");
        if(errcounter_Class==0){
            System.out.println("\n______________________________");
            System.out.println("-------------PASS-------------");
            System.out.println("______________________________");
            System.out.println("now you really finished!\ngo a head,  take some friends, get drunk togrther and have fun, you deserve it!");

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

            Date timeNow=cal.getTime();

            String string = "31.12.17 12";
            DateFormat format = new SimpleDateFormat("dd.MM.yy HH",Locale.ENGLISH);
            Date deadLine =cal.getTime();
            try{
                deadLine=format.parse(string);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            if(deadLine.compareTo(timeNow)>0){
                long diff=deadLine.getTime()-timeNow.getTime();
                long days = diff/ (1000 * 60 * 60 * 24);
                long allMinutes=(diff/(1000 * 60));
                long allHours=(diff/(1000 * 60 * 60));
                long hours=allHours-(days*24);
                long minutes=allMinutes-allHours*60;
                System.out.println("\ntime left for Submission (d:hh:mm): "+ days+":"+hours+":"+minutes+"" );
            }
            if(deadLine.compareTo(timeNow)<0){
                System.out.println("too late my son.. never mind, you may try next time..");
            }

            System.out.println("   ------     END:  PART 3     ------");
            System.out.println("---------     END: OVERALL     --------- ");
        }
    }
    public static String printNullTest(Exception e, String func){
        String yuvalsNote=func+": ";
        if (e == null)
            yuvalsNote+= "you don't throw an exception";
        else if(!e.getStackTrace()[0].getMethodName().equals(func))
            yuvalsNote += "an exception was not thrown from you function but from: "+e.getStackTrace()[0].getMethodName();
        else if(!(e instanceof IllegalArgumentException))
            yuvalsNote+=  "an exception was thrown but it's not IllegalArgumentException";
        else
            yuvalsNote+=  "PASS";
        System.out.println( yuvalsNote);
        return yuvalsNote;
    }
    public static String namesToNamesArrayFormat(String str){
        String output=str;
        output=output.replaceAll(", ","\", \"");
        output=output.replaceAll("]","\"}");
        output=output.replaceAll("\\[","{\"");
        output=output.replaceAll(">","\"}");
        output=output.replaceAll("\\<","{\"");
        return output;
    }
    public static <T> boolean arrayEquals(T[] arr1,T[] arr2){
        if(arr1.length!=arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++){
            if(!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }
    public static <T> void clearListForReuse(List<T> lst){
        while(!lst.isEmpty())
            lst.remove(lst.get(0));
    }
    public static List<String> courseNameToFirstLetters(List<String> lst){
        List<String> output=new LinkedList<>();
        for (int i = 0; i < lst.size(); i++){
            String str = lst.get(i);
            str=str.substring(0,1);
            output.add(str);
        }
        return output;
    }
    public static List<String> getNamesCourses (List<Course> lst){
        List<String> output=new LinkedList<>();
        for (int i = 0; i < lst.size(); i++){
            String name = lst.get(i).getName();
            output.add(name);
        }
        return output;
    }
    public static String[] getNamesStudents (List<Student> lst){
        String[] arr=new String[lst.size()];
        for (int i = 0; i < arr.length; i++){
            String name = lst.get(i).getStudentInfo().getFirstName();
            arr[i]=name;
        }
        return arr;
    }
    public static <T> List<T> arrayToList(T[] arr){
        List<T> lst=new LinkedList<>();
        for (T t : arr){
            lst.add(t);
        }
        return lst;
    }
    public static <T> boolean isListsEqualsAsSets(List<T> lst1,List<T> lst2){
            return lst1.containsAll(lst2)&&lst2.containsAll(lst1);
    }
    public static <T extends Comparable<T>> boolean isSorted(List<T> lst){
        for (int i = 0; i < lst.size() - 1; i++)
            if (lst.get(i).compareTo(lst.get(i + 1)) > 0)
                return false;
        return true;
    }
    public static void printError(int errorID, String className,String func,String input,String expectedOutput,String youroutput,String YuvalZilbersNote){
        String str = "\n**Error "+errorID+"**";
        str+="\n----class            :  " + className;
        str+="\n----function         :  " + func;
        str+="\n----checked input    :  " + input;
        str+="\n----your output      :  " + youroutput;
        str+="\n----expected output  :  " + expectedOutput;
        if(!YuvalZilbersNote.equals("")){
            str += "\n----Yuval's comment  :  ";
            str += YuvalZilbersNote;
        }
        System.out.println(str);
    }
    public static <Type extends Comparable> boolean testGethig(List<Type> lst, Type element, int ans){
        int yourans=5555;
        boolean flag = ans==yourans;
        if(!flag) {
            System.out.println(lst+"\n"+element+"\n"+yourans);
        }
        return flag;
    }
    public static String numToStr(int num){
        double len=(int)(Math.log(num)/Math.log(26));
        if(len==(int)(Math.log(0)/Math.log(26)))
            len=0;
        if(len==(int)len)
            len=(int)len+1;
        int rlen=(int)len;
        int[] arr=new int[rlen];
        for (int i = 0; i < rlen; i++){
            arr[i]=num%26;
            num/=26;
        }
        String str="";
        char[] chars=new char[rlen];
        for (int i = 0; i < rlen; i++){
            str+=(char)('a'+arr[i]);
        }
        return str;
    }

}

class ValidationDegree extends  Degree{
    @Override
    public String getDegreeName(){
        return super.getDegreeName();
    }
    public ValidationDegree(String name, int degreeCode, int requiredCredits){
        super(name, degreeCode, requiredCredits);
    }
    @Override
    public int getDegreeCode(){
        return super.getDegreeCode();
    }

    @Override
    public List<Course> getMandatoryCourses(){
        return super.getMandatoryCourses();
    }

    @Override
    public List<Course> getElectiveCourses(){
        return super.getElectiveCourses();
    }

    @Override
    public boolean addCourse(Course course, boolean mandatory){
        return super.addCourse(course, mandatory);
    }

    @Override
    public int getRequiredCredits(){
        return super.getRequiredCredits();
    }

    @Override
    public int getMandatoryCredits(){
        return super.getMandatoryCredits();
    }
}
