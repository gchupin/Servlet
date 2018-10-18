public class Login {
    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Boolean isEqual (Login otherLogin)
    {
        return this.username.equals(otherLogin.username) && this.password.equals(otherLogin.password);
    }
}