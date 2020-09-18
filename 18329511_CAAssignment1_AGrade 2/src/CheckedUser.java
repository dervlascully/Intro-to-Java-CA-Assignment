public class CheckedUser implements User {

    // A grade (ie "B grade or higher" answer)

    private String name;
    private String email;
    private int age;


    public CheckedUser(String name){  // Constructor for just name
        checkName(name); // Checks that the name is valid, will throw IllegalArgumentException if not valid
        this.name = name; // if it is valid, sets name to name entered
    }

    public CheckedUser(String name, int age){  // Constructor for name and age
        this(name); // calls the constructor for name above
        checkAgeRange(age); // Checks that the age is valid, will throw IllegalArgumentException if not valid
        this.age = age; // if it is valid, sets age to age entered
    }

    public CheckedUser(String name, int age, String email) {  // constructor for name, age and email
        this(name, age); // calls the constructor for name and age, which in turn calls the constructor for just name
        checkEmail(name, email); // Checks that the email is valid, will throw IllegalArgumentException if not valid
        this.email = email.toLowerCase(); // if it is valid, sets email to email entered. Convert email to lowercase
    }

    // method that returns the value for name for a given instance of CheckedUser
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        checkName(name); // Checks that the name is valid, will throw IllegalArgumentException if not valid
        this.name = name; // if it is valid, sets name to name entered
    }

    // method that returns the value for email for a given instance of CheckedUser
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        checkEmail(this.name, email); // Checks that the email is valid, will throw IllegalArgumentException if not valid
        this.email = email.toLowerCase(); // if it is valid, sets email to email entered
    }

    // method that returns the value for age for a given instance of CheckedUser
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        checkAgeRange(age); // Checks that the age is valid, will throw IllegalArgumentException if not valid
        this.age = age; // if it is valid, sets age to age entered
    }

    // Calls methods to check name validity
    public void checkName(String name){
        checkNameNull(name);
        checkNamePrefix(name);
        checkNameLength(name);
//        checkNameSpecialCharacter(name);
    }

    // Calls methods to check email validity
    public void checkEmail(String name, String email){
        checkEmailMatchesName(name, email);
        checkEmailDomainNull(email);
        checkEmailDomainSpecialCharacters(email);
        checkEmailDomainExtensionNull(email);
        checkEmailValidExtension(email);
    }

    // Check if the age entered is between 18 and 30 (inclusive)
    public void checkAgeRange(int age){
        if(age<18 || age>30){
            throw new IllegalArgumentException("Age must be between 18 and 30"); // throw exception if age is not between 18 and 30
        }
    }

    // Check if name was left blank, ie "" or " "

  public void checkNameNull(String name){

        String[] nameSplit = name.split(" ");

        if(name.equals("") || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be blank");
        }


        /* Split name over the whitespace to separate it into first name and last name  - name.split(" ")
        split function splits a string over a given regex and returns an array of strings from either side of the regex
        eg splitting the string "Dervla Scully" over " " (whitespace) will return an array of strings (in this case called nameSplit) , the first element of which will be "Dervla" and the second "Scully"
         */

    }

    // Check if name has a prefix

    public void checkNamePrefix(String name){
        String[] nameSplit = name.split(" "); // same as above


        // if the first element in the array returned from the split is equal to Mr/Mrs/etc
        if(nameSplit[0].equals("Mr") || nameSplit[0].equals("Mrs") || nameSplit[0].equals("Ms") || nameSplit[0].equals("Miss") || nameSplit[0].equals("Dr")){
            throw new IllegalArgumentException("Name must have no prefix (eg  Mr, Mrs, Ms, Miss, Dr.");
        }
    }

    // checks if name is made up of more than 2 words
    public void checkNameLength(String name){
        String[] nameSplit = name.split(" "); // same as abaove

        if(nameSplit.length > 2){
            throw new IllegalArgumentException("Name must be 1 or 2 words.");
        }

        /* if name is 4 words, e.g. Kate Ellen Mary Smith, then ' String[] nameSplit = name.split(" ");  ' will
        * give us the array of Strings nameSplit which will hold "Kate" "Ellen" "Mary" "Smith" as its elements.
        * Therefore,  nameSplit.length = 4.
        * Name cannot be more than two words, therefore throw exception if nameSplit.length > 2 */

    }

//
//    // Edge Case: Check if a special character or a number was entered as a character in the name
//
//    public void checkNameSpecialCharacter(String name){
//
//        for(int i=0; i<name.length(); i++){
//            if (!  ( (Character.isLetter(name.charAt(i) ) ) || name.charAt(i) == ' ')){
//                throw new IllegalArgumentException("Name cannot contain special characters or numbers.");
//            }
//        }
//
//    }


    // check name in email matches name and is in the correct form

    public void checkEmailMatchesName(String name, String email){

        String[] split1 = email.split("@");  // eg splits "dervla.scully@ucdconnect.ie" into "dervla.scully" and "ucdconnect.ie" and stores these strings in an array
        String[] nameSplit = name.split(" "); // splits name as done above

        if(     (nameSplit.length == 1 && ! ( split1[0].toLowerCase().equals(nameSplit[0].toLowerCase()))   )  ||    (  nameSplit.length > 1 && !(split1[0].toLowerCase().equals(nameSplit[0].toLowerCase() + "." + nameSplit[1].toLowerCase()) )      )        ) {
            throw new IllegalArgumentException("Invalid email address username. Name in email address must match entered name, and be of the form name@<somewhere>.<something> or firstname.surname@<somewhere>.<something>.");

        /* if the user's name is one word and the username for their email is not equal to this name when converted to lower case
           or if the user's name is two words and their email username isn't equal to firstname.lastname converted to lowercase */

        }
    }

    /* Email must be of form <username>@<something>.<somewhere>
       Check if the <something> (ie the domain) is blank, ie "" or " " */

    public void checkEmailDomainNull(String email){
        String[] split1 = email.split("@");
        String[] split2= split1[1].split("\\.");

        if(split2[0].equals("")){
            throw new IllegalArgumentException("Invalid email domain - cannot be null");
        }

        if(split2[0].equals(" ")){
            throw new IllegalArgumentException("Invalid email domain - cannot be null");
        }

    }

    // check if the <something> contains any special characters (can contain numbers)

    public void checkEmailDomainSpecialCharacters(String email){
        String[] split1 = email.split("@");
        String[] split2= split1[1].split("\\.");

        for(int i=0; i< split2[0].length(); i++){
            if( !  (   (Character.isLetter(split2[0].charAt(i) ) )   || Character.isDigit(split2[0].charAt(i) ) )  ){
                throw new IllegalArgumentException("Invalid email address domain - cannot contain special characters/ whitespace.");
            }

        }

    }

    // check if the domain extension, ie the .<somewhere>, is blank (ie "" or " ")

    public void checkEmailDomainExtensionNull(String email){
        String[] split1 = email.split("@"); // e.g. splitting john.scully@ucd.ie into "john.scully" "ucd.ie"
        String[] split2= split1[1].split("\\."); // then splitting "ucd.ie" into "ucd" "ie"

        if(split2.length == 1 ){
            throw new IllegalArgumentException("Invalid email domain extension- cannot be null");
        }
        /* if split2.length == 1 then in the example above either "ucd" or "ie" would have been blank or ""
        * Previous method would have thrown exception if the domain, or in this case the "ucd" was bank
        * Therefore, if split2.length == 1 then the domain extension (or the ie part) is blank */


        else if(split2[1].equals(" ")){
            throw new IllegalArgumentException("Invalid email domain extension- cannot be null");
        }
        // Throw exception if the domain extension is  " " (first if checked for if it was "", ie no whitespace)

    }

    // check if the domain extension is anything other than .ie or .com
    public void checkEmailValidExtension(String email){
        String[] split1 = email.split("@");
        String[] split2= split1[1].split("\\.");

        if(  ! ( (split2[ split2.length - 1 ].equals("ie") ) || (split2[ split2.length - 1 ].equals("com"))    ) ){
            throw new IllegalArgumentException("Invalid email domain extension. Email address must end in .com or .ie .");
        }
    }

    public String toString(){

        if(email == null && age == 0)
            return "CheckedUser: " + name;

        else if (email == null)
            return "CheckedUser: " + name + " (" + age + ")";

        else
            return "CheckedUser: " + name + " (" + age + "), " + email;
    }


}
