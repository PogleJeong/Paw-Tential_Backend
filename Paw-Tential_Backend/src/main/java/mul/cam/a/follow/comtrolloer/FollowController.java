package mul.cam.a.follow.comtrolloer;

import jakarta.servlet.http.HttpSession;
import mul.cam.a.follow.dto.FollowDto;
import mul.cam.a.follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class FollowController {

  @Autowired
  FollowService service;

  //팔로우 불러오기
  @GetMapping("/Follow")
  public String follow(HttpSession session, Model model){
    System.out.println("FollowController baseLayout" + new Date());

    FollowDto followDto = (FollowDto) session.getAttribute("login");
    //로그인 했을때
    if(followDto != null){
      List<FollowDto> follows = service.getAllFollowId(followDto.getFollow_id());
      for(FollowDto follow : follows){
        System.out.println(follows);
      }
      model.addAttribute("follow",follows);
    }
return "follow";


  }

}
