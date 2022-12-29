package FetchList.Controller;

//import FetchList.FetchList;
import FetchList.FetchList;
import FetchList.Model.FetchList1;
import FetchList.Service.FetchListServiceImpl;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FetchListController {

    @Autowired
    private FetchListServiceImpl fetchListService;
//    ----------------------------------------------------------------------------------------------------

    @RequestMapping("/new")
    public String showNewForm(Model model) {
//        Sale sale = new Sale();
        FetchList1 fetchList1 =new FetchList1();
        model.addAttribute("fetchList1", fetchList1);
        return "New";
    }
//
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("register") FetchList1 fetchList1) {
       fetchListService.insertMen(fetchList1);
        return "redirect:/";
    }
//
//

//@GetMapping("/new")
//public String newPage(){
//    return "New";
//
// }
//--------------------------------------------------------------------------------------------------------
    @GetMapping("/fetchList" )
    String deleteOneStudent( Model model){
        model.addAttribute("listStudent", fetchListService.fetchList());
//              return webAppService.deleteStudentList(id);
        return "index";
    }

    @GetMapping ("/" )
    String dashBoard(Model model){
        model.addAttribute("name","ankit");
        return "redirect:/fetchList";
    }


    @RequestMapping("/DeleteStudent/{id}")
     public String deleteData(@PathVariable(name="id") int id ){
        fetchListService.deleteData(id);
        return "redirect:/";
    }
}
