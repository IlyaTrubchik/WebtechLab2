package by.bsuir.webtech.ilya.entities;

public class User extends Entity{
    private Long id;

    private String email;
    private String passwordHash;
    private String name;

    private String phone;
    private String address;

    private int roleId;
    private String role;
    public User(){
    }

    public User(Long id,String Email,String Name,String passwordHash,String phone,String address,int roleId)
    {
        this.id = id;
        this.email = Email;
        this.name = Name;
        this.passwordHash = passwordHash;
        this.roleId = roleId;
        this.address = address;
        this.phone = phone;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public Long getId(){
        return  this.id;
    }
    public String getPasswordHash()
    {
        return  this.passwordHash;
    }
    public int getRoleId(){
        return  this.roleId;
    }

    public String getPhone(){return this.phone;}
    public String getAddress(){return this.address;}
    public void setRoleId(){

    }
    public String getRole()
    {
        return this.role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
}
