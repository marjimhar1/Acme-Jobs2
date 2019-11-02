
package acme.entities.offers;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;

	@NotBlank
	private String				text;

	@Valid
	private Money				minPrice;

	@Valid
	private Money				maxPrice;

	@NotBlank
	@Pattern(regexp = "^[R][A-Z]{4}[-][0-9]{5}$")
	@Column(unique = true)
	private String				ticker;


	@Transient
	public String getRangePrice() {
		StringBuilder res;

		/*
		 * res = new StringBuilder();
		 * res.append(String.format("%.2f", this.minPrice.getAmount()));
		 * res.append(this.minPrice.getCurrency());
		 * res.append("-");
		 * res.append(String.format("%.2f", this.maxPrice.getAmount()));
		 * res.append(this.maxPrice.getCurrency());
		 */

		res = new StringBuilder();
		res.append(this.minPrice);
		res.append("-");
		res.append(this.maxPrice);

		return res.toString().replaceAll("[<][>]", "");
	}

}
