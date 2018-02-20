package com.flatislove.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private int positionId;
    @Column(name = "position_name")
    private String positionName;
    @Column(name = "position_role")
    private String positionRole;

    public Position(String positionName) {
        this.positionName = positionName;
    }
}
