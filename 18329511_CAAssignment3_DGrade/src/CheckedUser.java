public class CheckedUser implements User {

    // D+ grade answer

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
    }

    public void checkEmail(String name, String email){
        checkEmailMatchesName(name, email);

// `Wrong - Does not contain any of these methods for checking validity of email
//        checkEmailDomainNull(email);
//        checkEmailDomainSpecialCharacters(email);
//        checkEmailDomainExtensionNull(email);
//        checkEmailValidExtension(email);
    }

    // Should check if the age entered is between 18 and 30 (inclusive)
    // wrong, checks if age is greater than 35

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

    // Should check if name is made up of more than 2 words
    // Wrong - checks if name is greater than 4 words

    public void checkNameLength(String name){
        String[] nameSplit = name.split(" ");

        if(nameSplit.length > 4){
            throw new IllegalArgumentException();

        }
    }


    // check name in email matches name and is in the correct format

    public void checkEmailMatchesName(String name, String email){

        String[] split1 = email.split("@");  // eg splits "dervla.scully@ucdconnect.ie" into "dervla.scully" and "ucdconnect.ie" and stores these strings in an array
        String[] nameSplit = name.split(" "); // splits name

        if(     (nameSplit.length == 1 && ! ( split1[0].toLowerCase().equals(nameSplit[0].toLowerCase()))   )  ||    (  nameSplit.length > 1 && !(split1[0].toLowerCase().equals(nameSplit[0].toLowerCase() + "." + nameSplit[1].toLowerCase()) )      )        ) {
            throw new IllegalArgumentException();

        }
    }


// Wrong form - not form specified in question
    public String toString(){

        if(email == null && age == 0)
            return name;

        else if (email == null)
            return name + " " + age;

        else
            return name + " " + age + " " + email;
    }


}
