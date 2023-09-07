package zhanuzak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zhanuzak.entity.Group;
import zhanuzak.dto.response.GroupResponse;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select new zhanuzak.dto.response.GroupResponse(g.groupName,g.imageLink,g.description) from Group g")
    List<GroupResponse> findAllGroups();

    GroupResponse findGroupById(Long id);
//
//    @Query(value = "select count(*) from students s join groups g on g.id = s.group_id where g.id=:groupId;", nativeQuery = true)
//    int counterStudents(@Param("id") Long groupId);
}
