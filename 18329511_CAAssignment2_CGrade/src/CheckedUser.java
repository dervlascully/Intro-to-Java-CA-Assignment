public class CheckedUser implements User {

    // C+ grade answer

    private String name;
    private String email;
    private int age;


    public CheckedUser(String name){  // Constructor for just name
        checkName(name);
        this.name = name;
    }

    public CheckedUser(String name, int age){  // Constructor for name and age
        this(name); // calls the constructor for name above
        checkAgeRange(age);

        this.age = age;
    }

    public CheckedUser(String name, int age, String email) {  // constructor for name, age and email
        this(name, age);
        checkEmail(name, email);
        this.email = email.toLowerCase(); // convert email to lowercase
    }

//    public CheckedUser(){
//        throw new IllegalArgumentException("Constructor with no parameters not available for this class");
//    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        checkEmail(this.name, email);
        this.email = email.toLowerCase();
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        checkAgeRange(age);
        this.age = age;
    }

    public void checkName(String name){
        checkNamePrefix(name);
        checkNameLength(name);
//        checkNameSpecialCharacter(name);
    }

    public void checkEmail(String name, String email){
        checkEmailMatchesName(name, email);
        checkEmailDomainNull(email);
        checkEmailDomainSpecialCharacters(email);
        checkEmailDomainExtensionNull(email);
        checkEmailValidExtension(email);
    }

    // Should check if the age entered is between 18 and 30 (inclusive)
    // wrong - checks if age is greater than 35

    public void checkAgeRange(int age){

        if(age > 35){
            throw new IllegalArgumentException();
        }
    }



    // Should check if name has a prefix
    // wrong - checks if name is equal to Mr, Mrs etc
    public void checkNamePrefix(String name){

        if( name.equals("Mr") || name.equals("Mrs") || name.equals("Ms") || name.equals("Miss") || name.equals("Dr")){
            throw new IllegalArgumentException();
        }
    }

    // should check if name is made up of more than 2 words
    // Wrong - checks if name is greater than 4 words

    public void checkNameLength(String name){
        String[] nameSplit = name.split(" ");

        if(nameSplit.length > 4){
            throw new IllegalArgumentException();

        }
    }
//
//    // Edge case: Check if a special character or a number was entered as a character in the name
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


    // check name in email matches name and is in the correct format

    public void checkEmailMatchesName(String name, String email){

        String[] split1 = email.split("@");  // eg splits "dervla.scully@ucdconnect.ie" into "dervla.scully" and "ucdconnect.ie" and stores these strings in an array
        String[] nameSplit = name.split(" "); // splits name

        if(     (nameSplit.length == 1 && ! ( split1[0].toLowerCase().equals(nameSplit[0].toLowerCase()))   )  ||    (  nameSplit.length > 1 && !(split1[0].toLowerCase().equals(nameSplit[0].toLowerCase() + "." + nameSplit[1].toLowerCase()) )      )        ) {
            throw new IllegalArgumentException();

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
        String[] split1 = email.split("@");
        String[] split2= split1[1].split("\\.");

        if(split2.length == 1 ){
            throw new IllegalArgumentException("Invalid email domain extension- cannot be null");
        }


        else if(split2[1].equals(" ")){
            throw new IllegalArgumentException("Invalid email domain extension- cannot be null");
        }

    }

    // check if the domain extension is anything other than .ie or .com
    public void checkEmailValidExtension(String email){
        String[] split1 = email.split("@");
        String[] split2= split1[1].split("\\.");
        if(  ! ( (split2[ split2.length - 1 ].equals("ie") ) || (split2[ split2.length - 1 ].equals("com"))    ) ){
            throw new IllegalArgumentException("Invalid email domain extension. Email address must end in .com or .ie .");
        }
    }

    /* Wrong - not format specified in question
    * e.g. "CheckedUser: John Scully (22), john.scully@ucd.ie */
    public String toString(){

        if(email == null && age == 0)
            return name;

        else if (email == null)
            return name + " " + age;

        else
            return name + " " + age + " " + email;
    }


}
