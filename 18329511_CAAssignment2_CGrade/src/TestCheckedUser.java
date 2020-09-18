import org.junit.Test;
import static org.junit.Assert.*;

public class TestCheckedUser {

    // Part (a) - 3 marks

    // tests the getName method
    @Test
    public void checkGetName(){
        try{

            CheckedUser testUser = new CheckedUser("John Scully"); // construct an instance of CheckedUser
            assertEquals("John Scully", testUser.getName()); // assert if string returned for getName is equal to expected
        }

        catch(Exception e) { // catch any exceptions
        }
        // will fail if string returned for getName is not equal to expected
    }

    // tests the getAge method
    @Test
    public void checkGetAge(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22);
            assertEquals(22, testUser.getAge()); // assert if int returned for getAge is equal to expected 22
        }

        catch(Exception e) {
        }
    }

    // tests the getEmail method
    @Test
    public void checkGetEmail(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "john.scully@ucd.ie");
            assertEquals("john.scully@ucd.ie", testUser.getEmail()); // assert if string returned for getEmail is equal to expected "john.scully@ucd.ie"
        }

        catch(Exception e) {
        }
    }

    // tests the getEmail method again to ensure it stores email in lower case
    @Test
    public void checkGetEmailLowerCase(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie");
            assertEquals("john.scully@ucd.ie", testUser.getEmail());
        }

        catch(Exception e) {
        }
    }

    // tests the setName method
    @Test
    public void checkSetName(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie"); // construct instance of CheckedUser, setting name to "John Scully"
            testUser.setName("Jack"); // set name to Jack using setName
            assertEquals("Jack", testUser.getName()); // assert if getName returns the new name, "Jack"
        }

        catch(Exception e) {
        }
    }

    // tests the setAge method
    @Test
    public void checkSetAge(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully");
            testUser.setAge(24);
            assertEquals(24, testUser.getAge()); // assert if getAge is equal to expected age, 22
        }

        catch(Exception e) {
        }
    }

    // tests the setEmail method
    @Test
    public void checkSetEmail(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22);
            testUser.setEmail("john.scully@ucdconnect.ie");
            assertEquals("john.scully@ucdconnect.ie", testUser.getEmail()); // assert if string returned for getEmail is equal to expected "john.scully@ucdconnect.ie"
        }

        catch(Exception e) {
        }
    }

    // Part (b) - 3 marks

    // tests the constructor for just name
    @Test
    public void checkNameConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully"); // construct an instance of CheckedUser with just name
        }

        catch(Exception e) { // catch any exceptions
        }
    }

    // tests the constructor for name and age
    @Test
    public void checkNameAgeConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22); // construct an instance of CheckedUser with name and age
        }

        catch(Exception e) {
        }
    }

    // tests the constructor for name, age and email
    @Test
    public void checkNameAgeEmailConstructor(){
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 22, "john.scully@ucdconnect.ie"); // construct an instance of CheckedUser with name, age and email
        }

        catch(Exception e) {
        }
    }

    // Part c - 12 marks

    /*  Tests if name is valid
        IllegalArgumentException should be thrown if name entered is "" */
    @Test
    public void testCheckNameNull(){
        boolean thrown = false; // variable thrown of type boolean set to false

        try{
            CheckedUser testUser = new CheckedUser(""); // construct instamce of CheckedUser with name ""
        }
        catch(IllegalArgumentException e) {
            thrown = true; // if an IllegalArgumentException is thrown it will be caught here and thrown will be set to true
        }
        assertTrue(thrown); // asserts if thrown is true - ie asserts if IllegalArgumentException was thrown
                            // therefore fails if no IllegalArgumentException is thrown
    }

    /*  Tests if name is valid
        name should have no prefix - Mr, Mrs, Ms, Miss, Dr - should throw IllegalArgumentException if prefix is present
        testCheckNamePrefix1 - estCheckNamePrefix5 test each of these prefixes     */
    @Test
    public void testCheckNamePrefix1(){
        boolean thrown = false; // same as previous with set variable thrown of type boolean to false, set to true if IllegalArgumentException is thrown, assert if it is true

        try{
            CheckedUser testUser1 = new CheckedUser("Mr John"); // construct instance of CheckedUser with prefix in name
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
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
        assertTrue(thrown);
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
        assertTrue(thrown);
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
        assertTrue(thrown);
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
        assertTrue(thrown);
    }

    /* Tests if name is valid
    * name should be 1 word or 2 */
    @Test
    public void testCheckNameLength(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Patrick James Scully"); // construct instance of CheckedUser with more than 2 words in name
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if age is valid
     * name should be greater than 18 */
    @Test
    public void testCheckAgeRange1(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John", 17);
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    /* Tests if age is valid
     * name should be less than 30 */
    @Test
    public void testCheckAgeRange2(){
        boolean thrown = false;
        try{
            CheckedUser testUser2 = new CheckedUser("John", 31);
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * username in email should match name entered
     * If name is 2 words, email should be <firstname>.<lastname>@<somewhere>.<something> */
    @Test
    public void testCheckEmailMatchesName1(){ // tests for when name is 2 words
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "myemailaddress@ucd.ie"); // construct instance of CheckedUser with email that does not match name, and name that is 2 words
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * username in email should match name entered
     * If name is 1, email should be <name>@<somewhere>.<something> */
    @Test
    public void testCheckEmailMatchesName2(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John", 20, "myemailaddress@ucd.ie"); // construct instance of CheckedUser with email that does not match name, and name that is 1 word
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain should not be null/ blank  */
    @Test
    public void testCheckEmailDomainNull1(){ // tests for email domain " "
        boolean thrown = false;


        try{
            CheckedUser testUser1 = new CheckedUser("John Scully", 20, "john.scully@ .ie"); // construct instance of CheckedUser with email domain " "

        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain should not be null/ blank  */
    @Test
    public void testCheckEmailDomainNull2() { // tests for email domain ""
        boolean thrown = false;
        try {
            CheckedUser testUser1 = new CheckedUser("John Scully", 20, "john.scully@.ie"); // construct instance of CheckedUser with email domain ""
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain should not contain special characters  */
    @Test
    public void testCheckEmailDomainSpecialCharacter(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@u*d.ie"); // construct instance of CheckedUser with email domain containing special characters
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain extension should not be null/ blank  */
    @Test
    public void testCheckEmailDomainExtensionNull1(){
        boolean thrown = false;


        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@ucd."); // construct instance of CheckedUser with email domain extension ""
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain extension should not be null/ blank  */
    @Test
    public void testCheckEmailDomainExtensionNull2(){
        boolean thrown = false;


        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@ucd. "); // construct instance of CheckedUser with email domain extension " "
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    /* Tests if email is valid
     * Edge Case: email domain extension should not be .com or .ie  */
    @Test
    public void testCheckEmailDomainExtensionValid(){
        boolean thrown = false;
        try{
            CheckedUser testUser = new CheckedUser("John Scully", 20, "john.scully@ucd.abcd");
        }

        catch(IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    // Part d - 2 marks

    // Tests toString for CheckedUser constructed with just name
    @Test
    public void checkToStringName(){

        CheckedUser testUser = new CheckedUser("John Scully");
        assertEquals("CheckedUser: John Scully", testUser.toString());
    }

    // Tests toString for CheckedUser constructed with name and age
    @Test
    public void checkToStringNameAge(){

        CheckedUser testUser = new CheckedUser("John Scully", 22);
        assertEquals("CheckedUser: John Scully (22)", testUser.toString());
    }

    // Tests toString for CheckedUser constructed with name, age and email
    @Test
    public void checkToStringNameAgeEmail(){

        CheckedUser testUser = new CheckedUser("John Scully", 22, "John.Scully@ucd.ie");
        assertEquals( "CheckedUser: John Scully (22), john.scully@ucd.ie", testUser.toString());

    }
}

