
package com.zp.sys.model.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 部门管理
 * 
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Table("sys_dept")
public class SysDeptEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/**
	 * 上级ID
	 */
	private Long pid;
	/**
	 * 所有上级ID，用逗号分开
	 */
	private String pids;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 更新者
	 */
	private Long updater;
	/**
	 * 更新时间
	 */
	@Column(onUpdateValue = "now()")
	private Date updateDate;
	/**
	 * 上级部门名称
	 */

	private String parentName;

}