package com.junkfoood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "address")
    private String address;

    //    @ManyToOne( cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE})
    @ManyToOne
    @JoinColumn(name = "username")
    private AccountEntity account;

    @JsonIgnore
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetails;
}
