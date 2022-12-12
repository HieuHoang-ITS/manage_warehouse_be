package com.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "statistician_flag")
    Boolean statisticianFlag;
    @Column(name = "order_flag")
    Boolean orderFlag;
    @Column(name = "approver_flag")
    Boolean approverFlag;
    @Column(name = "system_flag")
    Boolean systemFlag;
    @Column(name = "availibility_flag")
    Boolean availibilityFlag;
}
