package Logic;

import App.Model.MainModel;
import DAL.AccountDAO;
import Entity.Account;
import Entity.Staff;

import java.util.HashMap;

public class AccountManagement {
    private HashMap<String, Account> accountsTable;

    public AccountManagement() {
        init();
    }

    private void init(){
        accountsTable = AccountDAO.retrieve();
    }

    public HashMap<String, Account> getAccountsTable() {
        return accountsTable;
    }

    public void setAccountsTable(HashMap<String, Account> accountsTable) {
        this.accountsTable = accountsTable;
    }

    /**
     * find account by staff id
     * @param id staff's id
     * @return Account of staff
     */
    public Account findAccountByStaffId(String id){
        return accountsTable.get(id);
    }

    public void addAccount(Account acc, Staff staff) {
        accountsTable.put(staff.getStaffId(),acc);
        for (Staff st : MainModel.staffManager.getStaffList()){
            if(st.getStaffId().equals(staff.getStaffId())){
                st.setAccount(acc);
                break;
            }
        }
        AccountDAO.addAccount(staff.getStaffId(),acc);
    }
}
