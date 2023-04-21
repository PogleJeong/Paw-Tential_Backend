package mul.cam.a.follow.comtrolloer;

import jakarta.servlet.http.HttpSession;
import mul.cam.a.follow.dto.FollowDto;
import mul.cam.a.follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FollowController {

  @Autowired
  FollowService service;

  //팔로우 불러오기
  @GetMapping("/{userId}/Follow")
  public List<FollowDto> getFollowByToUser(@PathVariable String userId) {
    System.out.println("FollowController baseLayout" + new Date());

    return service.getAllToUsers(userId);
  }

  @PostMapping("/Follow") //팔로우insert
  public void addFollowToUser(@RequestBody FollowDto followDto) {
    System.out.println("FollowController baseLayout" + new Date());

    service.addFollowToUser(followDto);
  }

  @PutMapping("{seq}/Follow") //update
  public void updateFollowToUser(@PathVariable Integer seq, @RequestBody FollowDto followDto) {
    System.out.println("FollowController baseLayout" + new Date());

    service.updateFollow(seq, followDto);
  }

  @DeleteMapping("/{seq}/Follow") //delete
  public void deleteFollowToUser(@PathVariable Integer seq) {
    System.out.println("FollowController baseLayout" + new Date());

    //service.delete(seq);
  }
}
