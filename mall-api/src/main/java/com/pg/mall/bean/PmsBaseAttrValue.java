package com.pg.mall.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 *
 *
 * @Description: pmsBaseAttrInfo 的子表 对应attrinfo 的id 显示相关规格属性名字
 * @Param:
 * @return:
 * @Author: pg-7
 * @Date: 2020/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PmsBaseAttrValue implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String valueName;
    @Column
    private String attrId;
    @Column
    private String isEnabled;

    @Transient
    private String urlParam;

}
