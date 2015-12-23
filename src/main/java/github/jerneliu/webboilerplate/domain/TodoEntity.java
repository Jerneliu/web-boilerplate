package github.jerneliu.webboilerplate.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author snowblink on 15/11/3.
 */
@MappedSuperclass
public class TodoEntity extends BaseEntity {

    @NotEmpty
    @Column
    public String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
