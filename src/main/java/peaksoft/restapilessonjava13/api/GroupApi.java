package peaksoft.restapilessonjava13.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapilessonjava13.dto.SimpleResponse;
import peaksoft.restapilessonjava13.dto.groupDto.GroupRequest;
import peaksoft.restapilessonjava13.dto.groupDto.GroupResponse;
import peaksoft.restapilessonjava13.dto.groupDto.SearchResponse;
import peaksoft.restapilessonjava13.dto.groupDto.UpdateGroupRequest;
import peaksoft.restapilessonjava13.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;
    @GetMapping("/getAll")
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroup();
    }

    @PostMapping()
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest){
        return groupService.saveGroup(groupRequest);
    }

    @GetMapping("/getById/{id}")
    public GroupResponse getGroupById(@PathVariable("id") Long id) {
        return groupService.getByIdGroup(id);
    }

    @PutMapping ("/update/{id}")
    public SimpleResponse updateGroup(@PathVariable("id") Long id,
                                      @RequestBody UpdateGroupRequest updateGroupRequest){
        return groupService.updateGroupById(id,updateGroupRequest);
    }

    @DeleteMapping("/delete/{id}")
    public SimpleResponse deleteCourse(@PathVariable("id") Long id){
        return groupService.deleteById(id);
    }

    @PostMapping("/assign/{studentId}/{groupId}")
    public SimpleResponse assignStudentToGroup(@PathVariable Long studentId,@PathVariable Long groupId){
        return groupService.assignStudentToGroup(studentId,groupId);
    }


    @GetMapping("/search")
    public List<SearchResponse> searchGroupByName (@RequestParam String word){
        return groupService.searchGroup(word);
    }
}
