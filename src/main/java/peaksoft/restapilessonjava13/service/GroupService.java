package peaksoft.restapilessonjava13.service;


import peaksoft.restapilessonjava13.dto.SimpleResponse;
import peaksoft.restapilessonjava13.dto.groupDto.GroupRequest;
import peaksoft.restapilessonjava13.dto.groupDto.GroupResponse;
import peaksoft.restapilessonjava13.dto.groupDto.SearchResponse;
import peaksoft.restapilessonjava13.dto.groupDto.UpdateGroupRequest;

import java.util.List;

public interface GroupService {
    SimpleResponse saveGroup( GroupRequest groupRequest);

    List<GroupResponse> getAllGroup();

    GroupResponse getByIdGroup(Long id);

    SimpleResponse updateGroupById(Long id, UpdateGroupRequest updateGroupRequest) ;

    SimpleResponse deleteById(Long id) ;

    SimpleResponse assignStudentToGroup(Long studentId,Long groupId);

    List<SearchResponse> searchGroup(String word);

}
