package callicoder.com.postgredemo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createAt", "updateAt"},
        allowGetters = true
)
@Getter
@Setter
public abstract class AuditModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -554052168307756436L;

    @Column(name = "create_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createAt;

    @Column(name = "update_at", nullable = false)
    @LastModifiedDate
    private LocalDate updateAt;
}
