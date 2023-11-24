package by.bsuir.webtech.ilya.entities;

public class Role extends Entity {
    private String name;

    private Long id;
    public String getName()
    {
       return this.name;
    }
    public Long getId()
    {
        return this.id;
    }
    Role(){

    }
    public Role(Long id,String name)
    {
        this.id = id;
        this.name = name;
    }
}
