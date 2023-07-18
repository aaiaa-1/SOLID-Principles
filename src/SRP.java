
//we have a class called User that handles both user data storage and user authentication.
// Initially, the code violates the Single Responsibility Principle (SRP), and then we'll refactor it to adhere to the principle.

//        Before applying SRP:

class UserNoSRP {
    private String username;
    private String password;

    public void createUser(String username, String password) {
        // Save user data to database
        this.username = username;
        this.password = password;
    }

    public boolean authenticateUser(String username, String password) {
        // Authenticate user by checking credentials in the database
        return (this.username.equals(username) && this.password.equals(password));
    }
}


//    In the code above, the User class has two responsibilities: creating a user by saving the data to the database and authenticating a user by checking credentials in the database.
//    This violates the SRP because the class has more than one reason to change.

//        After applying SRP:

class User {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and other user-related methods

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class UserRepository {
    public void saveUser(User user) {
        // Save user data to database
    }
}

class UserAuthenticator {
    public boolean authenticateUser(User user, String username, String password) {
        // Authenticate user by checking credentials in the database
        return (user.getUsername().equals(username) && user.getPassword().equals(password));
    }
}

//In the refactored code, we separate the responsibilities of storing user data and authenticating users into separate classes.
