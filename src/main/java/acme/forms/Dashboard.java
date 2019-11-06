
package acme.forms;

import java.io.Serializable;

import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						totalAnnouncements;
	Integer						totalCompanyRecords;
	Integer						totalInvestorRecords;

	Money						minRewardRequest;
	Money						maxRewardRequest;
	Money						averageRewardRequest;
	Money						sdRewardRequest;

	Money						minRewardOffer;
	Money						maxRewardOffer;
	Money						averageRewardOffer;
	Money						sdMinRewardOffer;
	Money						sdMaxRewardOffer;
}
