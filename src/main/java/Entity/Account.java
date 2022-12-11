package Entity;

public class Account {

    private String username;
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password Mật khẩu cần kiểm tra - Password need to check
     * @return True nếu mật khẩu đưa vào là hợp lệ; False nếu Mật khẩu đưa vào sai - True if correct else False
     */
    public boolean isCorrectPassword(String password){
        return password.equals(this.password);
    }
}
