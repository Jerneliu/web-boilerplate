package github.yukinami.webboilerplate.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Actions, operations of domain
 *
 * @author snowblink on 15/11/4.
 */
@Entity
@Table(name = "todos")
public class Todo extends TodoEntity {

}
