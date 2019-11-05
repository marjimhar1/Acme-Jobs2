
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public abstract class Banner extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				pictureUrl;

	@NotBlank
	private String				slogan;

	@NotBlank
	private String				targetUrl;

}
