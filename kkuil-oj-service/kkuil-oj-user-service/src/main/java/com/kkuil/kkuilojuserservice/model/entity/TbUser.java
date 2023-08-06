package com.kkuil.kkuilojuserservice.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName tb_user
 */
@TableName(value = "tb_user")
@Data
public class TbUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户权限
     */
    @TableField(value = "role")
    private String role;

    /**
     * 是否逻辑删除(0：未删除 1：已删除)
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date created_time;

    /**
     * 最后一次修改时间
     */
    @TableField(value = "modified_time")
    private Date modified_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbUser other = (TbUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
                && (this.getIs_deleted() == null ? other.getIs_deleted() == null : this.getIs_deleted().equals(other.getIs_deleted()))
                && (this.getCreated_time() == null ? other.getCreated_time() == null : this.getCreated_time().equals(other.getCreated_time()))
                && (this.getModified_time() == null ? other.getModified_time() == null : this.getModified_time().equals(other.getModified_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getIs_deleted() == null) ? 0 : getIs_deleted().hashCode());
        result = prime * result + ((getCreated_time() == null) ? 0 : getCreated_time().hashCode());
        result = prime * result + ((getModified_time() == null) ? 0 : getModified_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", role=").append(role);
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", created_time=").append(created_time);
        sb.append(", modified_time=").append(modified_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}