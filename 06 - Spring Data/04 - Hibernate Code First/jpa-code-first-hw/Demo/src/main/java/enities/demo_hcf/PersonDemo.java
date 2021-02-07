package enities.demo_hcf;

import enities.BaseEntity;

import javax.persistence.*;

//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class PersonDemo extends BaseEntity {
    private String name;

    public PersonDemo() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public PersonDemo setName(String name) {
        this.name = name;
        return this;
    }
}
