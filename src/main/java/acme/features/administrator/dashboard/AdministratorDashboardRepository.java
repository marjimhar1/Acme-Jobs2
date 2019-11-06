
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.datatypes.Money;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(*) from Announcement")
	Integer getTotalAnnouncement();

	@Query("select count(*) from CompanyRecord")
	Integer getTotalCompanyRecord();

	@Query("select count(*) from InvestorRecord")
	Integer getTotalInvestorRecord();

	@Query("select a.reward from Request a where a.reward.amount = (select min(reward.amount) from Request)")
	Money getMinRewardRequest();

	@Query("select a.reward from Request a where a.reward.amount = (select max(reward.amount) from Request)")
	Money getMaxRewardRequest();

	@Query("select avg(reward.amount) from Request")
	Double getAverageRewardRequestAmount();

	@Query("select a.reward.currency from Request a where a.reward.amount = (select max(reward.amount) from Request)")
	String getAverageRewardRequestCurrency();

	@Query("select stddev(reward.amount) from Request")
	Double getSdRewardRequestAmount();

	@Query("select a.minPrice from Offer a where a.minPrice.amount = (select min(minPrice.amount) from Offer)")
	Money getMinRewardOffer();

	@Query("select a.maxPrice from Offer a where a.maxPrice.amount = (select max(maxPrice.amount) from Offer)")
	Money getMaxRewardOffer();

	@Query("select avg(minPrice.amount + maxPrice.amount)/2 from Offer")
	Double getAverageRewardOfferAmount();

	@Query("select a.minPrice.currency from Offer a where a.minPrice.amount = (select min(minPrice.amount) from Offer)")
	String getAverageRewardOfferCurrency();

	@Query("select stddev(minPrice.amount) from Offer")
	Double getMinSdRewardRequestAmount();

	@Query("select stddev(maxPrice.amount) from Offer")
	Double getMaxSdRewardRequestAmount();

	@Query("select sector, count(*) from CompanyRecord group by sector")
	Collection<Object[]> getCompaniesPerSector();

	//@Query("select sector from CompanyRecord group by sector")
	//String[] getCompanySectors();
}
