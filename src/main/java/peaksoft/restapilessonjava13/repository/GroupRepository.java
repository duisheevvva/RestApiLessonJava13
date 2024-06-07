package peaksoft.restapilessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapilessonjava13.dto.groupDto.GroupResponse;
import peaksoft.restapilessonjava13.dto.groupDto.SearchResponse;
import peaksoft.restapilessonjava13.enitity.Group;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    @Query("select new peaksoft.restapilessonjava13.dto.groupDto.GroupResponse(g.id,g.groupName,g.imageLink,g.description) from Group g")
    List<GroupResponse> getAllGroups();



    List<SearchResponse> searchGroupsByGroupName(String word);

}
