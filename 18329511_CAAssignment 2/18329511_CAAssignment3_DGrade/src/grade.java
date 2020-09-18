import org.junit.Test;

import static org.junit.Assert.*;

public class grade {

    public double total = 25; // total number of marks received


    public void setTotal(double am){ // method that increases/decreases the total by a given amount
        this.total += am;
    }

    public double getTotal(){ // method that returns the total
        return this.total;
    }



    public void runAll(){ // method that runs all tests

        checkGetName();
        checkGetAge();
        checkGetEmail();
        checkGetEmailLowerCase();
        checkSetName();
        checkSetAge();
        checkSetEmail();
        checkNameConstructor();
        checkNameAgeConstructor();
        checkNameAgeEmailConstructor();
        testCheckNameNull();
        testCheckNameLength();
        testCheckNamePrefix1();
        testCheckNamePrefix2();
        testCheckNamePrefix3();
        testCheckNamePrefix4();
        testCheckNamePrefix5();
        testCheckAgeRange1();
        testCheckAgeRange2();
        testCheckEmailMatchesName1();
        testCheckEmailMatchesName2();
        testCheckEmailDomainSpecialCharacter();
        testCheckEmailDomainNull1();
        testCheckEmailDomainNull2();
        testCheckEmailDomainExtensionValid();
        testCheckEmailDomainExtensionNull1();
        testCheckEmailDomainExtensionNull2();
        checkToStringName();
        checkToStringNameAge();
        checkToStringNameAgeEmail();
    }

    // Part (a) - 3 marks

    @Test
    public void checkGetName(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully");
            assertEquals("John Scully", testUser.getName());
        }

        catch(Exception e) {
            setTotal(-0.5); // if exception is caught, deduct 0.5 marks
        }


    }

    @Test
    public void checkGetAge(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22);
            assertEquals(22, testUser.getAge());
        }

        catch(Exception e) {
            setTotal(-0.5);
        }

    }

    @Test
    public void checkGetEmail(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "john.scully@ucd.ie");
            assertEquals("john.scully@ucd.ie", testUser.getEmail());
        }

        catch(Exception e) {
            setTotal(-0.25);
        }

    }

    @Test
    public void checkGetEmailLowerCase(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie");
            assertEquals("john.scully@ucd.ie", testUser.getEmail());
        }

        catch(Exception e) {
            setTotal(-0.25);
        }
    }

    @Test
    public void checkSetName(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie");
            testUser.setName("Jack");
            assertEquals("Jack", testUser.getName());
        }

        catch(Exception e) {
            setTotal(-0.5);
        }
    }

    @Test
    public void checkSetAge(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully");
            testUser.setAge(24);
            assertEquals(24, testUser.getAge());
        }

        catch(Exception e) {
            setTotal(-0.5);
        }
    }

    @Test
    public void checkSetEmail(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22);
            testUser.setEmail("john.scully@ucdconnect.ie");
            assertEquals("john.scully@ucdconnect.ie", testUser.getEmail());
        }

        catch(Exception e) {
            setTotal(-0.5);
        }
    }

    // Part (b) - 3 marks

    @Test
    public void checkNameConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully");
        }

        catch(Exception e) {
            setTotal(-1);
        }

    }

    @Test
    public void checkNameAgeConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22);
        }

        catch(Exception e) {
            setTotal(-1);
        }
    }

    @Test
    public void checkNameAgeEmailConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "john.scully@ucdconnect.ie");
        }

        catch(Exception e) {
            setTotal(-1);
        }
    }

    // Part c - 12 marks

    @Test
    public void testCheckNameNull(){
        boolean thrown = false;

        try{
            CheckedUser testUser = new CheckedUser("");
        }
        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try{
            assertTrue(thrown); // try assertTrue for variable thrown
        }
        catch (AssertionError e){ // if AssertionError is caught, deduct 1 mark
            setTotal(-1);
        }


    }

    @Test
    public void testCheckNameLength(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Patrick James Scully");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-1);
        }

    }


    @Test
    public void testCheckNamePrefix1(){
        boolean thrown = false;

        try{
            CheckedUser testUser1 = new CheckedUser("Mr John");

        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.4);
        }

    }

    @Test
    public void testCheckNamePrefix2(){
        boolean thrown = false;

        try{
            CheckedUser testUser2 = new CheckedUser("Mrs John");

        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.4);
        }

    }

    @Test
    public void testCheckNamePrefix3(){
        boolean thrown = false;

        try{
            CheckedUser testUser3 = new CheckedUser("Miss John");

        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.4);
        }

    }

    @Test
    public void testCheckNamePrefix4(){
        boolean thrown = false;

        try{
            CheckedUser testUser4 = new CheckedUser("Ms John");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.4);
        }

    }

    @Test
    public void testCheckNamePrefix5(){
        boolean thrown = false;

        try{
            CheckedUser testUser5 = new CheckedUser("Dr John");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.4);
        }

    }

    @Test
    public void testCheckAgeRange1(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John", 17);
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }


        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-1);
        }
    }

    @Test
    public void testCheckAgeRange2(){
        boolean thrown = false;
        try{
            CheckedUser testUser2 = new CheckedUser("John", 31);
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-1);
        }
    }

    @Test
    public void testCheckEmailMatchesName1(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "myemailaddress@ucd.ie");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }


        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-1);
        }

    }


    @Test
    public void testCheckEmailMatchesName2(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John", 20, "myemailaddress@ucd.ie");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }


        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-1);
        }

    }

    @Test
    public void testCheckEmailDomainNull1(){
        boolean thrown = false;


        try{
            CheckedUser testUser1 = new CheckedUser("John Scully", 20, "john.scully@ .ie");

        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }


    }

    @Test
    public void testCheckEmailDomainNull2() {
        boolean thrown = false;
        try {
            CheckedUser testUser1 = new CheckedUser("John Scully", 20, "john.scully@.ie");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }


        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }
    }

    @Test
    public void testCheckEmailDomainSpecialCharacter(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@u*d.ie");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }


        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }
    }

    @Test
    public void testCheckEmailDomainExtensionNull1(){
        boolean thrown = false;


        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@ucd.");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }
    }

    @Test
    public void testCheckEmailDomainExtensionNull2(){
        boolean thrown = false;


        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@ucd. ");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }
    }


    @Test
    public void testCheckEmailDomainExtensionValid(){
        boolean thrown = false;

        try{
            CheckedUser testUser = new CheckedUser("John Scully", 25, "john.scully@ucd.abcd");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        try {
            assertTrue(thrown);
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }
    }

    // Part d - 2 marks

    @Test
    public void checkToStringName(){


        try {
            CheckedUser testUser = new CheckedUser("John Scully");
            assertEquals("CheckedUser: John Scully", testUser.toString());
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }

    }


    @Test
    public void checkToStringNameAge(){


        try {
            CheckedUser testUser = new CheckedUser("John Scully", 22);
            assertEquals("CheckedUser: John Scully (22)", testUser.toString());
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }

    }


    @Test
    public void checkToStringNameAgeEmail(){

        try {
            CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie");
            assertEquals( "CheckedUser: John Scully (22), john.scully@ucd.ie", testUser.toString());
        }
        catch(AssertionError e){
            setTotal(-0.66);
        }

    }

    /* method to calculate the grade
     * takes double total - the marks scored
     * returns string - the grade corresponding to the total */
    public String calculateGrade(double total) {

        total = (total/25 * 100);  // convert total (the marks scored) to a percentage

        if(total >= 95)
            return "A+";

        else if(total >= 90)
            return "A";

        else if(total >= 85)
            return "A-";

        else if(total >= 80)
            return "B+";

        else if(total >= 75)
            return "B";

        else if(total >= 70)
            return "B-";

        else if(total >= 65)
            return "C+";

        else if(total >= 60)
            return "C";

        else if(total >= 55)
            return "C-";

        else if(total >= 50)
            return "D+";

        else if(total >= 45)
            return "D";

        else if(total >= 40)
            return "D-";

        else if(total >= 35)
            return "E+";

        else if(total >= 30)
            return "E";

        else if(total >= 25)
            return "E-";

        else if(total >= 20)
            return "F+";

        else if(total >= 15)
            return "F";

        else if(total >= 10)
            return "F-";

        else if(total >= 8)
            return "G+";

        else if(total >= 5)
            return "G";

        else if(total >= 2)
            return "G-";

        else
            return "NG";

    }


}
