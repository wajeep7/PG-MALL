package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @param
 * @return
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsBaseSaleAttr implements Serializable {

    @Id
    @Column
    String id ;

    @Column
    String name;

}