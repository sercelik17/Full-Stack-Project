package yte.intern.data.project.asistan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.data.project.akademisyen.entity.Akademisyen;
import yte.intern.data.project.common.entity.BaseEntity;


import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Asistan extends BaseEntity {
    private String name;
    private String surname;
    private String username;//it'll be name and surname
    private String password;


    public Asistan(String name,
                   String surname,
                   String username,
                   String password
    ) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;

    }

    public void update(Asistan updatedAsistan) {
        this.name = updatedAsistan.name;
        this.surname = updatedAsistan.surname;
        this.password = updatedAsistan.password;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "akademisyen_id", referencedColumnName = "ID")
    private Akademisyen akademisyen;

}
