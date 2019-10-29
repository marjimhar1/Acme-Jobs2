
package acme.features.anonymous.announcement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousAnnouncementRepository extends AbstractRepository {

	@Query("select s from Announcement s where s.id=?1")
	Announcement findOneById(int id);

	@Query("select s from Announcement s where EXTRACT(MONTH FROM sysdate())-EXTRACT(MONTH FROM moment)<=ABS(1) and EXTRACT(YEAR FROM sysdate())=EXTRACT(YEAR FROM moment)")
	Collection<Announcement> findManyAll();
}
