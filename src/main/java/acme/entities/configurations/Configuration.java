
package acme.entities.configurations;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends DomainEntity {

	private static final long	serialVersionUID	= 1L;
	@NotBlank
	private String				spamWords;

	private Double				spamThreshold;

}
