package com.bowen.hogwarts.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import kotlin.BuilderInference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaobaowen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "user")
public class User {

  @TableId(type = IdType.AUTO)
  private Long id;

  private String name;

  private Integer age;

  private String idNo;

  private String gender;

  private Date createdTime;

  private Date updatedTime;

  private Boolean isActive;

}
